package com.ism.Core.Database;

import com.ism.Repositories.Repository;
import com.ism.entities.Client;

public interface ClientRepoListInt extends Repository<Client> {
  Client selectByPhone(String phone);
  void update(Client amour);
  Client selectBySurname(String val);
}
