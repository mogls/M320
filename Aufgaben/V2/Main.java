import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Spieler spieler = new Spieler("Spieler1");
        Angreifer angreifer = new Angreifer("Angreifer1");
        Verteidiger verteidiger = new Verteidiger("Verteidiger1");
        Goalie goalie = new Goalie("Goalie1", 190);

        spieler.zeigeName();
        spieler.spielen();

        angreifer.zeigeName();
        angreifer.spielen();
        angreifer.jogTraining();

        verteidiger.zeigeName();
        verteidiger.spielen();

        goalie.zeigeName();
        System.out.println(goalie.getKoerperGroese());
        goalie.spielen();

        Mannschaft mannschaft = new Mannschaft();

        mannschaft.setGoalie(goalie);
        mannschaft.addAngreifer(angreifer);
        mannschaft.addVerteidiger(verteidiger);
        System.out.println(Arrays.toString(mannschaft.getAlleSpielerToString()));

        for (int i = 1; i < 17; i++) {
            mannschaft.addAngreifer(new Angreifer("Angreifer" + (i+1)));

        }

        System.out.println(Arrays.toString(mannschaft.getAlleSpielerToString()));
    }
}
