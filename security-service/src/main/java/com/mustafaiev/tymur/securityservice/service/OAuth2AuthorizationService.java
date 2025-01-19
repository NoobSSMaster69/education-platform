package com.mustafaiev.tymur.securityservice.service;

import com.mustafaiev.tymur.securityservice.entity.OAuth2Authorization;
import com.mustafaiev.tymur.securityservice.repository.OAuth2AuthorizationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class OAuth2AuthorizationService {

    private final OAuth2AuthorizationRepository authorizationRepository;

    public OAuth2AuthorizationService(OAuth2AuthorizationRepository authorizationRepository) {
        this.authorizationRepository = authorizationRepository;
    }

    public Optional<OAuth2Authorization> findAuthorizationByAccessToken(String accessToken) {
        return authorizationRepository.findByAccessTokenValue(accessToken);
    }

    public Optional<OAuth2Authorization> findAuthorizationByRefreshToken(String refreshToken) {
        return authorizationRepository.findByRefreshTokenValue(refreshToken);
    }

    public Optional<OAuth2Authorization> findAuthorizationByState(String state) {
        return authorizationRepository.findByState(state);
    }

    public Optional<OAuth2Authorization> findAuthorizationByAuthorizationCode(String authorizationCode) {
        return authorizationRepository.findByAuthorizationCodeValue(authorizationCode);
    }

    public List<OAuth2Authorization> findAuthorizationsByClientId(String clientId) {
        return authorizationRepository.findByClientId(clientId);
    }

    public List<OAuth2Authorization> findAuthorizationsByPrincipalName(String principalName) {
        return authorizationRepository.findByPrincipalName(principalName);
    }

    public Optional<OAuth2Authorization> findAuthorizationByClientIdAndPrincipalName(String clientId, String principalName) {
        return authorizationRepository.findByClientIdAndPrincipalName(clientId, principalName);
    }

    public void saveAuthorization(OAuth2Authorization authorization) {
        authorizationRepository.save(authorization);
    }

    public void deleteAuthorization(OAuth2Authorization authorization) {
        authorizationRepository.delete(authorization);
    }

    @Transactional // Важно для удаления нескольких авторизаций
    public void deleteExpiredAccessTokens() {
        List<OAuth2Authorization> expiredAuthorizations = authorizationRepository.findByAccessTokenExpiredBefore(Instant.now());
        authorizationRepository.deleteAll(expiredAuthorizations);
    }

}