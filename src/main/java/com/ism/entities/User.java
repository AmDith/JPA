package com.ism.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ism.enums.Etat;

import lombok.Data;

@Data
@Entity
@Table(name = "User")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @Column(length = 25, unique = true)
  private String login;
  @Column(length = 25,unique = true)
  private String email;
  @Column(length = 25,unique = false)
  private String password;
  @Enumerated(EnumType.STRING)
  private Etat etat;
  //Navigabilité
  @OneToOne
  @JoinColumn
  private Role role;

  //Navigabilité
  @OneToOne
  @JoinColumn
  private Client client;

  
  
}
