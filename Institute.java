import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Institute {
    private final List<Faculty> faculties;

    public Institute() {
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public List<Student> getAllStudents() {
        return faculties.stream()
                .flatMap(faculty -> faculty.getStudents().stream())
                .collect(Collectors.toList());
    }
}