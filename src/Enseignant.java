public class Enseignant extends Personne {
//    ATTRIBUT
    private String matiere;

//    METHODE
    Enseignant(String nom, String prenom, String matiere) {
        super(nom, prenom);
        this.matiere = matiere;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getMatiere() {
        return matiere;
    }
    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String toString(){
        return prenom + " " + nom + " " + matiere;
    }
}
