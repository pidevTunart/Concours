package Entites;

public class Concours {
    private int reference;
    private int prix;
    private String date;
    private String type;
    private String Lien;


    public Concours(int reference, int prix, String date, String type, String lien) {
        this.reference = reference;
        this.prix = prix;
        this.date = date;
        this.type = type;
        this.Lien = lien;
    }
    public Concours(int prix, String date, String type, String lien) {
        this.prix = prix;
        this.date = date;
        this.type = type;
        this.Lien = lien;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLien() {
        return Lien;
    }

    public void setLien(String lien) {
        Lien = lien;
    }
    @Override
    public String toString() {
        return "Personne{" +
                "id=" + reference +
                ", nom='" + prix + '\'' +
                ", prenom='" + date + '\'' +
                ", age=" + type +
                ", age=" + Lien +
                '}';
    }
}
