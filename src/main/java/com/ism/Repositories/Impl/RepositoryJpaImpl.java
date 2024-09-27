package com.ism.Repositories.Impl;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ism.Repositories.Repository;
import lombok.Data;
@Data
public class RepositoryJpaImpl<T> implements Repository<T> {

  protected String table;
  protected EntityManager em;
  protected Class<T> type;
  protected List<T> datas = new ArrayList<>();
  protected T data = null;



  EntityManagerFactory emf = Persistence.createEntityManagerFactory("DETTES");



  
  public RepositoryJpaImpl(Class<T> type) {
    this.type = type;
    if (em==null) {
        em=emf.createEntityManager();
      }
    }

  @Override
  public int insert(T amour) {
    try {
      em.getTransaction().begin();
      em.persist(amour);
      em.getTransaction().commit();
    } catch (Exception e) {
      em.getTransaction().rollback();
    }
    return 0;
  }

  @Override
   public List<T> selectAll() {
        List<T> list=null;
        try {
            em.getTransaction().begin();
            list= this.em.createQuery("SELECT e FROM " + table + " e", type).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
           em.getTransaction().rollback();
           e.printStackTrace();
        }
       return list;
}

 
  
}
