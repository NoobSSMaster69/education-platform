package com.mustafaiev.tymur.securityservice.config;

import com.mustafaiev.tymur.securityservice.entity.OAuth2Client;
import com.mustafaiev.tymur.securityservice.service.OAuth2ClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.util.stream.Collectors;

@Configuration
public class OAuth2ClientConfig {

    private final OAuth2ClientService oAuth2ClientService;
    private final DataSource dataSource;
    private final String clientId;

    public OAuth2ClientConfig(OAuth2ClientService oAuth2ClientService, DataSource dataSource, @Value("${oauth2.client.registration.client-id}")String clientId) {
        this.oAuth2ClientService = oAuth2ClientService;
        this.dataSource = dataSource;
        this.clientId = clientId;
    }

    @Bean
    public JdbcOperations jdbcOperations() {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public RegisteredClientRepository registeredClientRepository(JdbcOperations jdbcOperations) { // Inject JdbcOperations
        JdbcRegisteredClientRepository registeredClientRepository = new JdbcRegisteredClientRepository(jdbcOperations);

        OAuth2Client clientFromDb = oAuth2ClientService.findClientByClientId(clientId);
        if (clientFromDb == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }

        RegisteredClient registeredClient = RegisteredClient.withId(clientId)
                .clientId(clientFromDb.getClientId())
                .clientSecret(clientFromDb.getClientSecret())
                .clientAuthenticationMethods(authenticationMethods -> authenticationMethods.addAll(clientFromDb.getClientAuthenticationMethods()))
                .authorizationGrantTypes(grantTypes -> grantTypes.addAll(clientFromDb.getAuthorizationGrantTypes()))
                .redirectUris(redirectUris -> redirectUris.addAll(clientFromDb.getRedirectUris().lines().collect(Collectors.toSet())))
                .scopes(scopes -> scopes.addAll(clientFromDb.getScopes()))
                .build();

        RegisteredClient existingClient = registeredClientRepository.findByClientId(registeredClient.getClientId());
        if (existingClient == null) {
            registeredClientRepository.save(registeredClient);
        }

        return registeredClientRepository;
    }
}
