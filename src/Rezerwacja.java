import java.util.Date;

public class Rezerwacja{
    static int nextId;
    int id;
    Date poczatek;
    Date koniec;
    RezerwationStates stan;
    Klient klient;
    public Rezerwacja(){
        id = nextId;
        nextId++;
    }
}

enum RezerwationStates{
    Wolne,
    Zarezerwowane,
    OczekiwanieNaPotwierdzenie,
    OczekiwanieNaAnulowanie
}

