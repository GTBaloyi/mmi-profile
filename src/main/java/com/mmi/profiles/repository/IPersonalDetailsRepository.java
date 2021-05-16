package com.mmi.profiles.repository;

import com.mmi.profiles.entity.Personal;
import com.mmi.profiles.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonalDetailsRepository extends JpaRepository<Personal, Integer> {
    Personal findOneByUserId(User userId);
}
