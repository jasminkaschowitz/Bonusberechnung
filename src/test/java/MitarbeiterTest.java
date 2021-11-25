import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MitarbeiterTest {
    Mitarbeiter test1;

    @BeforeEach
    void setUp() {
        test1 = new Mitarbeiter("Max", "Mustermann", 3000, 26);
    }

    @Test
    void jahresAbrechnung() {
        assertEquals(22983.96, test1.jahresAbrechnung());

    }

    @Test
    void testJahresAbrechnung() {
        assertEquals(11491.98, test1.jahresAbrechnung(6));
    }

    @Test
    void monatsAbrechnung() {
        assertEquals(1915.33, test1.monatsAbrechnung());
    }

    @Test
    void checkKonstruktor() {
        assertAll("Testet den Konstruktor",
                () -> assertEquals("Max", test1.getVorname()),
                () -> assertEquals("Mustermann", test1.getNachname()),
                () -> assertEquals(3000, test1.getGehalt()),
                () -> assertEquals(26, test1.getAlter()));
    }
    @Test
    void exceptionKontrolle() {
        assertThrows(IllegalArgumentException.class, () -> new Mitarbeiter("Mike", "Mustermann", 2000, -1));
    }
}