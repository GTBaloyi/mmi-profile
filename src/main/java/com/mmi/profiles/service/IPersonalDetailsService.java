package com.mmi.profiles.service;

import com.mmi.profiles.model.PersonalDetailsModel;
import org.springframework.web.multipart.MultipartFile;

public interface IPersonalDetailsService {
    PersonalDetailsModel getPersonalDetails(String idNumber);
    boolean updatePersonalDetails(PersonalDetailsModel personalDetails);
    boolean updateProfilePicture(String username, MultipartFile profilePicture);
}
