import java.util.Scanner;
/**
 * Cette classe nous permet de lancer une partie 
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Partie
{
     public static void main(String[] Args)
    {
        //saisir le nom du premier joueur
        
       Scanner scanner=new Scanner(System.in);
        
       System.out.println("Voulez-vous jouer au puissance 4? ((Oui) pour oui ou (Non) pour non) ");
      String jouer=scanner.nextLine();
      if (jouer.equals("Oui") || jouer.equals("OUI") || jouer.equals("oui")){
         Scanner s=new Scanner(System.in);
         System.out.println("Combien de joueurs souhaitent jouer ? (2 joueurs max)");
         
         int jeu;
         try{
             jeu = Integer.parseInt(s.next());
             if (jeu == 2){
                 System.out.println("Saisir le nom du premier joueur:");
                 String nomj1=scanner.nextLine();
                 Jeu.saut_ligne();
                
                 System.out.println("Saisissez le nom du deuxième joueur :");
                 String nomj2=scanner.nextLine();
                 Jeu.saut_ligne();
                 
                 Joueur j1=new Joueur(true,nomj1,Case.X);
                 Joueur j2=new Joueur(true,nomj2,Case.O);
                 

                         //choisir la taille de la grille ou une sauvegarde
                 char[][] g;
               
                /*g=partie_sauvegarde("D:\\sauvegarde.txt");
                Grille gr=new Grille(g);
                gr.afficher_grille();*/
                
                 int tc=Jeu.taille_colonne();
                 int tl=Jeu.taille_ligne();
                 Grille gr=new Grille(tc,tl);
                 gr.afficher_grille();
                
                
                 boolean arret_jeu=false;
                
                 Joueur jcour=new Joueur(j1);
                 while(arret_jeu==false){
                    if(jcour.equals(j1)){
                        jcour=j2;
                    }else{
                        jcour=j1;
                    }
                    
                    System.out.println(jcour.getNom()+", saisissez le numéro de la colonne où vous voulez jouer : ");
                    
                    int coloj=scanner.nextInt();
                    Jeu.saut_ligne();
                    
                     // if(coloj==0){
                        // sauvegarder("D:\\sauvegarde.txt",gr.getGrille());
                        // System.exit(0);
                     // }
                    
                    while(coloj<1 && coloj>gr.getColonne()){
                        System.out.println("Veuillez saisir un numéro de colonne compris entre 1 et "+gr.getColonne());
                        coloj=scanner.nextInt();
                    }
                
                    while(gr.ajout_pion(jcour, gr.getGrille(),coloj) == false){
                        System.out.println("Veuillez saisir un numéro de colonne compris entre 1 et "+gr.getColonne()+" sauf "+coloj);
                        coloj=scanner.nextInt();
                    }
                
                    gr.afficher_grille();
                    Jeu.saut_ligne();
                    
                    if(gr.detection_victoire(gr.getGrille(),coloj,jcour)==true){
                        arret_jeu=true;
                    }
                    
                    
                    //deuxieme cas
             }
           
             } 
              else if (jeu ==1){
                 System.out.println("Saisir le nom du premier joueur:");
                 String nomj1=scanner.nextLine();
                 Jeu.saut_ligne();
                 
                 Joueur j1=new Joueur(true,nomj1,Case.X);
                 Joueur j2=new Joueur(false,"bot",Case.O);
                  
                 
                //choisir la taille de la grille ou une sauvegarde
                 char[][] g;
               
                /*g=partie_sauvegarde("D:\\sauvegarde.txt");
                Grille gr=new Grille(g);
                gr.afficher_grille();*/
                
                 int tc=Jeu.taille_colonne();
                 int tl=Jeu.taille_ligne();
                 Grille gr=new Grille(tc,tl);
                 gr.afficher_grille();
                
                
                 boolean arret_jeu=false;
                
                 Joueur jcour=new Joueur(j1);
                 while(arret_jeu==false){
                    if(jcour.equals(j1)){
                        jcour=j2;
                    }else{
                        jcour=j1;
                    }
                    
                    if (jcour.getType() == true){
                        System.out.println(jcour.getNom()+", saisissez le numéro de la colonne où vous voulez jouer : ");
                        
                        int coloj=scanner.nextInt();
                        Jeu.saut_ligne();
                        
                         // if(coloj==0){
                            // sauvegarder("D:\\sauvegarde.txt",gr.getGrille());
                            // System.exit(0);
                         // }
                        
                        while(coloj<1 && coloj>gr.getColonne()){
                            System.out.println("Veuillez saisir un numéro de colonne compris entre 1 et "+gr.getColonne());
                            coloj=scanner.nextInt();
                        }
                    
                        while(gr.ajout_pion(jcour, gr.getGrille(),coloj) == false){
                            System.out.println("Veuillez saisir un numéro de colonne compris entre 1 et "+gr.getColonne()+" sauf "+coloj);
                            coloj=scanner.nextInt();
                        }
                    
                        gr.afficher_grille();
                        Jeu.saut_ligne();
                        
                        if(gr.detection_victoire(gr.getGrille(),coloj,jcour)==true){
                            arret_jeu=true;
                        }
                        
                        
                        //deuxieme cas
                    }
                    else{
                        int coloj = gr.ajout_pion_IA (jcour, gr.getGrille());
                        gr.afficher_grille();
                        Jeu.saut_ligne();
                        
                        if(gr.detection_victoire(gr.getGrille(),coloj,jcour)==true){ 
                            arret_jeu=true;
                        }
                    }
                }
        }
       } catch (NumberFormatException e){
            System.out.println ("La valeur entrée n'est pas un entier");
            Jeu.saut_ligne();
       }
         
      } else {
          System.out.println("Très bien, à la prochaine !");
        }
    
    }

    
    //choix de partie
    //demander si on veut lancer une sauvegarde ou pas
    

}
