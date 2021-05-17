package com.mmi.profiles.controller;

import com.mmi.profiles.model.AllDetailsModel;
import com.mmi.profiles.model.PersonalDetailsModel;
import com.mmi.profiles.service.IPersonalDetailsService;
import com.mmi.profiles.service.impl.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("personal_details/v1.0")
public class PersonalDetailsController {

    @Autowired
    private IPersonalDetailsService personalDetailsService;

    @RequestMapping(value = "/person/{username}", method = RequestMethod.GET)
    public ResponseEntity<PersonalDetailsModel> getPersonDetails(@PathVariable String username) {
        try{
            return new ResponseEntity(personalDetailsService.getPersonalDetails(username), HttpStatus.ACCEPTED);
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    public ResponseEntity<PersonalDetailsModel> updatePersonDetails(@RequestBody PersonalDetailsModel personDetails) {
        try{
            if(personalDetailsService.updatePersonalDetails(personDetails)) {
                return new ResponseEntity<>(HttpStatus.OK);
            }else {
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/profile_picture/{username}", method = RequestMethod.PUT)
    public ResponseEntity<PersonalDetailsModel> updateProfilePicture(@PathVariable String username,@RequestParam MultipartFile profilePicture) {
        try{
            if(personalDetailsService.updateProfilePicture(username, profilePicture)) {
                return new ResponseEntity<>(HttpStatus.OK);
            }else {
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/all-info/{username}", method = RequestMethod.GET)
    public ResponseEntity<HttpStatus> updateAllInfo(@PathVariable String username) {
        try{
            AllDetailsModel allDetailsModel = personalDetailsService.getAllInfo(username);
            if(allDetailsModel != null) {
                return new ResponseEntity(allDetailsModel,HttpStatus.OK);
            }
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/all-info", method = RequestMethod.PUT)
    public ResponseEntity updateAllInfo(@RequestBody AllDetailsModel allDetailsModel) {
        try{
            if(personalDetailsService.updateAllInfo(allDetailsModel)) {
                return new ResponseEntity(HttpStatus.OK);
            }
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
