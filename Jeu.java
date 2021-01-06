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
     */
    public static void sauvegarder(String nom_sauv,Grille g,Case [][] grille)
    {
        try {
            ArrayList<Character> data=new ArrayList<Character>();
            
            data.add('*');
            char col=(char) (g.getColonne()+'0');
            data.add(col);
            data.add(' ');
            char li=(char) (g.getLigne()+'0');
            data.add(li);
            for(int l=0;l<g.getLigne();l++){
                for(int c=0;c<g.getColonne();c++){
                    if(grille[c][l]!=Case.VIDE) data.add(grille[c][l].getRep());
                }
                data.add(' ');
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
     * fonction pour avoir la sauvegarde d'une partie
     * 
     */
    public static void sauvegarde(String ns)
    {
        Case[][] grille;
        ArrayList<Character> arraylist= new ArrayList<Character>();
        /*try {
            
            
            //parcourir la liste pour en faire une grille
        }  catch (IOException e) {
            e.printStackTrace();
        }*/
        
        //afficher la liste et reprendre la partie
    }
    
    /**
     * fonction pour demander la taille de la colonne
     * 
     * @return 
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
    
    public static void saut_ligne(){
        System.out.println("");
    }
    
    public static void main(String[] Args)
    {
        //saisir le nom du premier joueur
        
        Scanner scanner=new Scanner(System.in);
        System.out.println("Saisir le nom du premier joueur:");
        String nomj1=scanner.nextLine();
        saut_ligne();
        
        /*//choisir le jeton du premier joueur
        System.out.println("Joueur "+nomj1+", choisissez un jeton parmi X et O :");
        String jeton1=scanner.nextLine();
        
        
        
        //test tant que le jeu n'est pas lancé
        boolean jeulance=false;
        
        while(jeulance==false){
            //1er cas: si le jeton choisi est X on peut demander le nom du deuxième joueur et attribuer le jeton
            if(jeton1.equals("X")==true){
                System.out.println("Saisissez le nom du deuxième joueur :");
                String nomj2=scanner.nextLine();
                Joueur j1=new Joueur(true,nomj1,Case.X);
                Joueur j2=new Joueur(true,nomj2,Case.O);
                PartieH_H partie=new PartieH_H(j1,j2);
                jeulance=true;
                //choisir la taille de la grille ou une sauvegarde
                int c=taille_colonne();
                int l=taille_ligne();
                Grille gr=new Grille(c,l);
                gr.afficher_grille();
                //test sauvegarde
                sauvegarder("D:\\sauvegarde.txt", gr, gr.getGrille());
                //deuxieme cas
            }else if(jeton1.equals("0")==true){
                System.out.println("Saisissez le nom du deuxième joueur :");
                String nomj2=scanner.nextLine();
                Joueur j1=new Joueur(true,nomj1,Case.O);
                Joueur j2=new Joueur(true,nomj2,Case.X);
                PartieH_H partie=new PartieH_H(j1,j2);
                jeulance=true;
                //3eme cas: si le format du jeton est pas bon on redemande et la boucle recommence
            }else{
                System.out.println("Rentrez le bon format de jeton");
                jeton1=scanner.nextLine();
                jeulance=false;
            }
            //mettre un cas pour quitter quand on veut ??
        }*/
        
        System.out.println("Saisissez le nom du deuxième joueur :");
        String nomj2=scanner.nextLine();
        saut_ligne();
        Joueur j1=new Joueur(true,nomj1,Case.X);
        Joueur j2=new Joueur(true,nomj2,Case.O);
        PartieH_H partie=new PartieH_H(j1,j2);
        
        //choisir la taille de la grille ou une sauvegarde
        int tc=taille_colonne();
        int tl=taille_ligne();
        Grille gr=new Grille(tc,tl);
        gr.afficher_grille();
        
        boolean arret_jeu=false;
        
        Joueur jcour=new Joueur(j1);
        while(arret_jeu==false){
            //échanger joueur
            
            
            /*if(scanner.nextLine().equals("S")){
                sauvegarder("D:\\sauvegarde.txt", gr, gr.getGrille());
                arret_jeu=true;
            }*/
            
            System.out.println(j1.getNom()+", saisissez le numéro de la colonne où vous voulez jouer : ");
            int coloj=scanner.nextInt();
            while(coloj>tc){
                System.out.println("Veuillez saisir un numéro de colonne compris entre 1 et "+tc);
                coloj=scanner.nextInt();
            }
        
            while(gr.ajout_pion(j1, gr.getGrille(),coloj) == false){
                System.out.println("Veuillez saisir un numéro de colonne compris entre 1 et "+tc);
                coloj=scanner.nextInt();
            }
        
            gr.afficher_grille();
            
            if(gr.detection_victoire(gr.getGrille(),coloj,j1)==true){
                arret_jeu=true;
            }
            
            System.out.println(j2.getNom()+", saisissez le numéro de la colonne où vous voulez jouer : ");
            coloj=scanner.nextInt();
            
            while(coloj>tc){
                System.out.println("Veuillez saisir un numéro de colonne compris entre 1 et "+tc);
                coloj=scanner.nextInt();
            }
        
            while(gr.ajout_pion(j2, gr.getGrille(),coloj) == false){
                System.out.println("Veuillez saisir un numéro de colonne autre que : "+coloj);
                coloj=scanner.nextInt();
            }
        
            gr.afficher_grille();
            
            if(gr.detection_victoire(gr.getGrille(),coloj,j2)==true){
                arret_jeu=true;
            }
            //deuxieme cas
        }
    
    }

    
    //choix de partie
    //demander si on veut lancer une sauvegarde ou pas
    
}

