package com.ism.Views.Impl;

import java.util.List;
import java.util.Scanner;

import com.ism.Core.Database.Views;

public abstract class ViewImpl<T,A> implements Views<T,A> {
  protected static Scanner scan;

    
    public static void setScanner(Scanner scan) {
        ViewImpl.scan = scan;
    }
    public static Scanner getScanner(){
       return ViewImpl.scan;
    }

    @ Override
    public void affiche(List<T> datas){
      datas.forEach(System.out::println);
    }
}
