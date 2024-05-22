import java.util.ArrayList;
import java.util.List;

class Faculty {
    private final List<Student> students;

    public Faculty() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}