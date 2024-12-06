public class Goalie extends Spieler {

    double koerperGroese;

    /**
     *
     * @param name Name des Spielers
     */
    public Goalie(String name, double koerperGroese) {
        super(name);
        this.koerperGroese = koerperGroese;
    }

    /**
     *
     * @return gets the body size
     */
    public double getKoerperGroese() {
        return this.koerperGroese;
    }

    @Override
    public void spielen() {
        System.out.println("Goalie spielt.");
    }
}
