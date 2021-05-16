package com.mmi.profiles.controller;

import com.mmi.profiles.model.AllDetailsModel;
import com.mmi.profiles.model.PersonalDetailsModel;
import com.mmi.profiles.model.RegisterUserModel;
import com.mmi.profiles.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(name = "/users/v1.0")
public class UsersController {
    @Autowired
    private  IUserService userService;



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity getUsers(@RequestParam String username, @RequestParam String password) {
        if( userService.login(username,password)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<HttpStatus> createUser(@RequestParam String username,
                                                 @RequestParam String password,
                                                 @RequestParam String firstName,
                                                 @RequestParam String lastName,
                                                 @RequestParam MultipartFile profilePicture) {
        try{
            if(userService.createUser(new RegisterUserModel(firstName,lastName,username,password,profilePicture))) {
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.CONFLICT);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/all-info", method = RequestMethod.PUT)
    public ResponseEntity<PersonalDetailsModel> updateProfilePicture(@RequestBody AllDetailsModel allDetailsModel) {
        try{
            /*if(personalDetailsService.updateProfilePicture(username, profilePicture)) {
                return new ResponseEntity<>(HttpStatus.OK);
            }else {
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }*/
            return null;
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
