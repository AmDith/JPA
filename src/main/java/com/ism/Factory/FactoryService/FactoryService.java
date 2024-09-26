package com.ism.Factory.FactoryService;

import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Core.Database.UserRepoListInt;
import com.ism.Repositories.JPA.ClientRepoJpa;
import com.ism.Repositories.JPA.UserRepoJpa;
import com.ism.Service.ClientService;
import com.ism.Service.UserService;

public class FactoryService {
  private FactoryService(){

  }

  private static ClientService clientService = null ;
  private static UserService userService = null ;



public static ClientService getInstanceC(ClientRepoJpa breuhk) {
  if (clientService == null) {
    clientService = new ClientService(breuhk);
    }
    return clientService;
}




public static UserService getInstanceU(UserRepoJpa breuhk) {
  if (userService == null) {
    userService = new UserService(breuhk);
    }
    return userService;
}

}
