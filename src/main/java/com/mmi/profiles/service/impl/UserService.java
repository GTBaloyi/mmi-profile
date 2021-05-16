package com.mmi.profiles.service.impl;

import com.mmi.profiles.entity.Personal;
import com.mmi.profiles.entity.User;
import com.mmi.profiles.model.RegisterUserModel;
import com.mmi.profiles.repository.IPersonalDetailsRepository;
import com.mmi.profiles.repository.IUserRepository;
import com.mmi.profiles.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IPersonalDetailsRepository personalDetailsRepository;

    @Override
    public boolean login(String username, String password)
    {
        User user = userRepository.findOneByUsername(username);
        if(user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean createUser(RegisterUserModel data) {


        User user = new User(data.getUsername(), data.getPassword());
        userRepository.save(user);

        String profilePicturePath = savePicture(data.getProfilePicture(), data.getUsername());
        Personal personal = new Personal(data.getFirstName(),
                data.getLastName(),profilePicturePath,"", "", user);
        personalDetailsRepository.save(personal);

        return true;
    }

    private String savePicture(MultipartFile profilePicture, String username) {
        String fileExtension = profilePicture.getOriginalFilename().split("\\.")[1];
        String pictureDir = "C:\\tmp\\"+username+"."+fileExtension;
        File file = new File(pictureDir);
        try(FileOutputStream outputStream = new FileOutputStream(file)){
            outputStream.write(profilePicture.getBytes());
            return pictureDir;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }
}
