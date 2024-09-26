package com.ism.Views;


import com.ism.Repositories.JPA.ClientRepoJpa;
import com.ism.Service.ClientServiceInt;
import com.ism.Views.Impl.ViewImpl;
import com.ism.entities.Client;
import com.ism.entities.User;

import java.util.Scanner;


public class ClientViews extends ViewImpl<Client,User> implements ClientViewsInt{
  
  private ClientServiceInt<Client,ClientRepoJpa> clientService;
  private UserViewInt uViews;
  public ClientViews(Scanner scan,ClientServiceInt<Client,ClientRepoJpa> clientService,UserViewInt uViews) {
    ViewImpl.scan = scan;
    this.clientService = clientService;
    this.uViews = uViews;
  }

  @Override
  public Client created(User us) {
    Client client = new Client();
      System.out.println("Enter surname: ");
      scan.nextLine();
      client.setName(scan.nextLine());
      System.out.println("Enter phone: ");
      client.setTel(scan.nextLine()); 
      System.out.println("Enter address: ");
      client.setAdresse(scan.nextLine());
      choixCreateUser(client,us);
      System.out.println(client);
    return client;
  }

  public void choixCreateUser(Client client,User us){
    System.out.println("Voulez-vous ajouter un compte à ce client(y/n)");
    String response = scan.nextLine();

    if (response.equalsIgnoreCase("y")) {
        User user = uViews.created(client);
        client.setUser(user);
    }else{
      client.setUser(us);
    }

  }

  

  

  
  
}
