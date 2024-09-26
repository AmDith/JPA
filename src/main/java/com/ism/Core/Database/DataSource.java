package com.ism.Core.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public interface DataSource<T> {
  Connection connexion() throws SQLException, ClassNotFoundException;
  void closeConnection() throws SQLException;
  ResultSet executeQuery() throws SQLException;
  int executeUpdate() throws SQLException;
  void init(String sql) throws SQLException, ClassNotFoundException;
  String generateSql(String query);
  T setfields(ResultSet rs,T amour) throws SQLException;
  int stmtfields(T amour,String query) throws SQLException;

  
}
