package com.ism.Views;

import com.ism.Core.Database.Views;
import com.ism.entities.Client;
import com.ism.entities.Role;
import com.ism.entities.User;

import java.util.List;

public interface UserViewInt extends Views<User,Client> {
  void affiche(List<User> datas);
  void filtreRole(String nomRole);
  Role findRole();
  Role findRoleClient();
  Role AffAss();
}
