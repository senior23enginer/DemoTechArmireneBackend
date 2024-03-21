package com.armirene.demotech.repository;

import com.armirene.demotech.document.UsersSalesForce;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersSalesForceRepository extends MongoRepository<UsersSalesForce, String> {

}
