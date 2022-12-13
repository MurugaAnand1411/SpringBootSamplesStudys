package com.rubixtek.rubixbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubixtek.rubixbooks.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
