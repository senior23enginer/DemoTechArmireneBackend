package com.armirene.demotech.services;

import com.armirene.demotech.document.UsersSalesForce;
import com.armirene.demotech.entity.Users;
import com.armirene.demotech.service.UsersService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class utilTest {

    @InjectMocks
    private UsersService usersService;

    @Test
    public void whenModelUser_Converter_ThenReturnUserSales(){
        UsersSalesForce found = usersService.converterUserSalesForce(new Users(51,"carlos","torres","torres@gmail.com"));
        Assertions.assertThat(found.getName()).isEqualTo("carlos torres");
    }

}
