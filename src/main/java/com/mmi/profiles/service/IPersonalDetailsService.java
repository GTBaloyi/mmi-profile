package com.mmi.profiles.service;

import com.mmi.profiles.model.AllDetailsModel;
import com.mmi.profiles.model.PersonalDetailsModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

public interface IPersonalDetailsService {
    PersonalDetailsModel getPersonalDetails(String idNumber);
    boolean updatePersonalDetails(PersonalDetailsModel personalDetails);
    boolean updateProfilePicture(String username, MultipartFile profilePicture);
    boolean updateAllInfo(AllDetailsModel allDetailsModel);
    AllDetailsModel getAllInfo(String username);

}
