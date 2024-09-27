package com.ism.Views;


import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Service.ClientServiceInt;
import com.ism.Views.Impl.ViewImpl;
import com.ism.entities.Client;
import com.ism.entities.User;

import java.util.Scanner;


public class ClientViews extends ViewImpl<Client,User> implements ClientViewsInt{
  
  private ClientServiceInt<Client,ClientRepoListInt> clientService;
  private UserViewInt uViews;
  public ClientViews(Scanner scan,ClientServiceInt<Client,ClientRepoListInt> clientService,UserViewInt uViews) {
    ViewImpl.scan = scan;
    this.clientService = clientService;
    this.uViews = uViews;
  }

  @Override
  public Client created(User us) {
    Client client = new Client();
    do {
      System.out.println("Enter le surname: ");
      scan.nextLine();
      client.setName(scan.nextLine());
      System.out.println("Enter le numero de phone: ");
      client.setTel(scan.nextLine()); 
      System.out.println("Enter l'address: ");
      client.setAdresse(scan.nextLine());
      choixCreateUser(client,us);
    } while (clientService.search(client.getTel()) != null);
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
