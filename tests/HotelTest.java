import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void testToString() {
        Hotel hotel = new Hotel();
        hotel.setNazwa("Super Hotel");
        Adres adres = new Adres();
        adres.setMiasto("Wroclaw");
        adres.setUlica("Plac Grunwaldzki");
        adres.setNumerBudynku(100);
        adres.setKodPocztowy("50-123");
        hotel.setAdres(adres);
        assertEquals(hotel.toString(),"1 Super Hotel " + adres.toString());
    }
    @Test
    void testId(){
        Hotel hotel1 = new Hotel();
        Hotel hotel2 = new Hotel();
        Hotel hotel3 = new Hotel();
        assertEquals(hotel1.getId(), 1);
        assertEquals(hotel2.getId(), 2);
        assertEquals(hotel3.getId(), 3);
    }
}

