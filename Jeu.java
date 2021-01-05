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
            ArrayList data=new ArrayList();
            
            data.add('*');
            data.add(g.getColonne());
            data.add(' ');
            data.add(g.getLigne());
            for(int l=0;l<g.getLigne();l++){
                for(int c=0;c<g.getColonne();c++){
                    if(grille[c][l]!=Case.VIDE) data.add(grille[c][l]);
                }
                data.add(' ');
            }
            FileOutputStream fileOut = new FileOutputStream(nom_sauv);
            ObjectOutputStream oos = new ObjectOutputStream(fileOut);
            oos.writeObject(data);
            oos.close();
            fileOut.close();
            System.out.println("Sauvegarde terminée");
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        ArrayList<String> arraylist= new ArrayList<String>();
        try {
            FileInputStream fileIn = new FileInputStream(ns);
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            arraylist = (ArrayList) ois.readObject();
            ois.close();
            fileIn.close();
            
            //parcourir la liste pour en faire une grille
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        //afficher la liste et reprendre la partie
    }
    
    public static int taille_colonne(){
        Scanner s=new Scanner(System.in);
        System.out.println("Entrez la hauteur de la grille (>=4) :");
        int ligne=s.nextInt();
        
        while(ligne<4){ 
             System.out.println("Entrez la hauteur de la grille (>=4) :");
             return ligne=s.nextInt();
        }
       return ligne;
    }
    
    public static int taille_ligne(){
        Scanner s=new Scanner(System.in);
        System.out.println("Entrez la largeur de la grille(>=4) :");
        int colonne=s.nextInt();
        while(colonne<4){
            System.out.println("Entrez la largeur de la grille(>=4) :");
            return colonne=s.nextInt();
        }
        return colonne;
    }
    
    public static void main(String[] Args)
    {
        //saisir le nom du premier joueur
        Scanner scanner=new Scanner(System.in);
        System.out.println("Saisir le nom du premier joueur:");
        String nomj1=scanner.nextLine();
        
        //choisir le jeton du premier joueur
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
                Grille g=new Grille(c,l);
                g.afficher_grille();
                sauvegarder("s",g,g.getGrille());
                //deuxieme cas
            }else if(jeton1.equals("O")==true){
                System.out.println("Saisissez le nom du deuxième joueur :");
                String nomj2=scanner.nextLine();
                Joueur j1=new Joueur(true,nomj1,Case.O);
                Joueur j2=new Joueur(true,nomj2,Case.X);
                PartieH_H partie=new PartieH_H(j1,j2);
                jeulance=true;
                
                int c=taille_colonne();
                int l=taille_ligne();
                Grille g=new Grille(c,l);
                g.afficher_grille();
                sauvegarder("s",g,g.getGrille());
                //3eme cas: si le format du jeton est pas bon on redemande et la bpucle recommence
            }else{
                System.out.println("Le format entré n'est pas bon, choisissez un jeton parmi X et O");
                jeton1=scanner.nextLine();
                jeulance=false;
            }
            //mettre un cas pour quitter quand on veut ??
        }
    }

    
    //choix de partie
    //demander si on veut lancer une sauvegarde ou pas
    
}
