public class Mitarbeiter {

    private String vorname;
    private String nachname;
    private int mitarbeiternummer;
    private double gehalt;
    private int alter;
    private static int s_nummer = 0;

    public Mitarbeiter (String vorname, String nachname, double gehalt, int alter) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.gehalt = gehalt;
        this.alter = alter;
        if (alter < 0) {
            throw new IllegalArgumentException("Bitte geben Sie ein plausibles Alter ein");
        }
        mitarbeiternummer = ++s_nummer;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public int getMitarbeiternummer() {
        return mitarbeiternummer;
    }

    public double getGehalt() {
        return gehalt;
    }

    public int getAlter() {
        return alter;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setGehalt(double gehalt) {
        this.gehalt = gehalt;
    }

    private double round (double value) {
       return Math.round(value * 100) / 100D;
    }

    public double jahresAbrechnung() {
       return monatsAbrechnung() * 12;
    }

    public double jahresAbrechnung(int monate) {
        return monatsAbrechnung() * monate;
    }

    public double monatsAbrechnung() {
        double jahresgehalt = gehalt * 12;
        double gehaltNetto = jahresgehalt * 0.8;
        double steuer = 0;

        if (gehaltNetto < 10000) {
           steuer = gehaltNetto * 0.1;
        }
        else if (gehaltNetto < 20000) {
            steuer = (10000*0.1) + ((gehaltNetto -10000) * 0.2);
        }
        else if (gehaltNetto < 30000) {
            steuer = (10000*0.1) + (10000 * 0.2) + ((gehaltNetto - 20000) * 0.32);
        }
        else if (gehaltNetto < 50000) {
            steuer = (10000 * 0.1) + (10000 * 0.2) + (10000 * 0.32) + ((gehaltNetto - 30000) * 0.45);
        }
        else {
            steuer = (10000 * 0.1) + (10000 * 0.2) + (10000 * 0.32) + (20000 * 0.45) + ((gehaltNetto - 50000) * 0.6);
            }
        double Nettogehalt = ((gehaltNetto - steuer) / 12);
        return round(Nettogehalt);
    }

}
