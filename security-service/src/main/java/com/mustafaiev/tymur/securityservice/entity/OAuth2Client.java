package com.mustafaiev.tymur.securityservice.entity;

import jakarta.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.util.StringUtils;

@Entity
@Table(name = "oauth2_client")
public class OAuth2Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String clientId;
    private String clientSecret;
    private String clientName;

    @Column(name = "client_authentication_methods")
    private String clientAuthenticationMethods;

    @Column(name = "authorization_grant_types")
    private String authorizationGrantTypes;

    @Column(name = "redirect_uris")
    private String redirectUris;

    private String scopes;

    @Column(name = "require_proof_key")
    private boolean requireProofKey;

    @Column(name = "require_authorization_consent")
    private boolean requireAuthorizationConsent;

    @Column(name = "token_format")
    private String tokenFormat; // Store "JWT" or "OPAQUE"

    @Column(name = "access_token_validity_seconds")
    private Integer accessTokenValiditySeconds;

    @Column(name = "refresh_token_validity_seconds")
    private Integer refreshTokenValiditySeconds;

    // Getters and setters (updated getter for tokenFormat)

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getClientId() { return clientId; }
    public void setClientId(String clientId) {this.clientId = clientId;}
    public String getClientSecret() { return clientSecret; }
    public void setClientSecret(String clientSecret) {this.clientSecret = clientSecret;}
    public String getClientName() { return clientName; }
    public void setClientName(String clientName) {this.clientName = clientName;}
    public Set<ClientAuthenticationMethod> getClientAuthenticationMethods() {
        return StringUtils.commaDelimitedListToSet(this.clientAuthenticationMethods).stream()
                .map(ClientAuthenticationMethod::new)
                .collect(Collectors.toSet());
    }
    public void setClientAuthenticationMethods(String clientAuthenticationMethods) { this.clientAuthenticationMethods = clientAuthenticationMethods; }
    public Set<AuthorizationGrantType> getAuthorizationGrantTypes() {
        return StringUtils.commaDelimitedListToSet(this.authorizationGrantTypes).stream()
                .map(AuthorizationGrantType::new)
                .collect(Collectors.toSet());
    }
    public void setAuthorizationGrantTypes(String authorizationGrantTypes) { this.authorizationGrantTypes = authorizationGrantTypes;}
    public String getRedirectUris() { return redirectUris; }
    public void setRedirectUris(String redirectUris) {this.redirectUris = redirectUris;}
    public Set<String> getScopes() { return StringUtils.commaDelimitedListToSet(this.scopes);}
    public void setScopes(String scopes) {this.scopes = scopes;}
    public boolean isRequireProofKey() { return requireProofKey; }
    public void setRequireProofKey(boolean requireProofKey) {this.requireProofKey = requireProofKey;}
    public boolean isRequireAuthorizationConsent() { return requireAuthorizationConsent; }
    public void setRequireAuthorizationConsent(boolean requireAuthorizationConsent) { this.requireAuthorizationConsent = requireAuthorizationConsent; }
    public String getTokenFormat() { return tokenFormat; } // Correct getter
    public void setTokenFormat(String tokenFormat) {this.tokenFormat = tokenFormat;}
    public Integer getAccessTokenValiditySeconds() { return accessTokenValiditySeconds; }
    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {this.accessTokenValiditySeconds = accessTokenValiditySeconds;}
    public Integer getRefreshTokenValiditySeconds() { return refreshTokenValiditySeconds; }
    public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;}
}