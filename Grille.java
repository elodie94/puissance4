import java.util.Random;

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
    private String[][] grille; 
    private int nb_pions;

    /**
     * Constructeur d'objets de classe Grille
     * 
     * @param colonne la hauteur
     * @param ligne la largeur
     */

    public Grille(int colonne, int ligne)
    {
        this.colonne = colonne;
        this.ligne = ligne;
        grille= new String[colonne][ligne];
        
        //initialiser la grille vide
        for(int i=0;i<colonne;i++){
            for(int j=0;j<ligne;j++){
                grille[i][j]=Case.VIDE.getRep();
            }
        }
    }
    
    /**
     * Constructeur d'objets de classe Grille
     * 
     * @param grille la grille
     */
    
    public Grille(String[][] grille){
        this.colonne=grille.length;
        this.ligne=grille[0].length;
        this.grille=grille;
    }
    
    /**
     * Cette methode nous permet de savoir si une colonne est rempli ou non
     *
     * @param  grille       le paramètre, le tableau de case
     * @param  numcol       le numéro de colonne dont on souhaite savoir si elle est rempli ou pas 
     * @return              true si la colonne est rempli, false sinon
     */
    public boolean verifier_colonne (String[][] grille, int numcol){
        if (numcol > this.colonne) return true;
        
        if(numcol<0) return false;
         
        for (int i = 0; i<this.ligne; i++){
            if (grille[numcol-1][i].equals(Case.VIDE.getRep()))return false; 
        }
        return true;
    }
   
   
   
     /**
     * Cette methode nous permet de savoir si la grille est remplie ou pas 
     *
     * @param  grille       la grille dont on veut savoir si elle est pleine ou non
     * @return              true si la grille est rempli, false sinon
     */
    
    public boolean grille_pleine (String [][] grille){
       for (int i = 0; i<this.colonne; i++){  // Colonne 
           for (int j = 0; j<this.ligne; j++){// Lignes
               if (grille[i][j].equals(Case.VIDE.getRep())) return false;
           }
        }
        return true;
    }
   
    
     /**
     * Cette methode permet au joueur d'ajouter un pion 
     *
     * @param  j            Joueur qui doit jouer 
     * @param  grille       la grille dans laquelle on souhaite jouer
     * @param  colonne      le numéro de colonne dans laquelle le joueur souhaite placer son pion
     * @return              true si le pion a été ajouté ,sinon false
     */
    
    public boolean ajout_pion (Joueur j, String [][] grille, int colonne){
        if (verifier_colonne(grille , colonne) == true) { // Dans le cas ou la colonne est remplie
            System.out.println("Cette colonne est déja rempli");
            return false;
        } //Dans le cas ou il reste une place de libre dans la colonne
        
        for (int i = 0; i<this.ligne; i++){
            if (grille[colonne-1][i].equals(Case.VIDE.getRep())){ 
              grille[colonne-1][i]=(j.getJeton().getRep());//On place le jeton à la première case libre 
              return true;
            }
        }
        return false;
        
    }
    
    /**
     * Cette methode permet a l'ordinateur d'ajouter un pion 
     *
     * @param  j            Joueur qui doit jouer 
     * @param  grille       la grille dans laquelle on souhaite jouer
     * @param  colonne      le numéro de colonne dans laquelle le joueur souhaite placer son pion
     * @return              true si le pion a été ajouté ,sinon false
     */
    
    public int ajout_pion_IA(Joueur b, String [][] grille){
     
        Random r = new Random();
        int i = r.nextInt(this.colonne) ;
            
        if (verifier_colonne(grille ,(i+1)) == false){// Si la colonne n'est pas rempli on l'a parcours
            for (int j =0; j < this.ligne ; j++){
               if (grille[i][j] == Case.VIDE.getRep()){ 
                  grille[i][j] = b.getJeton().getRep();//On place le jeton à la première case libre 
                  System.out.println (i+1);
                  return i+1;
               }
            } 
        }
        else ajout_pion_IA (b, grille);
        
        
        return -1;
    }

    
    /**
     * Cette methode permet d'avoir la ligne du dernier pion joué
     *
     * @param  j            Joueur qui a joué 
     * @param  grille       la grille dans laquelle on souhaite jouer
     * @param  colonne      le numéro de colonne dans laquelle le joueur souhaite placer son pion
     * @return              -1 si la colonne est vide ou erreur,ligne du dernier pion joué dans la colonne
     */
    public int dernier_pion_joue (Joueur j, String [][] grille, int colonne){
        if (verifier_colonne(grille , colonne) == true) { // Dans le cas ou la colonne est remplie
            return this.ligne-1;
        } 
        
        if(colonne>this.colonne || 0>colonne) return -1;
        
        //Dans le cas ou il reste une place de libre dans la colonne
        
        for (int i = 0; i<this.ligne; i++){
            if (grille[colonne-1][i].equals(Case.VIDE.getRep())){ 
               return i-1;
            }
        }
        
        return -1;
        
    }
    
    
    /**
     * Cette methode permet d'avoir la ligne du dernier pion joué
     *
     * @param  grille       la grille dans laquelle on souhaite jouer
     * @return              Case.X si x a moins de pions, sinon Case.O
     */
    public Case prochain_pion (String [][] grille){
        if (verifier_colonne(grille , colonne) == true) { // Dans le cas ou la colonne est remplie
            return null;
        } //Dans le cas ou il reste une place de libre dans la colonne
        int co=0;
        int cx=0;
        for (int i = 0; i<this.colonne; i++){  // Colonne 
           for (int j = 0; j<this.ligne; j++){// Lignes
               if (grille[i][j].equals(Case.O.getRep())) co++;
               if (grille[i][j].equals(Case.X.getRep())) cx++;
           }
           
        }
          
        if(cx<=co) return Case.X;
        return Case.O;
    }
    
     /**
     * Cette methode nous permet de détecter s'il y'a eu une victoire
     *
     * @param  grille       la grille dans laquelle les joueurs jouent
     * @param  colonne      la colonne choisi par le joueur 
     * @return              un booléen annoncant une victoire/un match nul sinon continuation du jeu
     */
    public boolean detection_victoire (String[][]grille, int colonne, Joueur j ){
        // Detection de victoire à l'horizontale
        if (grille_pleine(grille) == true) {
                System.out.println("La partie se termine en match nul");
                return true;
        }
        
        if (dernier_pion_joue (j,grille,colonne) >-1){
            int ligne = dernier_pion_joue (j,grille,colonne); // Recuperation du numéro de ligne ou se trouve le pion ajouté
            
            if (detection_victoire_horizontale ( j, grille, colonne, ligne) == true 
            || detection_victoire_verticale(j, grille, colonne, ligne) == true
            ||detection_victoire_diago (j,grille, colonne, ligne)==true) {
                System.out.println ("Le joueur "+j.getNom()+" est le vainqueur");
                return true;
            }

        }   

        System.out.println("Vous pouvez continuer la partie");
        return false;
          
    }
    
    
     /**
     * Cette methode nous permet de détecter s'il y'a eu une victoire à l'horizontale
     *
     * @param  b            joueur qui a placé le jeton
     * @param  grille       la grille dans laquelle les joueurs jouent
     * @param  colonne      la colonne dans laquelle le jeton a été ajouté  
     * @param  ligne        la ligne dans laquelle le jeton a été ajouté 
     * @return              true si il y'a victoire, false sinon
     */
    
    public boolean detection_victoire_horizontale (Joueur b,String[][]grille, int colonne, int ligne){
        int repetition = 1;
        for (int i = colonne-1;  0<=i && i < this.colonne-1; i++){ //Vers la droite
            if (grille[i][ligne].equals(b.getJeton().getRep()) && grille [i][ligne].equals(grille [i+1][ligne]) ){
                repetition ++;
            }
        }
          
        for (int j = colonne-1;  1<=j && j < this.colonne; j--){ //Vers la gauche
            if (grille [j][ligne].equals(grille [j-1][ligne]) && grille[j][ligne].equals(b.getJeton().getRep())){
                repetition ++;
            }
        }
          
        if (repetition >= 4) return true;
        return false;
    }
    
     /**
     * Cette methode nous permet de détecter s'il y'a eu une victoire à la verticale
     *
     * @param  b            joueur qui a placé le jeton
     * @param  grille       la grille dans laquelle les joueurs jouent
     * @param  colonne      la colonne dans laquelle le jeton a été ajouté  
     * @param  ligne        la ligne dans laquelle le jeton a été ajouté 
     * @return              true si il y'a victoire, false sinon
     */
    
    public boolean detection_victoire_verticale (Joueur b,String[][] grille, int colonne, int ligne){
        int repetition = 1;
        /*for (int i = ligne;  0<=i && i <= this.ligne-1; i++){ 
            if (grille [colonne-1][i].equals(grille [colonne-1][i+1] ) && grille[colonne-1][i].equals(b.getJeton().getRep())){
                repetition ++;
            }
          }*/
          
        for (int j = ligne;  0<j && j < this.ligne; j--){ //Vers la gauche
            if (grille [colonne-1][j].equals(grille [colonne-1][j-1]) && grille[colonne-1][j].equals(b.getJeton().getRep())){
                repetition ++;
            }
          }
          
        if (repetition >= 4) return true;
        return false;
    }
    
     /**
     * Cette methode nous permet de détecter s'il y'a eu une victoire à la diagonale
     *
     * @param  b            joueur qui a placé le jeton
     * @param  grille       la grille dans laquelle les joueurs jouent
     * @param  colonne      la colonne dans laquelle le jeton a été ajouté  
     * @param  ligne        la ligne dans laquelle le jeton a été ajouté 
     * @return              true si il y'a victoire, false sinon
     */
    
    public boolean detection_victoire_diago (Joueur b,String[][] grille, int colonne, int ligne){
        int repetition = 1;
        int rep = 1;
        int l1=ligne; int l2=ligne;int l3=ligne; int l4=ligne;
        int c1=colonne-1;int c2=colonne-1;int c3=colonne-1;int c4=colonne-1;

        
        while(l1>0 && l1<this.ligne && c1>=0 && c1<this.colonne-1 && grille[c1][l1].equals(b.getJeton().getRep())){
            if(grille[c1][l1].equals(grille [c1 +1][l1 -1])) repetition ++;
            l1--;
            c1++;
        }

        
        while(l2>=0 && l2<this.ligne-1 && c2>=0 && c2<this.colonne-1 && grille[c2][l2].equals(b.getJeton().getRep())){
            if(grille[c2][l2].equals(grille [c2 +1][l2 +1])) rep ++;
            l2++;
            c2++;
        }
        
        
        while(l3>=0 && l3<this.ligne-1 && c3>0 && c3<this.colonne && grille[c3][l3].equals(b.getJeton().getRep())){
            if(grille[c3][l3].equals(grille [c3 -1][l3 +1])) repetition ++;
            l3++;
            c3--;
        }
        
        
        while(l4>0 && l4<this.ligne && c4>0 && c4<this.colonne && grille[c4][l4].equals(b.getJeton().getRep())){
            if(grille[c4][l4].equals(grille [c4 -1][l4 -1])) rep ++;
            l4--;
            c4--;
        }
          
        if (repetition >= 4 || rep >= 4 ) return true;
       
        return false;
    }




    /**
     * afficher la grille
     * 
     */
    public void afficher_grille()
    {
        //pour avoir les numéros de colonnes
        System.out.print(" ");
        for(int nc=1;nc<=this.colonne;nc++){
            System.out.print(nc+" ");
        }
        System.out.println("");
        //pour afficher le contenu de la grille
        for(int i=(this.ligne-1);i>=0;i--){
            System.out.print("|");
            for(int j=0;j<this.colonne;j++){
                System.out.print(grille[j][i]+"|");
            }
            System.out.println("");
        }
    }
    
    /**
     * accesseur pour recupérer la hauteur des colonnes de la grille
     * 
     * @return colonne
     */
    public int getColonne(){
        return this.colonne;
    }
    
    /**
     * accesseur pour recupérer la largeur des lignes de la grille
     * 
     * @return ligne
     */
    public int getLigne(){
        return this.ligne;
    }
    
    /**
     * accesseur pour recupérer la grille
     * 
     * @return grille
     */
    public String[][] getGrille(){
        return this.grille;
    }
}