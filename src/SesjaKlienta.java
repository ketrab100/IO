import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SesjaKlienta extends Sesja {
    Klient klient;
    ArrayList<Hotel> hotele;

    public SesjaKlienta(Klient klient, ArrayList<Hotel> hotele) {
        this.klient = klient;
        this.hotele = hotele;
    }
    void start() {
        while (true) {
            System.out.print(this.klient.nazwisko + " ");
            System.out.println(this.klient.imie);

            System.out.println("Prosze wybrac opcje z listy:");
            System.out.println("1. Zarezerowanie pokoju");
            System.out.println("2. Anulowoanie rezerwacji");
            System.out.println("3. Zmiana terminu rezerwacji");
            System.out.println("4. Pokaz wszystkie rezerwacje");
            System.out.println("5. Pokaz stan pokoi w hotelu");
            System.out.println("6. Wyloguj");
            String choice = "0";

            Scanner keyboard = new Scanner(System.in);
            choice = keyboard.next();

            if (choice.equals("1")) {
                zarezerwowaniePokoju();
            }
            if (choice.equals("2")) {
                anulowanieRezerwacji();
            }
            if(choice.equals("3")){
                zamianaTerminuRezerwacji();
            }
            if(choice.equals("4")){
                showRezerwations();
            }
            if(choice.equals("5")){
                showRezerwationsInHotel();
            }
            if (choice.equals("6")){
                return;
            }
        }
    }
    void zarezerwowaniePokoju(){
        Hotel hotel = askAboutHotel();
        Pokoj pokoj = askAboutRoom(hotel);
        Rezerwacja rezerwacja = askAboutDates();
        if (rezerwacja==null){
            System.out.println("Blad podczas podawania daty");
            return;
        }
        int ret =pokoj.addRezerwacja(rezerwacja,klient);
        if (ret == 1) {
            System.out.println("Dodano rezerwacje");
        }else if (ret == -1){
            System.out.println("W podanym terminie pokoj jest juz zajety");
        }else  if (ret == -2){
            System.out.println("W podanym terminie użytkownik ma juz rezerwacje");
        }
    }
    void anulowanieRezerwacji(){
        Rezerwacja rezerwacja = askAboutReserwation();
        klient.rezerwacje.remove(rezerwacja);
        for (Hotel h : hotele){
            for(Pokoj p : h.pokoje){
                p.rezerwacje.remove(rezerwacja);
            }
        }
    }
    void showRezerwations(){
        for (int i =0;i<klient.rezerwacje.size();i++){
            System.out.print(i +".");
            System.out.print(klient.rezerwacje.get(i).poczatek.toString() + " - ");
            System.out.println(klient.rezerwacje.get(i).poczatek.toString());
        }
    }
    void zamianaTerminuRezerwacji(){
        Rezerwacja oldRezerwation = askAboutReserwation();
        Rezerwacja newRezerwation = askAboutDates();
        if (newRezerwation==null){
            System.out.println("Blad podczas podawania daty");
            return;
        }
        Pokoj pokoj = null;
        for (Hotel h : hotele){
            for(Pokoj p : h.pokoje){
                for(Rezerwacja r : p.rezerwacje){
                    if(r.id == oldRezerwation.id){
                        pokoj = p;
                    }
                }
            }
        }
        int ret = pokoj.addRezerwacja(newRezerwation,klient);
        if (ret == 1) {
            System.out.println("Dodano rezerwacje");
        }else if (ret == -1){
            System.out.println("W podanym terminie pokoj jest juz zajety");
        }else  if (ret == -2){
            System.out.println("W podanym terminie użytkownik ma juz rezerwacje");
        }

    }
    void showRezerwationsInHotel(){
        Hotel hotel = askAboutHotel();
        for(Pokoj p : hotel.pokoje){
            System.out.println("Pokoj numer: "+p.numer);
            for(Rezerwacja r : p.rezerwacje){
                if(r.stan == RezerwationStates.Zarezerwowane){
                    System.out.println(r.poczatek + " " + r.koniec + "zarezerwowane");
                }
            }
        }
    }
    Hotel askAboutHotel(){
        System.out.println("Prosze wybrac hotel z listy:");
        for(int i =1;i<=hotele.size();i++) {
            System.out.print(i+". ");
            System.out.println(hotele.get(i-1).nazwa);
        }
        String choice = "0";
        Scanner keyboard = new Scanner(System.in);
        choice = keyboard.nextLine();
        Hotel hotel = hotele.get(Integer.parseInt(choice)-1);
        return hotel;
    }
    Pokoj askAboutRoom(Hotel hotel){
        System.out.println("Prosze wybrac pokoj z listy:");
        for(int i =1;i<=hotel.pokoje.size();i++) {
            System.out.print(i+". ");
            System.out.println("Pokoj numer " + hotel.pokoje.get(i-1).numer);
        }
        String choice = "0";
        Scanner keyboard = new Scanner(System.in);
        choice = keyboard.nextLine();
        Pokoj pokoj = hotel.pokoje.get(Integer.parseInt(choice)-1);
        return pokoj;
    }
    Rezerwacja askAboutDates(){
        String choice = "0";
        Scanner keyboard = new Scanner(System.in);
        Date start = null;
        Date end = null;
        System.out.println("Prosze podac date rozpoczęcia pobytu w formacie dd.mm.yyyy");
        choice = keyboard.nextLine();
        try {
            start = new SimpleDateFormat("dd.MM.yyyy").parse(choice);
        } catch (ParseException e) {}
        System.out.println("Prosze podac date zakonczenia pobytu w formacie dd.mm.yyyy");
        choice = keyboard.nextLine();
        try {
            end = new SimpleDateFormat("dd.MM.yyyy").parse(choice);
        } catch (ParseException e) {}

        if(start != null && end != null) {
            Rezerwacja rezerwacja = new Rezerwacja();
            rezerwacja.klient = klient;
            rezerwacja.poczatek = start;
            rezerwacja.koniec = end;
            rezerwacja.stan = RezerwationStates.OczekiwanieNaPotwierdzenie;
            return rezerwacja;
        }
        return null;
    }
    Rezerwacja askAboutReserwation(){
        showRezerwations();
        String choice = "0";
        Scanner keyboard = new Scanner(System.in);
        Rezerwacja rezerwacja = klient.rezerwacje.get(Integer.parseInt(choice));
        return rezerwacja;
    }
}
