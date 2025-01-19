package com.mustafaiev.tymur.securityservice.repository;

import com.mustafaiev.tymur.securityservice.entity.OAuth2Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OAuth2ClientRepository extends JpaRepository<OAuth2Client, Long> {

    OAuth2Client findByClientId(String clientId);
}