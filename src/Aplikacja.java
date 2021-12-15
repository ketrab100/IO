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
    public void zaloguj(String login, String haslo, int type) {
        if (type == 1) {
            var klient = klienci.stream().filter(k -> login.equals(k.login) && haslo.equals(k.haslo)).findAny();
            if (klient.isEmpty()) {
                System.out.println("blad");
            } else {
                System.out.println("Witaj !");
                System.out.print(klient.get().nazwisko + " ");
                System.out.println(klient.get().imie);
            }
        }
        if (type == 2){
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
        if (type == 3){
            var manager = managerowie.stream().filter(m -> login.equals(m.login) && haslo.equals(m.haslo)).findAny();
            if (!manager.isEmpty()){
                System.out.println("Witaj !");
                System.out.print(manager.get().nazwisko + " ");
                System.out.println(manager.get().imie);
            }
        }


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
