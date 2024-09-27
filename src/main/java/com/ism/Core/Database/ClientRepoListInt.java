package com.ism.Core.Database;

import com.ism.Repositories.Repository;
import com.ism.entities.Client;

public interface ClientRepoListInt extends Repository<Client> {
  Client selectByPhone(String phone);
  Client selectBySurname(String val);
}
