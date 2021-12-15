import java.util.ArrayList;
import java.util.Optional;

public class SesjaKlienta extends Sesja {
    Klient klient;

    public SesjaKlienta(Klient klient) {
        this.klient = klient;
    }
    void start() {
        super.start();
        System.out.print(this.klient.nazwisko + " ");
        System.out.println(this.klient.imie);

        System.out.println("Prosze wybrac opcje z listy:");
        System.out.println("1. Zarezerowanie pokoju");
        System.out.println("2. Anulwoanie rezerwacji");
        int choice=1;

        //TODO choice = keyboard input

        if (choice == 1) {
            zarezerwowaniePokoju();
        }
        if (choice == 2){
            anulowanieRezerwacji();
        }
    }
    void zarezerwowaniePokoju(){
        //TODO
    }
    void anulowanieRezerwacji(){
        //TODO
    }

}
