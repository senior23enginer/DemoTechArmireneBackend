package com.armirene.demotech.repository;

import com.armirene.demotech.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

    public boolean existsByEmail(String mail);

}
