import java.util.ArrayList;

/**
 * @author Miguel Seara
 */
public class Mannschaft {
    Goalie goalie;
    ArrayList<Angreifer> angreifer;
    ArrayList<Verteidiger> verteidiger;

    private ArrayList<Spieler> alleSpieler;

    public Mannschaft() {
        this.angreifer = new ArrayList<>();
        this.verteidiger = new ArrayList<>();
        this.alleSpieler = new ArrayList<>();
    }

    public void addAngreifer(Angreifer a) {
        if (this.angreifer.size() <= 16) {
            this.angreifer.add(a);
            this.alleSpieler.add(a);
        }
    }

    public void addVerteidiger(Verteidiger v ) {
        if (this.verteidiger.size() <= 4) {
            this.verteidiger.add(v);
            this.alleSpieler.add(v);
        }
    }

    /**
     * This method checks the alleSpieler list and removes a goalie if it finds one
     * @param g Goalie to set
     */
    public void setGoalie(Goalie g) {
        if (this.goalie != null) {
            this.alleSpieler.removeIf(spieler -> spieler instanceof Goalie);
        }
        this.goalie = g;
        this.alleSpieler.add(g);
    }

    public ArrayList<Spieler> getAlleSpieler() {
        return this.alleSpieler;
    }

    public String[] getAlleSpielerToString() {
        String[] returnList = new String[this.alleSpieler.size()-1];

        for (int i = 0; i < this.alleSpieler.size()-1; i++) {
            returnList[i] = this.alleSpieler.get(i).getName();
        }

        return returnList;
    }
}
