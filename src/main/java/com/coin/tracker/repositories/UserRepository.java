package com.coin.tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coin.tracker.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
