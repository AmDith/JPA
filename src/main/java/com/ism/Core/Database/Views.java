package com.ism.Core.Database;

import java.util.List;

public interface Views <T,A>{
  T created(A michel);
  void affiche(List<T> datas);
  
}
