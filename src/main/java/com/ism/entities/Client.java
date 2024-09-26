package com.ism.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "Client")
@ToString(onlyExplicitlyIncluded = true)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ToString.Include
    private int id;

    @ToString.Include
    @Column(length = 25,unique = true)
    private String name;

    @ToString.Include
    @Column(length = 25,unique = true)
    private String tel;

    @ToString.Include
    @Column(length = 25,unique = false)
    private String adresse;

    // Navigabilité vers User
    @OneToOne
    @JoinColumn
    private User user;

    // Relation avec Dette
    // @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    // private List<Dette> dettes;

}
