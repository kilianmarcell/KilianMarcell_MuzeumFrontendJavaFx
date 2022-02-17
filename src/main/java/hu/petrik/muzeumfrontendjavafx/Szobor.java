package hu.petrik.muzeumfrontendjavafx;

public class Szobor {
    private int id;
    private String ember;
    private int magassag;
    private int ertek;

    public Szobor(int id, String ember, int magassag, int ertek) {
        this.id = id;
        this.ember = ember;
        this.magassag = magassag;
        this.ertek = ertek;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmber() {
        return ember;
    }

    public void setEmber(String ember) {
        this.ember = ember;
    }

    public int getMagassag() {
        return magassag;
    }

    public void setMagassag(int magassag) {
        this.magassag = magassag;
    }

    public int getErtek() {
        return ertek;
    }

    public void setErtek(int ertek) {
        this.ertek = ertek;
    }
}
