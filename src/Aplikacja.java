import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class Aplikacja {
    ArrayList<Hotel> hotele;
    ArrayList<Klient> klienci;
    ArrayList<Manager> managerowie;
    Sesja sesja;

    public Aplikacja(){
        hotele = new ArrayList<>();
        klienci = new ArrayList<>();
        managerowie = new ArrayList<>();
    }
    public void zaloguj(String login, String haslo, UserType type) {
        if (type == UserType.KLIENT) {
            var klient = klienci.stream().filter(k -> login.equals(k.login) && haslo.equals(k.haslo)).findAny();
            if (klient.isEmpty()) {
                System.out.println("blad");
            } else {
                sesja = new SesjaKlienta(klient.get(),hotele);
                sesja.start();
            }
        }
        if (type == UserType.PRACOWNIK){
            Optional<Pracownik> pracownik;
            for (var h: hotele) {
                pracownik = h.pracownicy.stream().filter(p-> login.equals(p.login) && haslo.equals(p.haslo)).findAny();
                if(!pracownik.isEmpty()) {
                    System.out.println("Witaj !");
                    System.out.print(pracownik.get().nazwisko + " ");
                    System.out.println(pracownik.get().imie);
                }
            }
        }
        if (type == UserType.MANAGER){
            var manager = managerowie.stream().filter(m -> login.equals(m.login) && haslo.equals(m.haslo)).findAny();
            if (!manager.isEmpty()){
                System.out.println("Witaj !");
                System.out.print(manager.get().nazwisko + " ");
                System.out.println(manager.get().imie);
            }
        }
    }
    public void zarzadzanieSesja(){
        sesja.start();
    }
    public void init(){
        Klient klient = new Klient();
        klient.haslo = "123";
        klient.id = 1;
        klient.login = "elo";
        klient.imie = "Bartlomiej";
        klient.nazwisko = "Sawicki";
        klienci.add(klient);

        Hotel hotel = new Hotel();
        hotel.nazwa = "Super hotel";


        Pokoj pokoj = new Pokoj();
        pokoj.numer = 10;

        Rezerwacja rezerwacja = new Rezerwacja();
        rezerwacja.stan = "zarezerwowane";
        try {
            rezerwacja.poczatek = new SimpleDateFormat("dd.MM.yyyy").parse("13.12.2021");
            rezerwacja.koniec = new SimpleDateFormat("dd.MM.yyyy").parse("15.12.2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        pokoj.addRezerwacja(rezerwacja,klient);

        hotel.pokoje.add(pokoj);
        hotele.add(hotel);
    }
}
