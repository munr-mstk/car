package com.munirmustakoglu.car.repository;

import com.munirmustakoglu.car.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username); // Veritabanına git ve username i şu olan user ı bana getir
}
