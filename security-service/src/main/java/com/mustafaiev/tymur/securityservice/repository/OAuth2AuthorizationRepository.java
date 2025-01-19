package com.mustafaiev.tymur.securityservice.repository;

import com.mustafaiev.tymur.securityservice.entity.OAuth2Authorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface OAuth2AuthorizationRepository extends JpaRepository<OAuth2Authorization, Long> {

    Optional<OAuth2Authorization> findByAccessTokenValue(String accessTokenValue);

    Optional<OAuth2Authorization> findByRefreshTokenValue(String refreshTokenValue);

    Optional<OAuth2Authorization> findByState(String state);

    Optional<OAuth2Authorization> findByAuthorizationCodeValue(String authorizationCodeValue);

    List<OAuth2Authorization> findByClientId(String clientId);

    List<OAuth2Authorization> findByPrincipalName(String principalName);

    // Пример запроса для поиска авторизаций, срок действия access токена которых истек
    @Query("SELECT a FROM OAuth2Authorization a WHERE a.accessTokenExpiresAt < :now")
    List<OAuth2Authorization> findByAccessTokenExpiredBefore(@Param("now") Instant now);

    // Пример запроса для поиска авторизаций по client_id и principal_name
    Optional<OAuth2Authorization> findByClientIdAndPrincipalName(String clientId, String principalName);

}
