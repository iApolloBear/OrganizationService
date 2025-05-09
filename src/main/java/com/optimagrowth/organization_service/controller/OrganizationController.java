package com.optimagrowth.organization_service.controller;

import com.optimagrowth.organization_service.model.Organization;
import com.optimagrowth.organization_service.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/organization")
public class OrganizationController {
  private final OrganizationService service;

  public OrganizationController(OrganizationService service) {
    this.service = service;
  }

  @GetMapping("/{organizationId}")
  public ResponseEntity<Organization> getOrganization(@PathVariable String organizationId) {
    return ResponseEntity.ok(this.service.findById(organizationId));
  }

  @PutMapping("/{organizationId}")
  public void updateOrganization(
      @PathVariable String organizationId, @RequestBody Organization organization) {
    this.service.update(organization);
  }

  @PostMapping
  public ResponseEntity<Organization> saveOrganization(@RequestBody Organization organization) {
    return ResponseEntity.ok(this.service.create(organization));
  }

  @DeleteMapping("/{organizationId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteOrganization(
      @PathVariable String organizationId, @RequestBody Organization organization) {
    this.service.delete(organization);
  }
}
