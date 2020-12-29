import java.util.Scanner;
/**
 * Classe qui va permettre de choisir le type de jeu voulu par l'utilisateur
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Jeu
{
    
    public static void main(String[] Args)
    {
        //saisir le nom du premier joueur
        Scanner scanner=new Scanner(System.in);
        System.out.println("Saisir le nom du premier joueur:");
        String nomj1=scanner.nextLine();
        //choisir le jeton du premier joueur
        System.out.println("Joueur"+nomj1+", choisissez un jeton parmi X et O :");
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
                //deuxieme cas
            }else if(jeton1.equals("0")==true){
                System.out.println("Saisissez le nom du deuxième joueur :");
                String nomj2=scanner.nextLine();
                Joueur j1=new Joueur(true,nomj1,Case.O);
                Joueur j2=new Joueur(true,nomj2,Case.X);
                PartieH_H partie=new PartieH_H(j1,j2);
                jeulance=true;
                //3eme cas: si le format du jeton est pas bon on redemande et la bpucle recommence
            }else{
                System.out.println("Rentrez le bon format de jeton");
                jeton1=scanner.nextLine();
                jeulance=false;
            }
        }
    }

    
    
    
}
