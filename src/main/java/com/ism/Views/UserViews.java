package com.ism.Views;

import com.ism.Core.Database.UserRepoListInt;
import com.ism.Service.UserServiceInt;
import com.ism.Views.Impl.ViewImpl;
import com.ism.entities.Client;
import com.ism.entities.Role;
import com.ism.entities.User;
import com.ism.enums.Etat;

import java.util.Scanner;
import java.util.List;



public class UserViews extends ViewImpl<User,Client> implements UserViewInt {


  private UserServiceInt<User,UserRepoListInt> userService;

  public UserViews(Scanner scan,UserServiceInt<User,UserRepoListInt> userService) {
    ViewImpl.scan = scan;
    this.userService = userService;
  }

  @Override
  public User created(Client client) {
    User user = new User();
    do {
      user.setEmail(scan.nextLine());
      System.out.println("Veuillez saisir votre login");
      user.setLogin(scan.nextLine());
      System.out.println("Veuillez saisir votre password");
      user.setPassword(scan.nextLine());
      user.setEtat(Etat.Activer);
      if (client != null) {
        if (client.getUser() == null) {
          user.setRole(findRoleClient());
        }else{
          System.out.println("Ce client a deja un compte");
        }
      }else{
        user.setRole(findRole());
      }
    } while (userService.findData().selectByLogin(user.getLogin())!= null);
    System.out.println("Veuillez saisir votre email");
    return user;
  }

  @Override
  public Role findRole(){
    int choix ;
    Role role = new Role();
    do {
      System.out.println("Choisissez le rôle du compte");
      System.out.println("1-Admin");
      System.out.println("2-Boutiquier");
      choix = scan.nextInt();
    } while (choix < 0 || choix > 2);
    if (choix == 1) {
      role.setNomRole("Admin");
      role.setId(choix);
    }
    else{
      role.setNomRole("Boutiquier");
      role.setId(choix);
    }
    return role;
  }

  

  @Override
  public void affiche(List<User> datas) {
    datas.stream()
         .filter(data -> data.getEtat() == Etat.Activer)
         .forEach(data -> System.out.println(data));
}


  @Override
  public void filtreRole(String nomRole) {
    userService.findData().selectAll().stream()
        .filter(data -> data.getRole().getNomRole().equals(nomRole))
        .forEach(data -> System.out.println(data));
}

  @Override
  public Role findRoleClient() {
    Role role = new Role();
    role.setId(3);
    role.setNomRole("Client");
    return role;
  }
  @Override
  public Role AffAss(){
    int choix ;
    Role role = new Role();
    do {
      System.out.println("1-Admin");
      System.out.println("2-Boutiquier");
      System.out.println("3-Client");
      choix = scan.nextInt();
    } while (choix < 0 || choix > 3);
    if (choix == 1) {
      role.setNomRole("Admin");
      role.setId(choix);
    }
    else if(choix == 2){
      role.setNomRole("Boutiquier");
      role.setId(choix);
    }else{
      role.setNomRole("Client");
      role.setId(choix);
    }
    return role;
  }
  
  
}
