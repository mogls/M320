public class Angreifer extends Spieler {

    /**
     *
     * @param name Name des Spielers
     */
    public Angreifer(String name) {
        super(name);
    }

    /**
     * Wann der Angreifer am trainieren ist.
     */
    public void jogTraining() {
        System.out.println("Angreifer ist am joggen.");
    }

    @Override
    public void spielen() {
        System.out.println("Angreifer spielt.");
    }
}
