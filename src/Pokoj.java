import java.util.ArrayList;
import java.util.Collections;

public class Pokoj {
    int numer;
    int cena;
    int iloscMiejsc;
    ArrayList<Rezerwacja> rezerwacje = new ArrayList<Rezerwacja>();

    int addRezerwacja(Rezerwacja rezerwacja, Klient klient){
        RezerwacjaComparator rezerwacjaComparator = new RezerwacjaComparator();
        Collections.sort(rezerwacje, rezerwacjaComparator);

        boolean wrongDate = false;
        boolean colision = false;
        for (int i =0;i<rezerwacje.size();i++) {
            if (rezerwacja.poczatek.after(rezerwacje.get(i).poczatek) && rezerwacja.poczatek.before(rezerwacje.get(i).koniec)){
                wrongDate=true;
            }
            if (rezerwacja.koniec.after(rezerwacje.get(i).poczatek) && rezerwacja.koniec.before(rezerwacje.get(i).koniec)){
                wrongDate=true;
            }
        }
        for (int i =0 ;i<klient.rezerwacje.size();i++){
            if (rezerwacja.poczatek.after(klient.rezerwacje.get(i).poczatek) && rezerwacja.poczatek.before(klient.rezerwacje.get(i).koniec)){
                colision=true;
            }
            if (rezerwacja.koniec.after(klient.rezerwacje.get(i).poczatek) && rezerwacja.koniec.before(klient.rezerwacje.get(i).koniec)){
                colision=true;
            }
        }
        if (colision == true){
            return -2;
        }else if (wrongDate == true) {
            return -1;
        }
        else{
            rezerwacje.add(rezerwacja);
            klient.rezerwacje.add(rezerwacja);
            return 1;
        }
    }
}
