package com.ism.Factory.FactoryViews;


import java.util.Scanner;

import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Core.Database.UserRepoListInt;
import com.ism.Repositories.JPA.ClientRepoJpa;
import com.ism.Repositories.JPA.UserRepoJpa;
import com.ism.Service.ClientServiceInt;
import com.ism.Service.UserServiceInt;
import com.ism.Views.ClientViews;
import com.ism.Views.UserViewInt;
import com.ism.Views.UserViews;
import com.ism.entities.Client;
import com.ism.entities.User;

public class FactoryViews {
   private FactoryViews(){

  }

  private static ClientViews clientService = null ;
  private static UserViews userService = null ;





public static ClientViews getInstanceC(Scanner breuhk, ClientServiceInt<Client,ClientRepoJpa> breuk,UserViewInt moi){
  if (clientService == null) {
    clientService = new ClientViews(breuhk,breuk,moi);
    }
    return clientService;
}




public static UserViews getInstanceU(Scanner breuhk, UserServiceInt<User,UserRepoJpa> breuk) {
  if (userService == null) {
    userService = new UserViews(breuhk,breuk);
    }
    return userService;
}
}
