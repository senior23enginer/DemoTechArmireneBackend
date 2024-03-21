package com.armirene.demotech.service;

import com.armirene.demotech.document.UsersSalesForce;
import com.armirene.demotech.entity.Users;
import com.armirene.demotech.repository.UsersRepository;
import com.armirene.demotech.repository.UsersSalesForceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersSalesForceRepository usersSalesForceRepository;

    @Autowired
    UsersRepository usersRepository;

    @Transactional
    public Users createUser( Users users){
        if (!usersRepository.existsByEmail(users.getEmail())){
            try {
                usersSalesForceRepository.save( this.converterUserSalesForce( users ) );
                return usersRepository.save(users);
            }catch (Exception e){throw e;}
        }else return null;
    }

    @Transactional
    public Users updateUser(Users users){

        Users userDB = usersRepository.findById(users.getId()).orElse(null);
        UsersSalesForce userSalesDB = usersSalesForceRepository.findByEmail( userDB.getEmail() );
        if (null == userDB){
            return null;
        }

        if (null == userSalesDB){
            userSalesDB = new UsersSalesForce();
        }
        userDB.setFirstName(users.getFirstName());
        userDB.setLastName(users.getLastName());
        userDB.setEmail(users.getEmail());
        userDB.setId(users.getId());
System.out.println( userDB);
        System.out.println( users);
        userSalesDB.setName(users.getFirstName().concat(" "+users.getLastName()));
        userSalesDB.setEmail(users.getEmail());

        usersSalesForceRepository.save( userSalesDB );
        return usersRepository.save(userDB);

    }

    public Users getUser(int id) {
        return usersRepository.findById(id).orElse(null);
    }

    public UsersSalesForce getUserSalesForce(String id) {
        return usersSalesForceRepository.findById(id).orElse(null);
    }


    public UsersSalesForce converterUserSalesForce(Users model){
        UsersSalesForce usersSalesForce = new UsersSalesForce(null, model.getFirstName(),"SALES_FORCE",model.getEmail());
        return usersSalesForce;
    }



}
