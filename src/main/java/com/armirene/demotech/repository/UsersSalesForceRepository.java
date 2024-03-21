package com.armirene.demotech.repository;

import com.armirene.demotech.document.UsersSalesForce;
import com.armirene.demotech.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersSalesForceRepository extends MongoRepository<UsersSalesForce, String> {

    public UsersSalesForce findByName(String name);

    public UsersSalesForce findByEmail(String name);

}
