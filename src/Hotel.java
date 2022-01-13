import java.util.ArrayList;

public class Hotel {
    static int nextId = 1;
    private int id;
    private String nazwa;
    private Adres adres;
    private ArrayList<Pokoj> pokoje = new ArrayList<>();
    private ArrayList<Pracownik> pracownicy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public ArrayList<Pokoj> getPokoje() {
        return pokoje;
    }

    public void setPokoje(ArrayList<Pokoj> pokoje) {
        this.pokoje = pokoje;
    }

    public ArrayList<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(ArrayList<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }

    public Hotel(){
        this.id = nextId;
        nextId++;
    }
    @Override
    public String toString(){
        String s = "";
        s+= this.id + " ";
        s+= this.nazwa + " ";
        s+= this.adres.toString();
        return s;
    }
}
