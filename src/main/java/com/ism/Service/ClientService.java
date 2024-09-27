package com.ism.Service;

import java.util.List;

import com.ism.Core.Database.ClientRepoListInt;
import com.ism.entities.Client;

import lombok.Data;

@Data

public class ClientService implements ClientServiceInt<Client,ClientRepoListInt> {

  private ClientRepoListInt clientRepo;

  
  public ClientService(ClientRepoListInt clientRepo) {
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
  public Client search(String phone) {
    return clientRepo.selectByPhone(phone);
}


  @Override
  public ClientRepoListInt findData() {
    return clientRepo;
  }


  
  
}
