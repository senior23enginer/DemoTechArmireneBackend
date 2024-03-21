package com.armirene.demotech.services;

import com.armirene.demotech.document.UsersSalesForce;
import com.armirene.demotech.entity.Users;
import com.armirene.demotech.repository.UsersRepository;
import com.armirene.demotech.repository.UsersSalesForceRepository;
import com.armirene.demotech.service.UsersService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.util.Optional;

@SpringBootTest
public class UsersServicesTest {

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private UsersSalesForceRepository usersSalesForceRepository;

    @Autowired
    private UsersService usersService;



    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        Users userModel = new Users(21,"michael","jordan","michael12er@gmail.com");
        UsersSalesForce userModelSales = new UsersSalesForce("21","michael jordan","SALES","michael12er@gmail.com");
        Mockito.when(usersRepository.findById(21))
                .thenReturn(Optional.of(userModel));
        Mockito.when(usersRepository.save(userModel)).thenReturn(userModel);
        Mockito.when(usersSalesForceRepository.save(userModelSales)).thenReturn(userModelSales);




    }

    @Test
    public void whenValidGetID_ThenReturnUser(){
        Users found = usersService.getUser(1);
        Assertions.assertThat(found.getEmail()).isEqualTo("mc2394q23@gmail.com");
    }

    @Test
    public void whenValidGetID_ThenReturnUserSales(){
        UsersSalesForce found = usersService.getUserSalesForce("65fbd85e9dbd8d36c5324333");
        Assertions.assertThat(found.getEmail()).isEqualTo("mc2394q23@gmail.com");
    }

    @Test
    public void whenValidUpdateFields_ThenReturnUser(){
        Users userUpdate = usersService.updateUser(new Users(2,"leidy","marin","marinleidyvannesa@gmail.com"));
    }

    @Test
    public void whenValidCreate_ThenReturnUser(){
        Users userUpdate = usersService.createUser(new Users(41,"miguel","juniro","junior22@gmail.com"));
System.out.println(userUpdate);
        Assertions.assertThat(userUpdate.getEmail()).isEqualTo("junior22@gmail.com");
    }



}
