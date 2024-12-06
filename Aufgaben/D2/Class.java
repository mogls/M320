import java.util.ArrayList;

public class Class {
    private ArrayList<Student> students;

    public Class() {
        this.students = new ArrayList<Student>();
    }

    public float getAverage() {
        float total = 0;
        for (Student s: this.students) {
            total += s.getNotenschnitt();
        }

        return total/this.students.size();
    }

    public void addStudent(Student s) {
        if (this.students.size() <= 20) {
            this.students.add(s);
        } else {
            System.out.println("There are already 20 Students in the class. " +
                                "No more can be added");
        }
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

}
