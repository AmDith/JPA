package com.ism.Repositories.JPA;

import com.ism.Repositories.Impl.RepositoryJpaImpl;
import com.ism.entities.User;

public class UserRepoJpa extends RepositoryJpaImpl<User> {

  public UserRepoJpa(){
    super(User.class);
    table = "User";
  }

 
  
}
