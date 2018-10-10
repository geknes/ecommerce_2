package com.hackmonkey.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hackmonkey.ecommerce.entity.User;

@RepositoryRestResource(path="/users")
public interface UserRepository extends JpaRepository<User, Long>{

}
