package com.ism.Factory.FactotyRepo.JPA;

import com.ism.Repositories.JPA.ClientRepoJpa;
import com.ism.Repositories.JPA.UserRepoJpa;

public class FactoryRepoJpa {
  
  private FactoryRepoJpa(){

  }

  private static ClientRepoJpa clientService = null ;
  private static UserRepoJpa userService = null ;


  


public static ClientRepoJpa getInstanceC(){
  if (clientService == null) {
    clientService = new ClientRepoJpa();
    }
    return clientService;
}


public static UserRepoJpa getInstanceU() {
  if (userService == null) {
    userService = new UserRepoJpa();
    }
    return userService;
}
}

