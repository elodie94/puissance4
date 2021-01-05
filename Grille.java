               /**
     * Cette methode permet au joueur d'ajouter un pion 
     *
     * @param  j            Joueur qui doit jouer 
     * @param  [][]grille   la grille dans laquelle on souhaite jouer
     * @param  colonne      le numéro de colonne dans laquelle le joueur souhaite placer son pion
     * @return              true si l'ajout a été fait, false si l'ajout n'a pas pu se faire
     */
    
    public boolean ajout_pion (Joueur j, Case [][] grille, int colonne){
        if (verifier_colonne(grille, colonne) == false) { // Dans le cas ou la colonne est remplie
            System.out.println("Cette colonne est déja rempli");
            return false;
       }
       else { //Dans le cas ou il reste une place de libre dans la colonne
            for (int i = 0; i<6; i++){
               if (grille[colonne][i] != Case.VIDE){ 
                   grille[colonne][i] = j.getJeton();//On place le jeton à la première case libre 
                   return true ;
               }
            }
          return false;
        }
    }
