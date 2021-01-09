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
     * @param grille la grille à sauvegarder
     */
    public static void sauvegarder(String nom_sauv,String [][] grille)
    {
        try {
            ArrayList<String> data=new ArrayList<String>();
            
            data.add("*");
            String col=String.valueOf(grille.length);
            data.add(col);
            data.add(" ");
            String li=String.valueOf(grille[0].length);
            data.add(li);
            data.add(" ");
            for(int l=0;l<grille[0].length;l++){
                for(int c=0;c<grille.length;c++) data.add(grille[c][l]);
                data.add(".");
            }
            data.add(" ");
            data.add("*");
            
            File f=new File(nom_sauv);
            FileWriter fw=new FileWriter(f);
            for(String elmt : data){
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
     * @return grille la grille avec les pions joués
     */
    public static String[][] partie_sauvegarde(String ns)
    {
        String[][] grille;
        
        try {
            File f=new File(ns);
            FileReader fr=new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            //parcourir la liste pour en faire une grille
            String c;
            String s="";
           
            while((c = br.readLine()) != null)
            {
                System.out.println("contenu fichier: "+c);
                s=c;
            }
            
            
            int j=0; int k=0;
            
            int colonne=Integer.parseInt(s.charAt(1)+"");
            int ligne=Integer.parseInt(""+s.charAt(3));
            System.out.println(colonne);
            grille=new String[colonne][ligne];
            for(int i=5;i<s.length();i++){
                if(s.charAt(i)==('.') && k<ligne) {
                    k++;
                    j=0;
                }else{
                    if(k<ligne && j<colonne) grille[j][k]=s.charAt(i)+"";
                    j++;
                }
                
            }
            fr.close();
            br.close();
            
            return grille;
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * fonction pour demander la largeur de la grille
     * 
     * @return la largeur des lignes de la grille 
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
     * fonction pour demander la hauteur de la grille
     * 
     * @return la hauteur des colonnes de la grille
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
    
}
