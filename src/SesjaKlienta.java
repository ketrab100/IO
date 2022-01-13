import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SesjaKlienta extends Sesja {
    private Klient klient;
    private ArrayList<Hotel> hotele;

    public SesjaKlienta(Klient klient, ArrayList<Hotel> hotele) {
        this.klient = klient;
        this.hotele = hotele;
    }
    void start() {
        while (true) {
            System.out.print(this.klient.getNazwisko() + " ");
            System.out.println(this.klient.getImie());

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
        klient.getRezerwacje().remove(rezerwacja);
        for (Hotel h : hotele){
            for(Pokoj p : h.getPokoje()){
                p.getRezerwacje().remove(rezerwacja);
            }
        }
    }
    void showRezerwations(){
        for (int i =0;i<klient.getRezerwacje().size();i++){
            System.out.print(i +".");
            System.out.print(klient.getRezerwacje().get(i).getPoczatek().toString() + " - ");
            System.out.println(klient.getRezerwacje().get(i).getKoniec().toString());
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
            for(Pokoj p : h.getPokoje()){
                for(Rezerwacja r : p.getRezerwacje()){
                    if(r.getId() == oldRezerwation.getId()){
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
        for(Pokoj p : hotel.getPokoje()){
            System.out.println("Pokoj numer: "+p.getNumer());
            for(Rezerwacja r : p.getRezerwacje()){
                if(r.getStan() == RezerwationStates.Zarezerwowane){
                    System.out.println(r.getPoczatek() + " " + r.getKoniec() + "zarezerwowane");
                }
            }
        }
    }
    Hotel askAboutHotel(){
        System.out.println("Prosze wybrac hotel z listy:");
        for(int i =1;i<=hotele.size();i++) {
            System.out.print(i+". ");
            System.out.println(hotele.get(i-1).getNazwa());
        }
        String choice = "0";
        Scanner keyboard = new Scanner(System.in);
        choice = keyboard.nextLine();
        Hotel hotel = hotele.get(Integer.parseInt(choice)-1);
        return hotel;
    }
    Pokoj askAboutRoom(Hotel hotel){
        System.out.println("Prosze wybrac pokoj z listy:");
        for(int i =1;i<=hotel.getPokoje().size();i++) {
            System.out.print(i+". ");
            System.out.println("Pokoj numer " + hotel.getPokoje().get(i-1).getNumer());
        }
        String choice = "0";
        Scanner keyboard = new Scanner(System.in);
        choice = keyboard.nextLine();
        Pokoj pokoj = hotel.getPokoje().get(Integer.parseInt(choice)-1);
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
            rezerwacja.setKlient(klient);
            rezerwacja.setPoczatek(start);
            rezerwacja.setKoniec(end);
            rezerwacja.setStan(RezerwationStates.OczekiwanieNaPotwierdzenie);
            return rezerwacja;
        }
        return null;
    }
    Rezerwacja askAboutReserwation(){
        showRezerwations();
        String choice = "0";
        Scanner keyboard = new Scanner(System.in);
        Rezerwacja rezerwacja = klient.getRezerwacje().get(Integer.parseInt(choice));
        return rezerwacja;
    }
}
