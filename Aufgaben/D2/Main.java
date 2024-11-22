import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Class class1 = new Class();
        Student student1 = new Student("Miguel");
        Test test1 = new Test(88);

        ArrayList<Integer> allScores = new ArrayList<>();

        // add beyond the limit
        for (int i = 1; i <= 21; i++) {
            class1.addStudent(new Student("Miguel " + Math.round(Math.random()*100)));
            System.out.println("Student Nr.: " + i);
        }
    }
}
