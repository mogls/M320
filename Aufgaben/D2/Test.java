public class Test {
    final int points;
    private int totalPoints;

    public Test(int points) {
        this.points = points;
        this.totalPoints = 100;
    }

    public float calculateGrade() {
        return (float) (((this.points * 5) /this.totalPoints) + 1);
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
