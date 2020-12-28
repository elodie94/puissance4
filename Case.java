/**
 * Enumeration Case - Représentation de la case dans le jeu avec vide pour une case vide, X pour représenter le jeton d'un joueur et O pour représenter le jeton du deuxième joueur
 *
 * @author JOLO Elodie FEQQOUSSI SARAH
 * @version (numéro de version ou date)
 */
public enum Case
{
    VIDE("_"), X("X"), O("O");
    
    //représentation de la case
    private String rep;
    
    private Case(String rep)
    {
        this.rep=rep;
    }
    
    /**
     * constructeur pour récupérer le représentation de la case
     * 
     * @return rep représentation de la case
     */
    public String getRep()
    {
        return this.rep;
    }
}
