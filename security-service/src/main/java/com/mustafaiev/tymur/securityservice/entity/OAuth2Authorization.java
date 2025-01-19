package com.mustafaiev.tymur.securityservice.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "oauth2_authorization")
public class OAuth2Authorization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "principal_name")
    private String principalName;

    @Column(name = "authorization_grant_type")
    private String authorizationGrantType;

    @Column(name = "access_token_value", columnDefinition = "TEXT")
    private String accessTokenValue;

    @Column(name = "access_token_issued_at")
    private Instant accessTokenIssuedAt;

    @Column(name = "access_token_expires_at")
    private Instant accessTokenExpiresAt;

    @Column(name = "access_token_type")
    private String accessTokenType;

    @Column(name = "access_token_scopes")
    private String accessTokenScopes;

    @Column(name = "refresh_token_value", columnDefinition = "TEXT")
    private String refreshTokenValue;

    @Column(name = "refresh_token_issued_at")
    private Instant refreshTokenIssuedAt;

    @Column(name = "refresh_token_expires_at")
    private Instant refreshTokenExpiresAt;

    @Column(name = "oidc_id_token_value", columnDefinition = "TEXT")
    private String oidcIdTokenValue;

    @Column(name = "oidc_id_token_issued_at")
    private Instant oidcIdTokenIssuedAt;

    @Column(name = "oidc_id_token_expires_at")
    private Instant oidcIdTokenExpiresAt;

    @Column(name = "state", columnDefinition = "TEXT")
    private String state;

    @Column(name = "authorization_code_value", columnDefinition = "TEXT")
    private String authorizationCodeValue;

    @Column(name = "authorization_code_issued_at")
    private Instant authorizationCodeIssuedAt;

    @Column(name = "authorization_code_expires_at")
    private Instant authorizationCodeExpiresAt;

    @Column(name = "attributes", columnDefinition = "TEXT") // For storing additional attributes as JSON
    private String attributes;


    // Геттеры и сеттеры

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getClientId() { return clientId; }
    public void setClientId(String clientId) { this.clientId = clientId; }
    public String getPrincipalName() { return principalName; }
    public void setPrincipalName(String principalName) { this.principalName = principalName; }
    public String getAuthorizationGrantType() { return authorizationGrantType; }
    public void setAuthorizationGrantType(String authorizationGrantType) { this.authorizationGrantType = authorizationGrantType; }
    public String getAccessTokenValue() { return accessTokenValue; }
    public void setAccessTokenValue(String accessTokenValue) { this.accessTokenValue = accessTokenValue; }
    public Instant getAccessTokenIssuedAt() { return accessTokenIssuedAt; }
    public void setAccessTokenIssuedAt(Instant accessTokenIssuedAt) { this.accessTokenIssuedAt = accessTokenIssuedAt; }
    public Instant getAccessTokenExpiresAt() { return accessTokenExpiresAt; }
    public void setAccessTokenExpiresAt(Instant accessTokenExpiresAt) { this.accessTokenExpiresAt = accessTokenExpiresAt; }
    public String getAccessTokenType() { return accessTokenType; }
    public void setAccessTokenType(String accessTokenType) { this.accessTokenType = accessTokenType; }
    public String getAccessTokenScopes() { return accessTokenScopes; }
    public void setAccessTokenScopes(String accessTokenScopes) { this.accessTokenScopes = accessTokenScopes; }
    public String getRefreshTokenValue() { return refreshTokenValue; }
    public void setRefreshTokenValue(String refreshTokenValue) { this.refreshTokenValue = refreshTokenValue; }
    public Instant getRefreshTokenIssuedAt() { return refreshTokenIssuedAt; }
    public void setRefreshTokenIssuedAt(Instant refreshTokenIssuedAt) { this.refreshTokenIssuedAt = refreshTokenIssuedAt; }
    public Instant getRefreshTokenExpiresAt() { return refreshTokenExpiresAt; }
    public void setRefreshTokenExpiresAt(Instant refreshTokenExpiresAt) { this.refreshTokenExpiresAt = refreshTokenExpiresAt; }

    public String getOidcIdTokenValue() { return oidcIdTokenValue; }

    public void setOidcIdTokenValue(String oidcIdTokenValue) { this.oidcIdTokenValue = oidcIdTokenValue; }

    public Instant getOidcIdTokenIssuedAt() { return oidcIdTokenIssuedAt; }

    public void setOidcIdTokenIssuedAt(Instant oidcIdTokenIssuedAt) { this.oidcIdTokenIssuedAt = oidcIdTokenIssuedAt; }

    public Instant getOidcIdTokenExpiresAt() { return oidcIdTokenExpiresAt; }

    public void setOidcIdTokenExpiresAt(Instant oidcIdTokenExpiresAt) { this.oidcIdTokenExpiresAt = oidcIdTokenExpiresAt; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public String getAuthorizationCodeValue() { return authorizationCodeValue; }

    public void setAuthorizationCodeValue(String authorizationCodeValue) { this.authorizationCodeValue = authorizationCodeValue; }

    public Instant getAuthorizationCodeIssuedAt() { return authorizationCodeIssuedAt; }

    public void setAuthorizationCodeIssuedAt(Instant authorizationCodeIssuedAt) { this.authorizationCodeIssuedAt = authorizationCodeIssuedAt; }

    public Instant getAuthorizationCodeExpiresAt() { return authorizationCodeExpiresAt; }

    public void setAuthorizationCodeExpiresAt(Instant authorizationCodeExpiresAt) { this.authorizationCodeExpiresAt = authorizationCodeExpiresAt; }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }
}
