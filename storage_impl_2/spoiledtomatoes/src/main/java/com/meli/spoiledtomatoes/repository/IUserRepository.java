package com.meli.spoiledtomatoes.repository;

import com.meli.spoiledtomatoes.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
