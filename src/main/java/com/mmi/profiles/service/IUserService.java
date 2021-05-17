package com.mmi.profiles.service;

import com.mmi.profiles.model.AllDetailsModel;
import com.mmi.profiles.model.RegisterUserModel;
import org.springframework.web.multipart.MultipartFile;

public interface IUserService {
    boolean login(String username, String password);
    boolean createUser(RegisterUserModel data);
}
