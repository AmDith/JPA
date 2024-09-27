package com.ism.Repositories;

import java.util.List;


public interface Repository <A>{
  int insert(A amour);
  List<A> selectAll();
}
