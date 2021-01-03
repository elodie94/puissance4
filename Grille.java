import java.util.ArrayList;
/**
 * Classe représentant la grille du puissance 4
 *
 * @author JOLO Elodie, FEQQOUSSI Sarah
 * @version (un numéro de version ou une date)
 */
public class Grille
{
    private int nb_pions;

    /**
     * Constructeur d'objets de classe Grille
     */
    public Grille(int nb_pions){
        this.nb_pions = nb_pions;
        
    }
    
          
       /**
     * Cette methode nous permet de savoir si la grille est remplie ou pas 
     *
     * @param  liste_colonne  la liste de colonne
     * @param  liste_case     la liste de case
     * @return              true si la grille est rempli, false sinon
     */
    
   public boolean grille_pleine (ArrayList liste_colonne, ArrayList liste_case)
   {
       if (liste_colonne.size() > 7 || liste_case.size() > 35) return true;
       else return false;
     }
   
   

    /**
     * Cette methode nous permet d'afficher la grille
     * 
     */
    public void afficher_grille(ArrayList liste_colonne, ArrayList liste_case)
    {
        // Afficher la première ligne
        for(int i = 0; i < liste_colonne.size(); i++){
         System.out.println(liste_colonne.get(i));
         
         //Afficher la colonne en entière à partir de l'index récupéré dans la boucle précédente 
         for(int j=1; j<liste_case.size(); j++){ 
             // System.out.println (liste_colonne.get(i).liste_case.get(j)); Ca ne compile pas
            }
        }
    }
}
