package com.ism.Repositories.JPA;

import com.ism.Core.Database.UserRepoListInt;
import com.ism.Repositories.Impl.RepositoryJpaImpl;
import com.ism.entities.User;

public class UserRepoJpa extends RepositoryJpaImpl<User> implements UserRepoListInt{

  public UserRepoJpa(){
    super(User.class);
    table = "User";
  }

  @Override
  public String login(String val) {
    datas = selectAll();
    boolean isUnique = datas.stream()
                            .noneMatch(user -> user.getLogin().equals(val));
    
    return isUnique ? val : null;
  }

  @Override
  public User selectByLogin(String val) {
    try {
      em.getTransaction().begin();
      data= this.em.createQuery("SELECT e FROM " + table + " e WHERE e.login = :login", type)
      .setParameter("login", val)
      .getSingleResult();    
      em.getTransaction().commit();
    } catch (Exception e) {
      em.getTransaction().rollback();
      e.printStackTrace();
    }
    return data;
  }
 
  
}
