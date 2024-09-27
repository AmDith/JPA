package com.ism;

import java.util.Scanner;

import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Core.Database.UserRepoListInt;
import com.ism.Factory.FactoryService.FactoryService;
import com.ism.Factory.FactoryViews.FactoryViews;
import com.ism.Factory.FactotyRepo.JPA.FactoryRepoJpa;
import com.ism.Repositories.JPA.ClientRepoJpa;
import com.ism.Repositories.JPA.UserRepoJpa;
import com.ism.Service.ClientServiceInt;
import com.ism.Service.UserServiceInt;
import com.ism.Views.ClientViewsInt;
import com.ism.Views.UserViewInt;
import com.ism.entities.Client;
import com.ism.entities.User;

public class Main {
    
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choix;
        int choix2;
        int choix3;
        Client cl;
        //Fabrique
        UserRepoJpa uRepo = FactoryRepoJpa.getInstanceU();
        ClientRepoJpa cRepo = FactoryRepoJpa.getInstanceC();
        //
        ClientServiceInt<Client,ClientRepoListInt>  cService = FactoryService.getInstanceC(cRepo);
        UserServiceInt<User,UserRepoListInt> uService = FactoryService.getInstanceU(uRepo);
        UserViewInt uViews = FactoryViews.getInstanceU(sc, uService);
        ClientViewsInt cViews = FactoryViews.getInstanceC(sc, cService, uViews);
        do {
            choix = affichageMenuprincipal();
            switch (choix) {
                case 1:
                    do {
                        choix2 = affichageMenuBoutiquier();
                        switch (choix2) {
                            case 1:
                                cService.saveList(cViews.created(null));
                                break;
                            case 2:
                                cViews.affiche(cService.show());
                                break;   
                            case 3:
                                sc.nextLine();
                                System.out.println(cService.search(SaisieNumero()));
                                break;  
                            case 4:
                                do {
                                    choix2=affichageSousMenu("1-Pour un client","2-Pour un boutiquier ou admin");
                                    
                                    switch (choix2) {
                                        case 1:
                                            sc.nextLine();
                                            cl = cService.search(SaisieNumero());
                                            if (cl.getUser() == null) {//.getRole pour les listes
                                                User us = uViews.created(cl);
                                                uService.saveList(us);
                                                cl.setUser(us);
                                            } else{
                                                System.out.println("Ce client a deje un compte");
                                            }
                                            break;
                                        case 2:
                                            sc.nextLine();
                                            User us = uViews.created(null);
                                            uService.saveList(us);
                                            break;    
                                    
                                        default:
                                            break;
                                    }
                                } while (choix2 != 2 && choix2 != 1);
                                break; 
                            case 5:
                                choix3 = affichageSousMenu("1-Actif", "2-Par role");
                                if (choix3 == 1) {
                                    uViews.affiche(uService.show());
                                }
                                else{
                                    uViews.filtreRole(uViews.AffAss().getNomRole());
                                }
                                break; 
                            default:
                                break;
                        }
                    } while (choix2 != 6);
                    break;
                case 2:
                    
                    break;
                case 3:
                                        
                     break;
            
                default:
                    break;
            }
            
        } while (choix != 3);
    }

    public static int affichageMenuAmin(){
        int choix;
        do{
            System.out.println("Menu Admin");
            System.out.println("1(a)-Créer un compte utilisateur à un client n'ayant pas de compte");
            System.out.println("2(b)-Créer un compte utilisateur avec un rôle Boutiquier ou  Admin");
            System.out.println("3(c)-Désactiver/Activer  un compte utilisateur");
            System.out.println("4(d)-Afficher les comptes utilisateurs");
            System.out.println("5(e)-Créer/lister  des articles et filtrer par disponibilité(qteStock!=0)");
            System.out.println("6(f)-Mettre à jour la qté en stock d'un article");
            System.out.println("7(g)-Archiver les dettes soldées");
            System.out.println("8-Quitter");
            choix = sc.nextInt();
        }while(choix<0 || choix>8);
        return choix;
        
    }
    public static int affichageMenuprincipal(){
        int choix;
        do{
            System.out.println("Menu");
            System.out.println("1-Utilisateur de rôle Boutiquier");
            System.out.println("2-Utilisateur de rôle Admin");
            System.out.println("3-Utilisateur de rôle Client");
            choix = sc.nextInt();
        }while(choix<0 || choix>2);
        return choix;
        
    }

    public static int affichageMenuprincipal3(){
        int choix;
        do{
            System.out.println("Menu");
            System.out.println("1-Creer un client");
            System.out.println("2-Lister les clients");
            System.out.println("3-Creer un user");
            System.out.println("4-Lister les users");
            choix = sc.nextInt();
        }while(choix<0 || choix>4);
        return choix;
        
    }

    public static int affichageMenuBoutiquier(){
        int choix;
        do{
            System.out.println("Menu");
            System.out.println("1- Create un client");
            System.out.println("2- Lister les clients");
            System.out.println("3-Rechercher un client par son numero de telephone");
            System.out.println("4- Create un compte user");
            System.out.println("5- Lister les comptes users");
            System.out.println("6-Quitter");
            choix = sc.nextInt();
        }while(choix<0 || choix>6);
        return choix;
        
    }

    public static int affichageSousMenu(String val1,String val2){
        int choix;
        do{
            System.out.println("Menu");
            System.out.println(val1);
            System.out.println(val2);
            choix = sc.nextInt();
        }while(choix<0 || choix>2);
        return choix;
        
    }

    public static int affichageSousMenu2(String val1,String val2,String val3){
        int choix;
        do{
            System.out.println("Menu");
            System.out.println(val1);
            System.out.println(val2);
            System.out.println(val3);
            choix = sc.nextInt();
        }while(choix<0 || choix>3);
        return choix;
        
    }

    public static String SaisieNumero(){
        String val;
        System.out.println("Entrez le numero de telephone du client");
        val = sc.nextLine();
        return val;
    }

    // public static void client(){
    //     Client cl;
    //     cl = cService.search(SaisieNumero());
    //     if (cl.getUser() == null) {
    //         cl.setUser(uViews.created());
    //         uService.saveList(cl.getUser());
    //     } else{
    //         System.out.println("Ce client a deje un compte");
    //     }
    // }


}