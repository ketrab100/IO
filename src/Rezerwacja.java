import java.util.Date;

public class Rezerwacja{
    static int nextId;
    private int id;
    private Date poczatek;
    private Date koniec;
    private RezerwationStates stan;
    private Klient klient;
    public Rezerwacja(){
        id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPoczatek() {
        return poczatek;
    }

    public void setPoczatek(Date poczatek) {
        this.poczatek = poczatek;
    }

    public Date getKoniec() {
        return koniec;
    }

    public void setKoniec(Date koniec) {
        this.koniec = koniec;
    }

    public RezerwationStates getStan() {
        return stan;
    }

    public void setStan(RezerwationStates stan) {
        this.stan = stan;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }
}

enum RezerwationStates{
    Wolne,
    Zarezerwowane,
    OczekiwanieNaPotwierdzenie,
    OczekiwanieNaAnulowanie
}

