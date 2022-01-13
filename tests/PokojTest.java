import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PokojTest {
    @Test
    void addRezerwacja() {
        Pokoj pokoj = new Pokoj();
        Klient klient = new Klient();
        Rezerwacja rezerwacja =  new Rezerwacja();
        try {
            rezerwacja.setPoczatek(new SimpleDateFormat("dd.MM.yyyy").parse("10.10.2022"));
            rezerwacja.setKoniec(new SimpleDateFormat("dd.MM.yyyy").parse("20.10.2022"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(pokoj.addRezerwacja(rezerwacja,klient),1);


        rezerwacja =  new Rezerwacja();
        try {
            rezerwacja.setPoczatek(new SimpleDateFormat("dd.MM.yyyy").parse("11.10.2022"));
            rezerwacja.setKoniec(new SimpleDateFormat("dd.MM.yyyy").parse("12.10.2022"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(pokoj.addRezerwacja(rezerwacja,klient),-2);


        klient = new Klient();
        rezerwacja =  new Rezerwacja();
        try {
            rezerwacja.setPoczatek(new SimpleDateFormat("dd.MM.yyyy").parse("14.10.2022"));
            rezerwacja.setKoniec(new SimpleDateFormat("dd.MM.yyyy").parse("15.10.2022"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(pokoj.addRezerwacja(rezerwacja,klient),-1);


        rezerwacja =  new Rezerwacja();
        try {
            rezerwacja.setPoczatek(new SimpleDateFormat("dd.MM.yyyy").parse("21.10.2022"));
            rezerwacja.setKoniec(new SimpleDateFormat("dd.MM.yyyy").parse("25.10.2022"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(pokoj.addRezerwacja(rezerwacja,klient),1);
    }
}