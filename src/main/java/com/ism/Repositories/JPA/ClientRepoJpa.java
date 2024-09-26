package com.ism.Repositories.JPA;


import com.ism.Repositories.Impl.RepositoryJpaImpl;
import com.ism.entities.Client;

public class ClientRepoJpa extends RepositoryJpaImpl<Client> {

  public ClientRepoJpa() {
    super(Client.class);
    table = "Client";
}

  


 
  
}
