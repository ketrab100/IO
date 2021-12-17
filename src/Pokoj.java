import java.util.ArrayList;
import java.util.Collections;

public class Pokoj {
    int numer;
    int cena;
    int iloscMiejsc;
    ArrayList<Rezerwacja> rezerwacje;

    int addRezerwacja(Rezerwacja rezerwacja){
        RezerwacjaComparator rezerwacjaComparator = new RezerwacjaComparator();
        Collections.sort(rezerwacje, rezerwacjaComparator);
        boolean wrongDate = false;
        for (int i =0;i<rezerwacje.size();i++) {
            if (rezerwacja.poczatek.after(rezerwacje.get(i).poczatek) && rezerwacja.poczatek.before(rezerwacje.get(i).koniec)){
                wrongDate=true;
            }
            if (rezerwacja.koniec.after(rezerwacje.get(i).poczatek) && rezerwacja.koniec.before(rezerwacje.get(i).koniec)){
                wrongDate=true;
            }
        }
        if (wrongDate == false) {
            rezerwacje.add(rezerwacja);
            return 1;
        }
        else{
            return -1;
        }
    }
}
