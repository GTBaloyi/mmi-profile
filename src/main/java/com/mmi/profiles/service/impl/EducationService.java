package com.mmi.profiles.service.impl;

import com.mmi.profiles.entity.Education;
import com.mmi.profiles.entity.Personal;
import com.mmi.profiles.entity.User;
import com.mmi.profiles.model.EducationDetailsModel;
import com.mmi.profiles.repository.IEducationRepository;
import com.mmi.profiles.repository.IPersonalDetailsRepository;
import com.mmi.profiles.repository.IUserRepository;
import com.mmi.profiles.service.IEducationService;
import com.mmi.profiles.service.IPersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService implements IEducationService {

    @Autowired
    private IEducationRepository educationRepository;

    @Autowired
    private IPersonalDetailsRepository personalDetailsRepository;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean createEducation(List<EducationDetailsModel> educations) {
        for(EducationDetailsModel education: educations) {
            User user = userRepository.findOneByUsername(education.getUsername());
            if(user !=null ) {
                Personal person = personalDetailsRepository.findOneByUserId(user);
                if(person != null) {
                    educationRepository.save(new Education(education.getQualification(), education.getInstitutionName(),education.getStartDate(),
                            education.getEndDate(),education.isCompleted(), person));
                    return true;
                }
            }

        }

        return false;
    }

    @Override
    public boolean deleteEducation(int id) {
        Optional<Education> education = educationRepository.findById(id);
       if( education != null){
           educationRepository.delete(education.get());
           return true;
       }

       return false;
    }
}
