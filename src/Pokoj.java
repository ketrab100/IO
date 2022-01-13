import java.util.ArrayList;
import java.util.Collections;

public class Pokoj {
    private int numer;
    private int cena;
    private int iloscMiejsc;
    private ArrayList<Rezerwacja> rezerwacje = new ArrayList<Rezerwacja>();

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getIloscMiejsc() {
        return iloscMiejsc;
    }

    public void setIloscMiejsc(int iloscMiejsc) {
        this.iloscMiejsc = iloscMiejsc;
    }

    public ArrayList<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

    public void setRezerwacje(ArrayList<Rezerwacja> rezerwacje) {
        this.rezerwacje = rezerwacje;
    }

    int addRezerwacja(Rezerwacja rezerwacja, Klient klient){
        RezerwacjaComparator rezerwacjaComparator = new RezerwacjaComparator();
        Collections.sort(rezerwacje, rezerwacjaComparator);

        boolean wrongDate = false;
        boolean collision = false;
        for (int i =0;i<rezerwacje.size();i++) {
            if (rezerwacja.getPoczatek().after(rezerwacje.get(i).getPoczatek()) && rezerwacja.getPoczatek().before(rezerwacje.get(i).getKoniec())){
                wrongDate=true;
            }
            if (rezerwacja.getKoniec().after(rezerwacje.get(i).getPoczatek()) && rezerwacja.getKoniec().before(rezerwacje.get(i).getKoniec())){
                wrongDate=true;
            }
        }
        for (int i =0 ;i<klient.getRezerwacje().size();i++){
            if (rezerwacja.getPoczatek().after(klient.getRezerwacje().get(i).getPoczatek()) && rezerwacja.getPoczatek().before(klient.getRezerwacje().get(i).getKoniec())){
                collision=true;
            }
            if (rezerwacja.getKoniec().after(klient.getRezerwacje().get(i).getPoczatek()) && rezerwacja.getKoniec().before(klient.getRezerwacje().get(i).getKoniec())){
                collision=true;
            }
        }
        if (collision == true){
            return -2;
        }else if (wrongDate == true) {
            return -1;
        }
        else{
            rezerwacje.add(rezerwacja);
            klient.getRezerwacje().add(rezerwacja);
            return 1;
        }
    }
}


