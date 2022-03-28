package com.example.test.repositories;

import com.example.test.models.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, String> {
    ConfirmationToken findByConfirmationToken(String confirmationToken);

}
