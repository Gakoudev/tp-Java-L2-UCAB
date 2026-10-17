import java.util.ArrayList;

public class Etudiant extends Personne{
    private String matricule;
    public ArrayList<Note> notes =  new ArrayList();
    public Etudiant(String matricule, String nom, String prenom) {
        super(nom, prenom);
        this.matricule = matricule;
    }
    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public String toString(){
        return matricule + " " + prenom + " " + nom;
    }

    public void ajouterNote(Note n){
        notes.add(n);
    }
}
