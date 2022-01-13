import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class SesjaManagera extends Sesja {
    private Manager manager;
    private ArrayList<Hotel> hotele;
    public SesjaManagera(Manager manager, ArrayList<Hotel> hotele) {
        this.manager = manager;
        this.hotele = hotele;
    }
    void start(){
        while(true) {
            System.out.print(this.manager.getImie()+" ");
            System.out.println(this.manager.getNazwisko());
            System.out.println("Prosze wybrac opcje z listy:");
            System.out.println("1. Dodanie nowego hotelu");
            System.out.println("2. Usuniecie hotelu z listy");
            System.out.println("3. Zmiana danych hotelu");
            System.out.println("4. Pokaz liste hoteli");
            System.out.println("4. Wyloguj");

            String choice = "0";
            Scanner keyboard = new Scanner(System.in);
            choice = keyboard.next();

            if (choice.equals("1")) {
                addHotel();
            }
            if (choice.equals("2")) {
                removeHotel();
            }
            if (choice.equals("3")){
                changeHotelProperties();
            }
            if (choice.equals("4")){
                showHotele();
            }
            if (choice.equals("5")){
                return;
            }
        }
    }
    void addHotel(){
        Adres adres = askAboutAddress();
        Hotel hotel = new Hotel();
        hotel.setAdres(adres);
        while (askAboutRooms(hotel));
        hotele.add(hotel);
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
    Pokoj askAboutNewRoom(){
        String choice = "";
        Scanner keyboard = new Scanner(System.in);
        Pokoj pokoj = new Pokoj();
        System.out.println("Podaj numer pokoju:");
        choice = keyboard.nextLine();
        pokoj.setNumer(Integer.parseInt(choice));
        System.out.println("Podaj cene:");
        choice = keyboard.nextLine();
        pokoj.setCena(Integer.parseInt(choice));
        System.out.println("Podaj ilosc miejsc");
        choice = keyboard.nextLine();
        pokoj.setIloscMiejsc(Integer.parseInt(choice));
        return pokoj;
    }
    Adres askAboutAddress(){
        Adres adres = new Adres();
        String input = "";
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Prosze podac nazwe ulicy: ");
        input = keyboard.nextLine();
        adres.setUlica(input);
        System.out.println("Prosze podac numer budynku: ");
        input = keyboard.nextLine();
        adres.setNumerBudynku(Integer.parseInt(input));
        System.out.println("Prosze podac miasto: ");
        input = keyboard.nextLine();
        adres.setMiasto(input);
        System.out.println("Prosze podac kod pocztowy: ");
        input = keyboard.nextLine();
        adres.setKodPocztowy(input);
        return adres;
    }
    boolean askAboutRooms(Hotel hotel){
        System.out.println("Czy chcesz dodac pokoje do hotelu?");
        System.out.println("1. Tak");
        System.out.println("2. Nie");
        String choice = "";
        Scanner keyboard = new Scanner(System.in);
        choice = keyboard.nextLine();
        if(choice.equals("2")){
            return false;
        }
        else if (choice.equals("1")){
            Pokoj pokoj = new Pokoj();
            System.out.println("Podaj numer pokoju:");
            choice = keyboard.nextLine();
            pokoj.setNumer(Integer.parseInt(choice));
            System.out.println("Podaj cene:");
            choice = keyboard.nextLine();
            pokoj.setCena(Integer.parseInt(choice));
            System.out.println("Podaj ilosc miejsc");
            choice = keyboard.nextLine();
            pokoj.setIloscMiejsc(Integer.parseInt(choice));
            hotel.getPokoje().add(pokoj);
        }
        return true;
    }
    void showHotele(){
        for(Hotel h : hotele){
            System.out.println(h.toString());
        }
    }
    void removeHotel(){
        Hotel hotel = askAboutHotel();
        hotele.remove(hotel);
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
    void changeHotelProperties(){
        Hotel hotel = askAboutHotel();
        System.out.println("Jakie wlasciowsci zmienic");
        System.out.println("1. Adres");
        System.out.println("2. Usuniecie pokoju");
        System.out.println("3. Dodanie pokoju");
        System.out.println("4. Wroc");
        String choice = "";
        Scanner keyboard = new Scanner(System.in);
        choice = keyboard.nextLine();
        if(choice.equals("1")){
            Adres adres = askAboutAddress();
            hotel.setAdres(adres);
        }
        if (choice.equals("2")){
            Pokoj pokoj = askAboutRoom(hotel);
            hotel.getPokoje().remove(pokoj);
        }
        if(choice.equals("3")){

        }
        if (choice.equals("4")){
            return;
        }
    }

}
