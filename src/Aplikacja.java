import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class Aplikacja {
    private ArrayList<Hotel> hotele;
    private ArrayList<Klient> klienci;
    private ArrayList<Manager> managerowie;
    private Sesja sesja;

    public Aplikacja(){
        hotele = new ArrayList<>();
        klienci = new ArrayList<>();
        managerowie = new ArrayList<>();
    }
    public void zaloguj(String login, String haslo, UserType type) {
        if (type == UserType.KLIENT) {
            var klient = klienci.stream().filter(k -> login.equals(k.getLogin()) && haslo.equals(k.getHaslo())).findAny();
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
                pracownik = h.getPracownicy().stream().filter(p-> login.equals(p.getLogin()) && haslo.equals(p.getHaslo())).findAny();
                if(!pracownik.isEmpty()) {
                    System.out.println("Witaj !");
                    System.out.print(pracownik.get().getNazwisko() + " ");
                    System.out.println(pracownik.get().getImie());
                }
            }
        }
        if (type == UserType.MANAGER){
            var manager = managerowie.stream().filter(m -> login.equals(m.getLogin()) && haslo.equals(m.getHaslo())).findAny();
            if (!manager.isEmpty()){
                System.out.println("Witaj !");
                System.out.print(manager.get().getNazwisko() + " ");
                System.out.println(manager.get().getImie());
            }
        }
    }
    public void zarzadzanieSesja(){
        sesja.start();
    }
    public void init(){
        Klient klient = new Klient();
        klient.setHaslo("123");
        klient.setId(1);
        klient.setLogin("elo");
        klient.setImie("Bartlomiej");
        klient.setNazwisko("Sawicki");
        klienci.add(klient);

        Hotel hotel = new Hotel();
        hotel.setNazwa("Super hotel");


        Pokoj pokoj = new Pokoj();
        pokoj.setNumer(10);

        Rezerwacja rezerwacja = new Rezerwacja();
        rezerwacja.setStan(RezerwationStates.Zarezerwowane);
        try {
            rezerwacja.setPoczatek(new SimpleDateFormat("dd.MM.yyyy").parse("13.12.2021"));
            rezerwacja.setKoniec(new SimpleDateFormat("dd.MM.yyyy").parse("15.12.2021"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        pokoj.addRezerwacja(rezerwacja,klient);

        hotel.getPokoje().add(pokoj);
        hotele.add(hotel);
    }
}
