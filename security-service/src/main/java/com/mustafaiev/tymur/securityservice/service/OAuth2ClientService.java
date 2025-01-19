package com.mustafaiev.tymur.securityservice.service;

import com.mustafaiev.tymur.securityservice.entity.OAuth2Client;
import com.mustafaiev.tymur.securityservice.repository.OAuth2ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OAuth2ClientService {

    private final OAuth2ClientRepository clientRepository;

    public OAuth2ClientService(OAuth2ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public OAuth2Client findClientByClientId(String clientId) {
        return clientRepository.findByClientId(clientId);
    }

    // Другие методы сервиса
    public List<OAuth2Client> getAllClients() {
        return clientRepository.findAll();
    }

    public void saveClient(OAuth2Client client) {
        clientRepository.save(client);
    }
}