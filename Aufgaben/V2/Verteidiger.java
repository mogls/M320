/**
 * @author Miguel
 *
 * Verteidiger Spieler Classe
 */
public class Verteidiger extends Spieler {

    /**
     *
     * @param name Name des Spielers
     */
    public Verteidiger(String name) {
        // otherwise the player has no name
        super(name);
    }

    @Override
    public void spielen() {
        System.out.println("Verteidiger spielt");
    }
}
