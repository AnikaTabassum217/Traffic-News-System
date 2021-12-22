package com.example.trafficnewssystem.Repository;

import com.example.trafficnewssystem.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByNews(String news);


}

