package com.example.FarmUp.KATHAROS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FarmUp.KATHAROS.Bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
