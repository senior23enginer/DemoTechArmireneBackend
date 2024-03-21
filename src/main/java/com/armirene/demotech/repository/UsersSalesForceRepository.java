package com.armirene.demotech.repository;

import com.armirene.demotech.document.UsersSalesForce;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersSalesForceRepository extends MongoRepository<UsersSalesForce, String> {


    public UsersSalesForce findByEmail(String name);

}
