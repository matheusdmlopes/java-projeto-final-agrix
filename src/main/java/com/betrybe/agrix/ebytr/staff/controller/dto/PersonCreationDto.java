package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * Object to get data from body.
 *
 * @param username string
 * @param password string
 * @param role type Role
 */
public record PersonCreationDto(String username, String password, Role role) {
  public Person toEntity() {
    return new Person(username, password, role);
  }
}