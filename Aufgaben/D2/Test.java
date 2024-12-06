public class Test {
    final long points;
    private long totalPoints;

    public Test(long points) {
        this.points = points;
        this.totalPoints = 100;
    }

    public float calculateGrade() {
        return (float) (((this.points * 5) /this.totalPoints) + 1);
    }

    public void setTotalPoints(long totalPoints) {
        this.totalPoints = totalPoints;
    }
}
