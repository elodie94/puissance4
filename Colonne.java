import java.util.ArrayList;

/**
 * Décrivez votre classe Colonne ici.
 *
 * @author JOLO Elodie, FEQQOUSSI Sarah
 * @version (un numéro de version ou une date)
 */
public class Colonne
{
    ArrayList<Colonne> liste_colonne = new ArrayList<Colonne>(); 
    ArrayList<Case> liste_case = new ArrayList<Case>(); 
    int index_dernière_libre;
    
    /**
     * Constructeur d'objets de classe Colonne
     */
    public Colonne(int index_dernière_libre)
    {
        // initialisation des variables d'instance
        this.index_dernière_libre = 0;
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  index_dernière_libre   le paramètre initialisé à 0 et prend +1 à chaque fois qu'on pose un pion
     * @return     true si la colonne est pleine, false sinon 
     */
    public boolean verifier_colonne_pleine(int index_dernière_libre)//Car index_dernière_libre est initialisé à 0 et a chaque fois qu'on pose un pion il prend +1
    {
        if (index_dernière_libre == 6) return true;
         else return false;
        
    }
    
    public boolean ajout_pion (Joueur j, int index_colonne, ArrayList liste_case){ // A revoir 
        if (index_colonne > 7 || index_dernière_libre >= 6) return false;
        else {
            liste_case.add (j.jeton_get());
            return true;
        }
    }
}
