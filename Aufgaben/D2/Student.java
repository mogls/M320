import java.util.ArrayList;

public class Student {
    final String name;
    private ArrayList<Test> tests;

    public Student(String name) {
        this.name = name;
        this.tests = new ArrayList<>();
    }

    public float getNotenschnitt() {
        float total = 0;
        for (Test t: this.tests) {
            total += t.calculateGrade();
        }

        return total/this.tests.size();
    }

    public void addTest(Test t) {
        this.tests.add(t);
    }
}
