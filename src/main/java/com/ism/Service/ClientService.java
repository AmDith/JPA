package com.ism.Service;

import java.util.List;

import com.ism.Repositories.JPA.ClientRepoJpa;
import com.ism.entities.Client;

import lombok.Data;

@Data

public class ClientService implements ClientServiceInt<Client,ClientRepoJpa> {

  private ClientRepoJpa clientRepo;

  
  public ClientService(ClientRepoJpa clientRepo) {
    this.clientRepo = clientRepo;
  }


  @Override
  public boolean saveList(Client objet) {
    if(objet != null){
      clientRepo.insert(objet);
      return true;
    }
    return false;
  }


  @Override
  public List<Client> show() {
    return clientRepo.selectAll();
  }

  


  @Override
  public ClientRepoJpa findData() {
    return clientRepo;
  }


  
  
}
