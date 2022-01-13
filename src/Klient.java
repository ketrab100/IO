import java.util.ArrayList;

public class Klient {
    private int id;
    private String imie;
    private String nazwisko;
    private ArrayList<Rezerwacja> rezerwacje = new ArrayList<Rezerwacja>();
    private String login;
    private String haslo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public ArrayList<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

    public void setRezerwacje(ArrayList<Rezerwacja> rezerwacje) {
        this.rezerwacje = rezerwacje;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}
