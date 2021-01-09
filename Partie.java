import java.util.Scanner;
import java.io.*;
import  java.util.concurrent.TimeUnit; 
/**
 * Cette classe nous permet de lancer une partie 
 *
 * @author JOLO Elodie, FEQQOUSSI Sarah
 * @version 09/01/2021
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
            Jeu.saut_ligne();

            int jeu;
     
            try{
                jeu = Integer.parseInt(s.next());
                
                if (jeu == 2){
                    PartieH_H p=new PartieH_H();
                    
                }else if (jeu ==1){
                    PartieH_IA p=new PartieH_IA();
                    
                }
            } catch (NumberFormatException e){
                System.out.println ("La valeur entrée n'est pas un entier");
                Jeu.saut_ligne();
            }

        } else {
            System.out.println("Très bien, à la prochaine !");
            System.exit(0);
        }

    }

}
