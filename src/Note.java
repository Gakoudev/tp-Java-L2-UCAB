public class Note {
    private String matiere;
    private Double valeur;

    Note(String matiere, Double valeur) {
        this.matiere = matiere;
        this.valeur = valeur;
    }
    public String getMatiere() {
        return matiere;
    }
    public Double getValeur() {
        return valeur;
    }
    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }
}
