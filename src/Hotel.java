import java.util.ArrayList;

public class Hotel {
    static int nextId;
    int id;
    String nazwa;
    Adres adres;
    int iloscPokoi;
    int iloscPracownikow;
    ArrayList<Pokoj> pokoje = new ArrayList<>();
    ArrayList<Pracownik> pracownicy;
    public Hotel(){
        this.id = nextId;
        nextId++;
    }
    @Override
    public String toString(){
        String s = "";
        s+= this.id + "     ";
        s+= this.nazwa + "      ";
        s+= this.adres.toString();
        return null;
    }
}
