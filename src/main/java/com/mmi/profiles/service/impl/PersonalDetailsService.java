package com.mmi.profiles.service.impl;

import com.mmi.profiles.entity.Education;
import com.mmi.profiles.entity.Personal;
import com.mmi.profiles.entity.User;
import com.mmi.profiles.model.AllDetailsModel;
import com.mmi.profiles.model.EducationDetailsModel;
import com.mmi.profiles.model.PersonalDetailsModel;
import com.mmi.profiles.repository.IEducationRepository;
import com.mmi.profiles.repository.IPersonalDetailsRepository;
import com.mmi.profiles.repository.IUserRepository;
import com.mmi.profiles.service.IPersonalDetailsService;
import com.mmi.profiles.util.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

@Service
public class PersonalDetailsService implements IPersonalDetailsService {
    @Autowired
    private IPersonalDetailsRepository personalDetailsRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IEducationRepository educationRepository;

    @Override
    public PersonalDetailsModel getPersonalDetails(String username) {
        User user = userRepository.findOneByUsername(username);
        Personal personEntity = personalDetailsRepository.findOneByUserId(user);
        if(personEntity != null) {
            return new PersonalDetailsModel(personEntity.getName(), personEntity.getSurname(),personEntity.getPicturePath(),personEntity.getAboutMe(),personEntity.getInterests(), username);
        }

        return null;
    }

    @Override
    public boolean updatePersonalDetails(PersonalDetailsModel personalDetails) {
       Personal person = personalDetailsRepository.findOneByUserId(userRepository.findOneByUsername(personalDetails.getUsername()));
       if(person != null) {
           person.setAboutMe(personalDetails.getAboutMe());
           person.setInterests(personalDetails.getInterests());
           person.setName(personalDetails.getInterests());
           person.setSurname(personalDetails.getSurname());
           personalDetailsRepository.save(person);
           return true;
       } else {
           return false;
       }
    }

    @Override
    @Transactional
    public boolean updateProfilePicture(String username, MultipartFile profilePicture) {
        try{
            Personal person = personalDetailsRepository.findOneByUserId(userRepository.findOneByUsername(username));
            Commons commonMethods = new Commons();
            String oldPath = person.getPicturePath();
            person.setPicturePath(commonMethods.savePicture(profilePicture, username));
            personalDetailsRepository.save(person);
            //remove old profile picture
            commonMethods.deleteOldProfile(oldPath);

            return true;
        }
        catch (Exception e) {
            return false;
        }

    }

    @Override
    @Transactional
    public boolean updateAllInfo(AllDetailsModel allDetailsModel) {
        User user = userRepository.findOneByUsername(allDetailsModel.getUsername());
        Personal person = personalDetailsRepository.findOneByUserId(user);
        person.setInterests(allDetailsModel.getInterests());
        person.setName(allDetailsModel.getName());
        person.setSurname(allDetailsModel.getSurname());
        person.setAboutMe(allDetailsModel.getAboutMe());
        personalDetailsRepository.save(person);

        List<Education> educations = educationRepository.findAllByPerson(person);
        for(EducationDetailsModel edu: allDetailsModel.getEducation()) {
            Education editEducation = educations.stream().filter(e -> e.getId() == edu.getId()).collect(Collectors.toList()).get(0);
            if(editEducation != null) {
                editEducation.setCompleted(edu.isCompleted());
                editEducation.setEndDate(edu.getEndDate());
                editEducation.setInstitutionName(edu.getInstitutionName());
                editEducation.setQualification(edu.getQualification());
                editEducation.setStartDate(edu.getStartDate());
                educationRepository.save(editEducation);
            }
        }

        return true;
    }

    @Override
    public AllDetailsModel getAllInfo(String username) {

        User user = userRepository.findOneByUsername(username);
        if(user != null) {
            Personal person = personalDetailsRepository.findOneByUserId(user);
            if(person !=null) {
                List<Education> education = educationRepository.findAllByPerson(person);
                List<EducationDetailsModel> myEducation = new ArrayList<>();
                for(Education edu: education) {
                    myEducation.add(new EducationDetailsModel(edu.getId(),username,edu.getQualification(),edu.getInstitutionName(),edu.getStartDate(),edu.getEndDate(),edu.isCompleted()));
                }
                return new AllDetailsModel(person.getName(),person.getSurname(),person.getPicturePath(),person.getAboutMe(),person.getInterests(),username,myEducation);
            }
        }


        return null;
    }


}
