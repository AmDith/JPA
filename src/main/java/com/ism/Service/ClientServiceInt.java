package com.ism.Service;

import com.ism.Core.Database.Service;
import com.ism.entities.Client;

public interface ClientServiceInt<T,A> extends Service<T,A> {
  Client search(String phone);
}
