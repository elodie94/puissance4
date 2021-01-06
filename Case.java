/**
 * Enumeration Case - Représentation de la case dans le jeu avec vide pour une case vide, X pour représenter le jeton d'un joueur et O pour représenter le jeton du deuxième joueur
 *
 * @author JOLO Elodie FEQQOUSSI SARAH
 * @version 28/12/2020
 */
public enum Case
{
    VIDE(' '), X('X'), O('O');
    
    //représentation de la case
    private char rep;
    
    private Case(char rep)
    {
        this.rep=rep;
    }
    
    /**
     * constructeur pour récupérer le représentation de la case
     * 
     * @return rep représentation de la case
     */
    public char getRep()
    {
        return this.rep;
    }
}
