public class Spieler {
    private final String name;

    public Spieler(String name) {
        this.name = name;
    }

    public void zeigeName() {
        System.out.println(this.name);
    }

    public void spielen() {
        System.out.println("Spieler spielt.");
    }

    public String getName() {
        return this.name;
    }
}
