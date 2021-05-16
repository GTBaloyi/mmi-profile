package com.mmi.profiles.service.impl;

import com.mmi.profiles.entity.Personal;
import com.mmi.profiles.entity.User;
import com.mmi.profiles.model.PersonalDetailsModel;
import com.mmi.profiles.repository.IPersonalDetailsRepository;
import com.mmi.profiles.repository.IUserRepository;
import com.mmi.profiles.service.IPersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PersonalDetailsService implements IPersonalDetailsService {
    @Autowired
    private IPersonalDetailsRepository personalDetailsRepository;

    @Autowired
    private IUserRepository userRepository;

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
    public boolean updateProfilePicture(String username, MultipartFile profilePicture) {
        return false;
    }
}
