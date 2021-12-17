import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

public class SesjaKlienta extends Sesja {
    Klient klient;
    ArrayList<Hotel> hotele;

    public SesjaKlienta(Klient klient, ArrayList<Hotel> hotele) {
        this.klient = klient;
        this.hotele = hotele;
    }
    void start() {
        super.start();
        System.out.print(this.klient.nazwisko + " ");
        System.out.println(this.klient.imie);

        System.out.println("Prosze wybrac opcje z listy:");
        System.out.println("1. Zarezerowanie pokoju");
        System.out.println("2. Anulowoanie rezerwacji");
        String choice = "0";

        Scanner keyboard = new Scanner(System.in);
        choice = keyboard.next();

        if (choice.equals("1")) {
            this.zarezerwowaniePokoju();
        }
        if (choice.equals("1")){
            anulowanieRezerwacji();
        }
    }
    void zarezerwowaniePokoju(){
        System.out.println("Prosze wybrac hotel z listy:");
        for(int i =1;i<hotele.size()+1;i++) {
            System.out.print(i+". ");
            System.out.println(hotele.get(i-1).nazwa);
        }
        String choice = "0";
        Scanner keyboard = new Scanner(System.in);
        choice = keyboard.nextLine();
        Hotel hotel = hotele.get(Integer.parseInt(choice)-1);
        System.out.println("Prosze wybrac pokoj z listy:");
        for(int i =1;i<hotel.pokoje.size();i++) {
            System.out.print(i+". ");
            System.out.println(hotel.pokoje.get(i-1).numer);
        }
        choice = keyboard.nextLine();
        Pokoj pokoj = hotel.pokoje.get(Integer.parseInt(choice)-1);
        Date start = null;
        Date end = null;
        System.out.println("Prosze podac date rozpoczęcia pobytu w formacie dd.mm.yyyy");
        choice = keyboard.nextLine();
        try {
            start = new SimpleDateFormat("dd.MM.yyyy").parse(choice);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Prosze podac date zakonczenia pobytu w formacie dd.mm.yyyy");
        choice = keyboard.nextLine();
        try {
            end = new SimpleDateFormat("dd.MM.yyyy").parse(choice);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Rezerwacja rezerwacja = new Rezerwacja();
        if(start != null && end != null) {
            rezerwacja.klient = klient;
            rezerwacja.poczatek = start;
            rezerwacja.koniec = end;
            rezerwacja.stan = "rezerwacja";
        }
        if (pokoj.addRezerwacja(rezerwacja)==1) {
            System.out.println("Dodano rezerwacje");
        }


        //TODO
    }
    void anulowanieRezerwacji(){
        //TODO
    }

}
