package com.ism.Core.Database.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ism.Core.Database.DataSource;
import java.sql.Statement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class DataSourceImpl<T> implements DataSource<T> {
  private final String url ="jdbc:mysql://localhost:3306/gestionclient";
  private final String user ="root";
  private final String password ="";
  private final String driver ="com.mysql.cj.jdbc.Driver";
  protected PreparedStatement stmt;
  protected Connection conn;

  @Override
  public Connection connexion() throws SQLException, ClassNotFoundException {
   Class.forName(driver);
        return DriverManager.getConnection(url,user,password);
  }

  @Override
  public void closeConnection() throws SQLException {
    if (conn != null && !conn.isClosed()) {
      conn.close();
    }
  }


  @Override
  public ResultSet executeQuery() throws SQLException {
    return stmt.executeQuery();
    }

  @Override
  public int executeUpdate()throws SQLException {
    return stmt.executeUpdate();
  }

  @Override
  public String generateSql(String query) {
      return query;
  }

  @Override
  public void init(String sql) throws SQLException, ClassNotFoundException  {
    this.connexion();
    if (sql.toUpperCase().trim().startsWith("INSERT")) {
      stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    }else{
      stmt = conn.prepareStatement(sql);
    }
    
  }

  
}
