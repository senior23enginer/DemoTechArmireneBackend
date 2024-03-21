package com.armirene.demotech.service;

import com.armirene.demotech.document.UsersSalesForce;
import com.armirene.demotech.entity.Student;
import com.armirene.demotech.document.Course;
import com.armirene.demotech.entity.Users;
import com.armirene.demotech.model.StudentModel;
import com.armirene.demotech.repository.UsersRepository;
import com.armirene.demotech.repository.UsersSalesForceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsersService {

    @Autowired
    UsersSalesForceRepository usersSalesForceRepository;

    @Autowired
    UsersRepository usersRepository;

    @Transactional
    public String createUser(Users users){
        if (!usersRepository.existsByEmail(users.getEmail())){
            try {
                usersRepository.save( users );
                usersSalesForceRepository.save( this.converterUserSalesForce( users ) );
            }catch (Exception e){
                throw e;
            }
            return "Resource added successfully!";
        }else {
            return "Duplicate resource";
        }
    }


    public UsersSalesForce converterUserSalesForce(Users model){
        UsersSalesForce usersSalesForce = new UsersSalesForce(null, model.getFirstName(),"SALES_FORCE",model.getEmail());
        return usersSalesForce;
    }



}
