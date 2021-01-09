import java.util.Scanner;
import java.io.*;
/**
 * classe pour lancer une partie humain contre IA
 *
 * @author FEQQOUSSI Sarah JOLO Elodie
 * 
 */
public class PartieH_IA
{

    /**
     * Constructeur d'objets de classe PartieH_IA
     */
    public PartieH_IA()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Saisir le nom du joueur:");
        String nomj1=scanner.nextLine();
        Jeu.saut_ligne();

        Joueur j1=new Joueur(true,nomj1,Case.X);
        Joueur j2=new Joueur(false,"bot",Case.O);

        //choisir la taille de la grille ou une sauvegarde
        String[][] g;
        File f = new File("D:\\sauvegarde.txt");

        if(f.exists() && !f.isDirectory())
        {
            System.out.println("Voulez-vous lancer une sauvegarde ? (reponse oui ou non)");
            String reponse=scanner.nextLine();
            Jeu.saut_ligne();

            //lancement sauvegarde si reponse est oui
            if (reponse.equals("Oui") || reponse.equals("OUI") || reponse.equals("oui")){
                g=Jeu.partie_sauvegarde("D:\\sauvegarde.txt");
                Grille gr=new Grille(g);
                gr.afficher_grille();
                Jeu.saut_ligne();

                Joueur jcour;
                if(j1.getJeton().getRep().equals(gr.prochain_pion (g).getRep())) jcour=new Joueur(j1);
                else jcour=new Joueur(j2);

                boolean arret_jeu=false;
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

                        if(coloj==0){
                            Jeu.sauvegarder("D:\\sauvegarde.txt",gr.getGrille());
                            System.exit(0);
                        }

                        while(coloj<1 && coloj>gr.getColonne()){
                            System.out.println("Veuillez saisir un numéro de colonne compris entre 1 et "+gr.getColonne());
                            coloj=scanner.nextInt();
                            Jeu.saut_ligne();
                        }

                        while(gr.ajout_pion(jcour, gr.getGrille(),coloj) == false){
                            System.out.println("Veuillez saisir un numéro de colonne compris entre 1 et "+gr.getColonne()+" sauf "+coloj);
                            coloj=scanner.nextInt();
                            Jeu.saut_ligne();
                        }

                        gr.afficher_grille();
                        Jeu.saut_ligne();

                        if(gr.detection_victoire(gr.getGrille(),coloj,jcour)==true){
                            arret_jeu=true;
                        }

                        
                    }
                    else{
                        try { 
                            Thread.sleep(3000); 
                        } catch (InterruptedException e) { 
                            e.printStackTrace(); 
                        } 
                        
                        int coloj = gr.ajout_pion_IA (jcour, gr.getGrille());
                        gr.afficher_grille();
                        Jeu.saut_ligne();

                        if(gr.detection_victoire(gr.getGrille(),coloj,jcour)==true){ 
                            arret_jeu=true;
                        }
                    }
                }
            }else{
                int tc=Jeu.taille_colonne();
                int tl=Jeu.taille_ligne();
                Grille gr=new Grille(tc,tl);
                gr.afficher_grille();
                Jeu.saut_ligne();

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

                        if(coloj==0){
                            Jeu.sauvegarder("D:\\sauvegarde.txt",gr.getGrille());
                            System.exit(0);
                        }

                        while(coloj<1 && coloj>gr.getColonne()){
                            System.out.println("Veuillez saisir un numéro de colonne compris entre 1 et "+gr.getColonne());
                            coloj=scanner.nextInt();
                            Jeu.saut_ligne();
                        }

                        while(gr.ajout_pion(jcour, gr.getGrille(),coloj) == false){
                            System.out.println("Veuillez saisir un numéro de colonne compris entre 1 et "+gr.getColonne()+" sauf "+coloj);
                            coloj=scanner.nextInt();
                            Jeu.saut_ligne();
                        }

                        gr.afficher_grille();
                        Jeu.saut_ligne();

                        if(gr.detection_victoire(gr.getGrille(),coloj,jcour)==true){
                            arret_jeu=true;
                        }

                        //deuxieme cas
                    }
                    else{

                        try { 
                            Thread.sleep(3000); 
                        } catch (InterruptedException e) { 
                            e.printStackTrace(); 
                        } 

                        int coloj = gr.ajout_pion_IA (jcour, gr.getGrille());
                        gr.afficher_grille();
                        Jeu.saut_ligne();

                        if(gr.detection_victoire(gr.getGrille(),coloj,jcour)==true){ 
                            arret_jeu=true;
                        }
                    }
                }
            }
        }else{
            int tc=Jeu.taille_colonne();
            int tl=Jeu.taille_ligne();
            Grille gr=new Grille(tc,tl);
            gr.afficher_grille();
            Jeu.saut_ligne();

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

                    if(coloj==0){
                        Jeu.sauvegarder("D:\\sauvegarde.txt",gr.getGrille());
                        System.exit(0);
                    }

                    while(coloj<1 && coloj>gr.getColonne()){
                        System.out.println("Veuillez saisir un numéro de colonne compris entre 1 et "+gr.getColonne());
                        coloj=scanner.nextInt();
                        Jeu.saut_ligne();
                    }

                    while(gr.ajout_pion(jcour, gr.getGrille(),coloj) == false){
                        System.out.println("Veuillez saisir un numéro de colonne compris entre 1 et "+gr.getColonne()+" sauf "+coloj);
                        coloj=scanner.nextInt();
                        Jeu.saut_ligne();
                    }

                    gr.afficher_grille();
                    Jeu.saut_ligne();

                    if(gr.detection_victoire(gr.getGrille(),coloj,jcour)==true){
                        arret_jeu=true;
                    }

                    //deuxieme cas
                }
                else{
                    try { 
                        Thread.sleep(800); 
                    } catch (InterruptedException e) { 
                        e.printStackTrace(); 
                    } 

                    int coloj = gr.ajout_pion_IA (jcour, gr.getGrille());
                    gr.afficher_grille();
                    Jeu.saut_ligne();

                    if(gr.detection_victoire(gr.getGrille(),coloj,jcour)==true){ 
                        arret_jeu=true;
                    }

                }
            }
        }

    }

}
