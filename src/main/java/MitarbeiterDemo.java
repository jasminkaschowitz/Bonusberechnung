public class MitarbeiterDemo {

    public static void main(String[] args) {
        Mitarbeiter person1 = new Mitarbeiter("Max", "Mustermann", 3000, 30);

        System.out.println("person1.jahresAbrechnung() = " + person1.jahresAbrechnung());
        System.out.println("person1.monatsAbrechnung() = " + person1.monatsAbrechnung());
        System.out.println("person1.jahresAbrechnung(6) = " + person1.jahresAbrechnung(6));

    }
}
