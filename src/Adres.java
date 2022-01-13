public class Adres {

    private String ulica;
    private int numerBudynku;
    private String miasto;
    private String kodPocztowy;

    public String getUlica() {
        return ulica;
    }

    public int getNumerBudynku() {
        return numerBudynku;
    }

    public String getMiasto() {
        return miasto;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public void setNumerBudynku(int numerBudynku) {
        this.numerBudynku = numerBudynku;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }
    @Override
    public String toString() {
        String s = "";
        s += this.ulica + " ";
        s += this.numerBudynku + " ";
        s += this.miasto;
        return s;
    }
}
