
/**
 * Classe représentant la grille du puissance 4
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Grille
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private final int colonne, ligne;
    private Case[][] grille;
    private int nb_pions;

    /**
     * Constructeur d'objets de classe Grille
     */
    // public Grille(int c,int l)
    // {
        // // initialisation des variables d'instance
        // this.colonne=7+2;
        // this.ligne=6+2;
    // }
    
 
    public Grille(int [][] grille, int colonne, int ligne)
    {
        this.colonne = colonne;
        this.ligne = ligne;
    }
    
    /**
     * Cette methode nous permet de savoir si une colonne est rempli ou non
     *
     * @param  [][]grille   le paramètre, le tableau de case
     * @param  colonne      le numéro de colonne dont on souhaite savoir si elle est rempli ou pas 
     * @return              true si la colonne est rempli, false sinon
     */
    public boolean verifier_colonne (Case [][]grille, int colonne){
        if (colonne > 7) return true;
        else { 
            for (int i = 0; i<6; i++){
                if (grille[colonne][i] == Case.VIDE)return false; 
            }
        return true;
       }
   }
   
   
       /**
     * Cette methode nous permet de savoir si la grille est remplie ou pas 
     *
     * @param  [][]grille   la grille dont on veut savoir si elle est pleine ou non
     * @return              true si la grille est rempli, false sinon
     */
   public boolean grille_pleine (Case [][] grille){
       for (int i = 0; i<7 ; i++){  // Colonne 
           for (int j = 0; j<6; j++){// Lignes
               if (grille[i][j] != Case.VIDE) return false;
            }
        }
        return true;
    }
   
           /**
     * Cette methode nous permet de détecter s'il y'a eu une victoire
     *
     * @param  [][]grille   la grille dont on veut savoir si elle est pleine ou non
     * @return              0 si il y'a match nulle, 1 si le joueur aux pions X a gagné et 2 si je joueur aux pions O a gagné
     */
  // public int detection_victoire (Case[][]grille){
       
   
    // }
}