package com.ism.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Role")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(length = 25, unique = true)
  private String nomRole;

}
