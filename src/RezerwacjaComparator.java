import java.util.Comparator;

public class RezerwacjaComparator implements Comparator<Rezerwacja> {
    public int compare(Rezerwacja firstRezerwacja, Rezerwacja secondRezerwacja) {
        return firstRezerwacja.poczatek.compareTo(secondRezerwacja.poczatek);
    }
}
