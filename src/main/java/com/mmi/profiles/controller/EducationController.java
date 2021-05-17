package com.mmi.profiles.controller;

import com.mmi.profiles.model.AllDetailsModel;
import com.mmi.profiles.model.EducationDetailsModel;
import com.mmi.profiles.model.PersonalDetailsModel;
import com.mmi.profiles.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping(name = "education/v1.0")
public class EducationController {
    @Autowired
    private IEducationService educationService;

    @RequestMapping(value = "/education", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> createEducation(@RequestBody List<EducationDetailsModel> educationDetailsModel) {
        try{
            if(educationService.createEducation(educationDetailsModel)) {
                return new ResponseEntity(HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.CONFLICT);
            }
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/education/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteEducation(@PathVariable int id) {
        try{
            if(educationService.deleteEducation(id)) {
                return new ResponseEntity(HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.CONFLICT);
            }
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
