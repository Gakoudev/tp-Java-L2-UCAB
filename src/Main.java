import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
    ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
    ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
    Scanner sc = new Scanner(System.in);

    void main() {
        int choix,continuer;
        do {
            affichageMenu();
            choix = Integer.parseInt(sc.nextLine());
            switch (choix) {
                case 1:
                    saisiEnseignant();
                    break;
                case 2:
                    saisiEtudiant();
                    break;
                case 3:
                    ajouterNotes();
                    break;
                case 4:
                    affichageEnseignant();
                    break;
                case 5:
                    affichageEtudiant();
                    break;
                case 6:
                    afficherAnnuaire();
                    break;
                case 7:
                    rechercherEtudiant();
                    break;
                case 8:
                    break;
                case 9:
                    System.out.println("Bye Bye !!!!!!!!!");
                    break;
                default:
                    System.out.println("Erreur !!!!!!!!!");
            }
            System.out.println("1 pour retourner au menu ou une autre touche pour quitter");
            continuer =  Integer.parseInt(sc.nextLine());
        }while (continuer == 1);


    }
    public void affichageMenu(){
        System.out.println("**********Menu***********");
        System.out.printf("* %-23s*\n","1. Saisire Enseignant");
        System.out.printf("* %-23s*\n","2. Saisire Etudiant");
        System.out.printf("* %-23s*\n","3. Saisire Note");
        System.out.printf("* %-23s*\n","4. Afficher Enseignant");
        System.out.printf("* %-23s*\n","5. Afficher Etudiant");
        System.out.printf("* %-23s*\n","6. Afficher Annuaire");
        System.out.printf("* %-23s*\n","7. Rechercher Etudiant");
        System.out.printf("* %-23s*\n","8. Generer Bulletin");
        System.out.printf("* %-23s*\n","9. Quitter");
        System.out.println("***********Menu***********");
    }

    public void saisiEnseignant(){
        String nom,prenom,matiere;
        int continuer=0;
        System.out.println("****Saisie Enseignant*****");
        do {
            System.out.print("Nom :");
            nom = sc.nextLine();
            System.out.print("Prenom :");
            prenom = sc.nextLine();
            System.out.print("Matiere :");
            matiere = sc.nextLine();
            Enseignant e = new Enseignant(nom,prenom,matiere);
            enseignants.add(e);
            System.out.println("Clicquer sur 1 pour continuer ou une autre touche pour quitter");
            continuer =  Integer.parseInt(sc.nextLine());
        }while (continuer == 1);
    }

    public void saisiEtudiant(){
        String nom,prenom,matricule;
        int continuer=0;
        System.out.println("****Saisie Etudiant*****");
        do {
            System.out.print("Nom :");
            nom = sc.nextLine();
            System.out.print("Prenom :");
            prenom = sc.nextLine();
            System.out.print("Matricule :");
            matricule = sc.nextLine();
            Etudiant e = new Etudiant(matricule,nom,prenom);
            etudiants.add(e);
            System.out.println("Clicquer sur 1 pour continuer ou une autre touche pour quitter");
            continuer =  Integer.parseInt(sc.nextLine());
        }while (continuer == 1);
    }
    public void affichageEnseignant(){
        System.out.println("****Affichage Enseignant*****");
        if(enseignants.isEmpty()){
            System.out.println("Aucun Enseignant !!!!!!!!!");
        }else{
            for(Enseignant e:enseignants){
                System.out.printf("* %-26s*\n",e);
            }
        }
        System.out.println("**Fin Affichage Enseignant***");
    }
    public void affichageEtudiant(){
        System.out.println("**** Affichage Etudiant *****");
        if(etudiants.isEmpty()){
            System.out.println("Aucun Etudiant !!!!!!!!!");
        }else{
            for(Etudiant e:etudiants){
                System.out.printf("* %-26s*\n",e);
            }
        }
        System.out.println("** Fin Affichage Etudiant ***");
    }
    public void rechercherEtudiant(){
        String matricule;
        System.out.println("**** Rechercher Etudiant *****");
        System.out.print("Matricule : ");
        matricule = sc.nextLine();
        Etudiant e = rechercherParMatricule(matricule);
        if(e == null){
            System.out.println("Etudiant non trouvé!!!!!!!!!!!");
        }else {
            System.out.printf("* %-26s*\n",e);
        }
        System.out.println("** Fin Rechercher Etudiant ***");
    }
    public Etudiant rechercherParMatricule(String matricule){
        for (Etudiant e:etudiants){
            if(e.getMatricule().equals(matricule)){
                return e;
            }
        }
        return null;
    }
    public void ajouterNotes(){
        int continuer=0;
        Double valeur;
        String matricule,matiere;
        System.out.println("***** Ajouter Note *****");
        System.out.print("Matricule : ");
        matricule = sc.nextLine();
        Etudiant e = rechercherParMatricule(matricule);
        if(e == null){
            System.out.println("Etudiant non trouvé!!!!!!!!!!!");
        }else {
            do {
                System.out.print("Matière :");
                matiere = sc.nextLine();
                System.out.print("Valeur :");
                valeur = Double.parseDouble(sc.nextLine());
                Note n = new Note(matricule,valeur);
                e.ajouterNote(n);
                System.out.println("1 pour continuer ou une autre touche pour quitter");
                continuer =  Integer.parseInt(sc.nextLine());
            }while (continuer == 1);
        }
        System.out.println("** Fin Rechercher Etudiant ***");

    }
    public void afficherAnnuaire(){
        ArrayList<Personne> personnes =  new ArrayList();
        for (Etudiant e:etudiants){
            personnes.add(e);
        }
        for (Enseignant ens:enseignants){
            personnes.add(ens);
        }
        System.out.println("**** Annuaire ***");
        for(Personne p:personnes){
            System.out.println(p);
        }
        System.out.println("**** Fin Annuaire ***");
    }
}
