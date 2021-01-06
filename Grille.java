/**
 * Classe représentant la grille du puissance 4
 *
 * @author JOLO Elodie, FEQQOUSSI Sarah
 * @version (un numéro de version ou une date)
 */
public class Grille
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private final int colonne, ligne;
    private Case[][] grille; //ou ArrayList<Colonne> grille;
    private int nb_pions;

    /**
     * Constructeur d'objets de classe Grille
     */

    public Grille(int colonne, int ligne)
    {
        this.colonne = colonne;
        this.ligne = ligne;
        grille=new Case[colonne][ligne];
        
        //initialiser la grille vide
        for(int i=0;i<colonne;i++){
            for(int j=0;j<ligne;j++){
                grille[i][j]=Case.VIDE;
            }
        }
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
            for (int i = 0; i< grille[colonne].length; i++){
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
       for (int i = 0; i<grille.length; i++){  // Colonne 
           for (int j = 0; j< grille[i].length /*ligne*/; j++){// Lignes
               if (grille[i][j] != Case.VIDE) return false;
            }
        }
        return true;
    }
   
    
              /**
     * Cette methode permet au joueur d'ajouter un pion 
     *
     * @param  j            Joueur qui doit jouer 
     * @param  [][]grille   la grille dans laquelle on souhaite jouer
     * @param  colonne      le numéro de colonne dans laquelle le joueur souhaite placer son pion
     * @return              le numéro de ligne du pion ajouté si l'ajout a été fait,-1 si l'ajout n'a pas pu se faire
     */
    
    public int ajout_pion (Joueur j, Case [][] grille, int colonne){
        if (verifier_colonne(grille , colonne) == false) { // Dans le cas ou la colonne est remplie
            System.out.println("Cette colonne est déja rempli");
            return -1;
        }
       else { //Dans le cas ou il reste une place de libre dans la colonne
            for (int i = 0; i<6; i++){
               if (grille[colonne][i] != Case.VIDE){ 
                   grille[colonne][i] = j.getJeton();//On place le jeton à la première case libre 
                   return i ;
               }
            }
          return -1;
        }
    }
    
          /**
     * Cette methode nous permet de détecter s'il y'a eu une victoire
     *
     * @param  [][]grille   la grille dans laquelle les joueurs jouent
     * @param  colonne      la colonne choisi par le joueur 
     * @return              un String annoncant le vainqueur/ un match nul 
     */
    public String detection_victoire (Case[][]grille, int colonne, Joueur j ){
        // Detection de victoire à l'horizontale
        if (ajout_pion (j,grille,colonne) >-1){
            int ligne = ajout_pion (j,grille,colonne); // Recuperation du numéro de ligne ou se trouve le pion ajouté
            
            if (detection_victoire_horizontale ( grille, colonne, ligne) == true) return "Le joueur "+j+" est le vainqueur";
            if (detection_victoire_verticale( grille, colonne, ligne) == true) return "Le joueur "+j+" est le vainqueur";
            if (detection_victoire_diago (grille, colonne, ligne) == true) return "Le joueur "+j+" est le vainqueur";
            //Ici il manque la detection de victoire diagonale
            
            if (grille_pleine (grille) == true) return "La partie se termine en match nul";
        }
        return "Vous pouvez continuer la partie";
    }
    
    
             
    /**
     * Cette methode nous permet de détecter s'il y'a eu une victoire à l'horizontale
     *
     * @param  [][]grille   la grille dans laquelle les joueurs jouent
     * @param  colonne      la colonne dans laquelle le jeton a été ajouté  
     * @param  ligne        la ligne dans laquelle le jeton a été ajouté 
     * @return              true si il y'a victoire, false sinon
     */
    
    public boolean detection_victoire_horizontale (Case[][]grille, int colonne, int ligne){
        int repetition = 1;
        for (int i = colonne;  0<=i && i < grille.length; i++){ //Vers la droite
            if (grille [i][ligne] == grille [i+1][ligne] ){
                repetition ++;
            }
          }
          
        for (int j = colonne;  1<=j && j < grille.length -1; j++){ //Vers la gauche
            if (grille [j][ligne] == grille [j-1][ligne] ){
                repetition ++;
            }
          }
          
        if (repetition >= 4) return true;
        else return false;
    }
    
                /**
     * Cette methode nous permet de détecter s'il y'a eu une victoire à la verticale
     *
     * @param  [][]grille   la grille dans laquelle les joueurs jouent
     * @param  colonne      la colonne dans laquelle le jeton a été ajouté  
     * @param  ligne        la ligne dans laquelle le jeton a été ajouté 
     * @return              true si il y'a victoire, false sinon
     */
    
    public boolean detection_victoire_verticale (Case[][]grille, int colonne, int ligne){
        int repetition = 1;
        for (int i = ligne;  0<=i && i < grille[colonne].length; i++){ //Vers la droite
            if (grille [colonne][i] == grille [colonne][i+1] ){
                repetition ++;
            }
          }
          
        for (int j = ligne;  1<=j && j < grille[colonne].length; j++){ //Vers la gauche
            if (grille [colonne][j] == grille [colonne][j-1] ){
                repetition ++;
            }
          }
          
        if (repetition >= 4) return true;
        else return false;
    }
    
                     /**
     * Cette methode nous permet de détecter s'il y'a eu une victoire à la verticale
     *
     * @param  [][]grille   la grille dans laquelle les joueurs jouent
     * @param  colonne      la colonne dans laquelle le jeton a été ajouté  
     * @param  ligne        la ligne dans laquelle le jeton a été ajouté 
     * @return              true si il y'a victoire, false sinon
     */
    
    public boolean detection_victoire_diago (Case[][]grille, int colonne, int ligne){
        int repetition = 1;
        for (int i = ligne;  0<i && i < grille[colonne].length; i--){ //Vers la droite // compteur ligne
            for (int j = colonne; 0<j && j <grille.length; j++){ // compteur colonne
            if (grille [j][i] == grille [j+1][i-1] ){
                repetition ++;
            }
          }
        }
          
         for (int i = ligne;  0<i && i < grille[colonne].length; i++){ //Vers la gauche // compteur ligne
            for (int j = colonne; 0<j &&j <grille.length; j--){ // compteur colonne
            if (grille [j][i] == grille [j-1][i+1] ){
                repetition ++;
            }
          }
        }
          
        if (repetition >= 4) return true;
        else return false;
    }
    
    /**
     * afficher la grille
     * 
     */
    public void afficher_grille()
    {
        //pour avoir les numéros de colonnes
        for(int nc=1;nc<colonne;nc++){
            System.out.print(nc);
        }
        System.out.println("");
        //pour afficher le contenu de la grille
        for(int i=0;i<ligne;i++){
            System.out.print("|");
            for(int j=0;j<colonne;j++){
                //modif ici
                System.out.print(grille[j][i]+"|");
            }
            System.out.println("");
        }
    }


   public int getColonne(){
    return this.colonne;
   }
    
   public int getLigne(){
    return this.ligne;
  
   }

   public Case[][] getGrille(){
    return this.grille;
   }
}
