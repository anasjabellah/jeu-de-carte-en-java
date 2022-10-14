

public class Carte {


    public int getCouleur;
    Couleur couleur;
    int ValueCart ;


    public Carte(Couleur couleur, int valueCart) {
        this.couleur = couleur;
        ValueCart = valueCart;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public int getValueCart() {
        return ValueCart;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public void setValueCart(int valueCart) {
        ValueCart = valueCart;
    }

    @Override
    public String toString() {
        return "" +
                "" + ValueCart +
                " " +  couleur  ;
    }
}
