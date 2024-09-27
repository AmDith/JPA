package com.ism.Repositories.JPA;


import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Repositories.Impl.RepositoryJpaImpl;
import com.ism.entities.Client;


public class ClientRepoJpa extends RepositoryJpaImpl<Client> implements ClientRepoListInt {


  public ClientRepoJpa() {
    super(Client.class);
    table = "Client";
}

  @Override
  public Client selectByPhone(String phone) {
    try {
      em.getTransaction().begin();
      data= this.em.createQuery("SELECT e FROM Client e WHERE e.tel = :tel", type)
      .setParameter("tel", phone)
      .getSingleResult();    
      em.getTransaction().commit();
    } catch (Exception e) {
      em.getTransaction().rollback();
      e.printStackTrace();
    }
    return data;
  }

  @Override
  public Client selectBySurname(String val) {
    try {
      em.getTransaction().begin();
      data= this.em.createQuery("SELECT e FROM " + table + " e WHERE e.name = :name", type)
      .setParameter("name", val)
      .getSingleResult();    
      em.getTransaction().commit();
    } catch (Exception e) {
      em.getTransaction().rollback();
      e.printStackTrace();
    }
    return data;
  }

  

  

  


 
  
}
