import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @org.junit.jupiter.api.Test
    void testToString() {
        Hotel hotel = new Hotel();
        hotel.nazwa = "Super Hotel";
        Adres adres = new Adres();
        adres.miasto = "Wroclaw";
        adres.ulica = "Plac Grunwaldzki";
        adres.numerBudynku = 100;
        adres.kodPocztowy = "50-123";
        hotel.adres = adres;
        assertEquals(hotel.toString(),"1 Super Hotel " + adres.toString());
    }
    @org.junit.jupiter.api.Test
    void testId(){
        Hotel hotel1 = new Hotel();
        Hotel hotel2 = new Hotel();
        Hotel hotel3 = new Hotel();
        assertEquals(hotel1.id, 1);
        assertEquals(hotel2.id, 2);
        assertEquals(hotel3.id, 3);
    }
}