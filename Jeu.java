import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
/**
 * Classe qui va permettre de choisir le type de jeu voulu par l'utilisateur
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Jeu
{
    /**
     * fonction pour sauvegarder une partie
     * 
     * @param nom_sauv nom du fichier
     * @param g la grille à sauveagrder
     */
    public static void sauvegarder(String nom_sauv,char [][] grille)
    {
        try {
            ArrayList<Character> data=new ArrayList<Character>();
            
            data.add('*');
            char col=(char) (grille.length+'0');
            data.add(col);
            data.add(' ');
            char li=(char) (grille[0].length+'0');
            data.add(li);
            data.add(' ');
            for(int l=0;l<grille[0].length;l++){
                for(int c=0;c<grille.length;c++){
                   if(grille[c][l]!=' ') data.add(grille[c][l]);
                   else data.add('v');
                }
                data.add('.');
            }
            data.add(' ');
            data.add('*');
            
            File f=new File(nom_sauv);
            FileWriter fw=new FileWriter(f);
            for(char elmt : data){
                fw.write(elmt);
                fw.flush();
            }
            
            fw.close();
            
            System.out.println("Sauvegarde terminée");
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * fonction pour avoir la grille sauvegardée d'une partie
     * 
     * @param ns nom de la sauvegarde
     * @return grille la grille
     */
    public static char[][] partie_sauvegarde(String ns)
    {
        char[][] grille;
        ArrayList<Character> liste= new ArrayList<Character>();
        try {
            File f=new File(ns);
            FileReader fr=new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            //parcourir la liste pour en faire une grille
            int c = 0;             
            // Lire caractère par caractère
            while((c = br.read()) != -1)
            {
                // convertir l'entier en char
                char ch = (char) c;         
                // Afficher le caractère      
                liste.add(ch);
            }
            fr.close();
            br.close();
      
            int i=0; int j=0; int compt=0; int colonne=Character.getNumericValue(liste.get(1)); int ligne=Character.getNumericValue(liste.get(3));
            grille=new char[colonne][ligne];
            
            for(char elmt:liste){
                if(elmt!=liste.get(1) && elmt!=liste.get(2) && elmt!=liste.get(4) && elmt!=liste.get(3) && elmt!='.' && elmt!='*'){
                    if(i<colonne){
                        if(elmt=='v') grille[i][j]=' ';
                        else grille[i][j]=elmt;
                        i++;
                    }
                }
                
                if(elmt=='.' && j<ligne){
                    j++; i=0;
                }
            
            }  
            
            return grille;
        }catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    /**
     * fonction pour demander la hauteur de la grille
     * 
     * @return le nombre de ligne 
     */
    public static int taille_ligne(){
        Scanner s=new Scanner(System.in);
        System.out.println("Entrez la hauteur de la grille (>=4) :");
        int ligne=s.nextInt();
        
        while(ligne<4){ 
             System.out.println("Entrez la hauteur de la grille (>=4) :");
             return ligne=s.nextInt();
        }
       return ligne;
    }
    
    /**
     * fonction pour demander la taille de la colonne
     * 
     * @return le nombre de colonne 
     */
    public static int taille_colonne(){
        Scanner s=new Scanner(System.in);
        System.out.println("Entrez la largeur de la grille(>=4) :");
        int colonne=s.nextInt();
        while(colonne<4){
            System.out.println("Entrez la largeur de la grille(>=4) :");
            return colonne=s.nextInt();
        }
        return colonne;
    }
    
    /**
     * fonction pour faire un saut de ligne
     * 
     */
    public static void saut_ligne(){
        System.out.println("");
    }
    
          public static void main(String[] Args)
    {
        
       Scanner scanner=new Scanner(System.in);
        
       System.out.println("Voulez-vous jouer au puissance 4? ((Oui) pour oui ou (Non) pour non) ");
       String jouer=scanner.nextLine();
       
       if (jouer.equals("Oui") || jouer.equals("OUI") || jouer.equals("oui")){
        //saisir le nom du premier joueur
         System.out.println("Saisir le nom du premier joueur:");
         String nomj1=scanner.nextLine();
         saut_ligne();
        
         System.out.println("Saisissez le nom du deuxième joueur :");
         String nomj2=scanner.nextLine();
         saut_ligne();
         Joueur j1=new Joueur(true,nomj1,Case.X);
         Joueur j2=new Joueur(true,nomj2,Case.O);
         PartieH_H partie=new PartieH_H(j1,j2);
        
        //choisir la taille de la grille ou une sauvegarde
         char[][] g;
       
        /*g=partie_sauvegarde("D:\\sauvegarde.txt");
        Grille gr=new Grille(g);
        gr.afficher_grille();*/
        
         int tc=taille_colonne();
         int tl=taille_ligne();
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
            saut_ligne();
            
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
            saut_ligne();
            
            if(gr.detection_victoire(gr.getGrille(),coloj,jcour)==true){
                arret_jeu=true;
            }
            
            
            //deuxieme cas
        }
      }
      else {
          System.out.println("Très bien, à la prochaine !");
        }
    
    }

    
    //choix de partie
    //demander si on veut lancer une sauvegarde ou pas
    
}
