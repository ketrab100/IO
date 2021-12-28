import java.util.ArrayList;
import java.util.Scanner;

public class SesjaPracownika {
    Pracownik pracownik;
    Hotel hotel;

    public SesjaPracownika(Pracownik pracownik, Hotel hotel) {
        this.pracownik = pracownik;
        this.hotel = hotel;
    }
    void start(){
        while(true) {
            System.out.print(this.pracownik.imie+" ");
            System.out.println(this.pracownik.nazwisko);
            System.out.println("Prosze wybrac opcje z listy:");
            System.out.println("1. Potwierdzenie rezerwacji");
            System.out.println("2. Odrzucenie rezerwacji");
            System.out.println("3. Pokarz wszystkie rezerwacje");
            System.out.println("4. Wyloguj");

            String choice = "0";
            Scanner keyboard = new Scanner(System.in);
            choice = keyboard.next();

            if (choice.equals("1")) {
                potwierdzenieRezerwacji();
            }
            if (choice.equals("2")) {
                odrzucenieRezerwacji();
            }
            if (choice.equals("3")){
                showRezerwationsInHotel();
            }
            if (choice.equals("4")){
                return;
            }
        }
    }
    void potwierdzenieRezerwacji(){
        Rezerwacja rezerwacja = askAboutReserwation();
        rezerwacja.stan = RezerwationStates.Zarezerwowane;
    }
    void odrzucenieRezerwacji(){
        Rezerwacja rezerwacja = askAboutReserwation();
        rezerwacja.stan = RezerwationStates.Wolne;
    }
    void showRezerwationsInHotel(){
        for(Pokoj p : hotel.pokoje){
            System.out.println("Pokoj numer: "+p.numer);
            for(Rezerwacja r : p.rezerwacje){
                if(r.stan == RezerwationStates.Zarezerwowane){
                    System.out.println(r.poczatek + " " + r.koniec + "zarezerwowane");
                }
            }
        }
    }
    void showRezerwations(){
        ArrayList<Rezerwacja> res = new ArrayList<>();
        for(Pokoj p : hotel.pokoje) {
            for (Rezerwacja r : p.rezerwacje) {
                res.add(r);
            }
        }
        for (int i =0 ;i<res.size();i++){
            System.out.print(i +".");
            System.out.print(res.get(i).poczatek.toString() + " - ");
            System.out.print(res.get(i).poczatek.toString() + "    ");
            System.out.println(res.get(i).stan.toString());
        }
    }
    Rezerwacja askAboutReserwation(){
        showRezerwations();
        ArrayList<Rezerwacja> res = new ArrayList<>();
        for(Pokoj p : hotel.pokoje) {
            for (Rezerwacja r : p.rezerwacje) {
                res.add(r);
            }
        }
        String choice = "0";
        Scanner keyboard = new Scanner(System.in);
        Rezerwacja rezerwacja = res.get(Integer.parseInt(choice));
        return rezerwacja;
    }



}
