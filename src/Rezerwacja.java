import java.util.Date;

public class Rezerwacja{
    static int nextId;
    int id;
    Date poczatek;
    Date koniec;
    String stan;
    Klient klient;
    public Rezerwacja(){
        id = nextId;
        nextId++;
    }
}

