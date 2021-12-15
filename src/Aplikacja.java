import java.util.ArrayList;
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
                sesja = new SesjaKlienta(klient.get());
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
    }
}
