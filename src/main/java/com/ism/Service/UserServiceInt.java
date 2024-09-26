package com.ism.Service;


import com.ism.Core.Database.Service;


public interface UserServiceInt<T,A> extends Service<T,A> {

  void Off (T amour);
  void On (T amour);
}
