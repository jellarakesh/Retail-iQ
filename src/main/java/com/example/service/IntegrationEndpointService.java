package com.example.service;

import com.example.entity.IntegrationEndpoint;
import com.example.repository.IntegrationEndpointRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.exception.ResourceNotFoundException;
import java.util.List;

@Service
public class IntegrationEndpointService {

    @Autowired
    private IntegrationEndpointRepository integrationEndpointRepository;

    public IntegrationEndpoint save(IntegrationEndpoint endpoint) {
        return integrationEndpointRepository.save(endpoint);
    }

    public IntegrationEndpoint update(IntegrationEndpoint endpoint) {
        return integrationEndpointRepository.save(endpoint);
    }



    public IntegrationEndpoint getById(Long id) {
        return integrationEndpointRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "IntegrationEndpoint not found with id: " + id));
    }

    public List<IntegrationEndpoint> getAll() {
        return integrationEndpointRepository.findAll();
    }

    public Page<IntegrationEndpoint> getAllWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return integrationEndpointRepository.findAll(pageable);
    }

    public IntegrationEndpoint delete(Long id) {
        IntegrationEndpoint endpoint = getById(id);
        if (endpoint != null) {
            integrationEndpointRepository.deleteById(id);
        }
        return endpoint;
    }
}