package com.mmi.profiles.service;
import java.util.*;
import com.mmi.profiles.model.EducationDetailsModel;

public interface IEducationService {
    boolean createEducation(List<EducationDetailsModel> educations);
    boolean deleteEducation(int id);
}
