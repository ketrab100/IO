import java.util.ArrayList;
import java.util.Scanner;

public class SesjaPracownika {
    private Pracownik pracownik;
    private Hotel hotel;

    public SesjaPracownika(Pracownik pracownik, Hotel hotel) {
        this.pracownik = pracownik;
        this.hotel = hotel;
    }
    void start(){
        while(true) {
            System.out.print(this.pracownik.getImie()+" ");
            System.out.println(this.pracownik.getNazwisko());
            System.out.println("Prosze wybrac opcje z listy:");
            System.out.println("1. Potwierdzenie rezerwacji");
            System.out.println("2. Odrzucenie rezerwacji");
            System.out.println("3. Pokaz wszystkie rezerwacje");
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
        rezerwacja.setStan(RezerwationStates.Zarezerwowane);
    }
    void odrzucenieRezerwacji(){
        Rezerwacja rezerwacja = askAboutReserwation();
        rezerwacja.setStan(RezerwationStates.Wolne);
    }
    void showRezerwationsInHotel(){
        for(Pokoj p : hotel.getPokoje()){
            System.out.println("Pokoj numer: "+p.getNumer());
            for(Rezerwacja r : p.getRezerwacje()){
                if(r.getStan() == RezerwationStates.Zarezerwowane){
                    System.out.println(r.getPoczatek() + " " + r.getKoniec() + "zarezerwowane");
                }
            }
        }
    }
    void showRezerwations(){
        ArrayList<Rezerwacja> res = new ArrayList<>();
        for(Pokoj p : hotel.getPokoje()) {
            for (Rezerwacja r : p.getRezerwacje()) {
                res.add(r);
            }
        }
        for (int i =0 ;i<res.size();i++){
            System.out.print(i +".");
            System.out.print(res.get(i).getPoczatek().toString() + " - ");
            System.out.print(res.get(i).getPoczatek().toString() + "    ");
            System.out.println(res.get(i).getStan().toString());
        }
    }
    Rezerwacja askAboutReserwation(){
        showRezerwations();
        ArrayList<Rezerwacja> res = new ArrayList<>();
        for(Pokoj p : hotel.getPokoje()) {
            for (Rezerwacja r : p.getRezerwacje()) {
                res.add(r);
            }
        }
        String choice = "0";
        Scanner keyboard = new Scanner(System.in);
        Rezerwacja rezerwacja = res.get(Integer.parseInt(choice));
        return rezerwacja;
    }



}
