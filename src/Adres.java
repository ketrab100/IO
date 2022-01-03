public class Adres {
    String ulica;
    int numerBudynku;
    String miasto;
    String kodPocztowy;

    @Override
    public String toString() {
        String s = "";
        s += this.ulica + " ";
        s += this.numerBudynku + " ";
        s += this.miasto;
        return s;
    }
}
