package com.optimagrowth.organization_service.service;

import com.optimagrowth.organization_service.model.Organization;
import com.optimagrowth.organization_service.repository.OrganizationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrganizationService {
  private static final Logger logger = LoggerFactory.getLogger(OrganizationService.class);

  private final OrganizationRepository repository;

  public OrganizationService(OrganizationRepository repository) {
    this.repository = repository;
  }

  public Organization findById(String organizationId) {
    return this.repository.findById(organizationId).orElse(null);
  }

  public Organization create(Organization organization) {
    organization.setId(UUID.randomUUID().toString());
    organization = this.repository.save(organization);
    return organization;
  }

  public void update(Organization organization) {
    this.repository.save(organization);
  }

  public void delete(String organizationId) {
    this.repository.deleteById(organizationId);
  }
}
