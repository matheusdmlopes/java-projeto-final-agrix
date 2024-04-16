package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * Object to send back the data as json response.
 *
 * @param id Long
 * @param username String
 * @param role type Role
 */
public record PersonDto(Long id, String username, Role role) {

  /**
   * Create the data transfer object function, get the data from Entity.
   *
   * @param person type(entity) Person
   * @return new Dto
   */
  public static PersonDto fromEntity(Person person) {
    return new PersonDto(
        person.getId(),
        person.getUsername(),
        person.getRole()
    );
  }

}
