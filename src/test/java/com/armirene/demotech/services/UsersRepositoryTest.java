package com.armirene.demotech.services;

import com.armirene.demotech.entity.Users;
import com.armirene.demotech.repository.UsersSalesForceRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class UsersRepositoryTest {

    @Autowired
    private com.armirene.demotech.repository.UsersRepository usersRepository;

    @Autowired
    private UsersSalesForceRepository usersSalesForceRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void whenFindByUser_thenReturnUserDatabase(){
        Users userModel = new Users(66,"michael","jordan","66@gmail.com");
        usersRepository.save(userModel);

        Optional<Users> founds= usersRepository.findById(userModel.getId());

        Assertions.assertThat(founds.get().getId()).isEqualTo(66);


    }
}
