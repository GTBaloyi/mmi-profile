package com.mmi.profiles.repository;

import com.mmi.profiles.entity.Education;
import com.mmi.profiles.entity.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface IEducationRepository extends JpaRepository<Education, Integer> {
    List<Education> findAllByPerson(Personal person);
}
