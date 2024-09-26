package com.ism.Core.Database;

import java.util.List;


public interface Service<T,A> {
  boolean saveList (T objet);
  List<T> show();
  A findData();
}
