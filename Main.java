import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Enrollee> enrollees = Arrays.asList(
                new Enrollee("Іванов", 95),
                new Enrollee("Петров", 85),
                new Enrollee("Сідоров", 75),
                new Enrollee("Колян", 55),
                new Enrollee("Мовчан", 100)
        );

        int budgetPlaces = 2;

        List<Enrollee> budgetEnrollees = enrollees.stream()
                .filter(e -> e.getScore() >= 60)
                .sorted(Comparator.comparing(Enrollee::getScore).reversed())
                .limit(budgetPlaces)
                .sorted(Comparator.comparing(Enrollee::getLastName))
                .toList();

        System.out.println("Абітурієнти, які поступили на бюджет:");
        budgetEnrollees.forEach(System.out::println);

        List<Enrollee> notAcceptedEnrollees = enrollees.stream()
                .filter(e -> e.getScore() < 60)
                .toList();

        System.out.println("\nАбітурієнти, які не можуть бути зараховані:");
        notAcceptedEnrollees.forEach(System.out::println);

        List<Student> allStudents = getStudents();
        double averageInstituteScore = allStudents.stream()
                .mapToDouble(Student::getAverageScore)
                .average()
                .orElse(0.0);

        List<Student> aboveAverageStudents = allStudents.stream()
                .filter(s -> s.getAverageScore() > averageInstituteScore)
                .toList();

        System.out.println("\nСтуденти з середнім балом вищим за середній бал:");
        aboveAverageStudents.forEach(System.out::println);
    }

    private static List<Student> getStudents() {
        Student student1 = new Student("Іван", "Іванов", 4.5);
        Student student2 = new Student("Петро", "Петров", 3.8);
        Student student3 = new Student("Сідр", "Сідоров", 4.2);
        Student student4 = new Student("Джон", "Джоновіч", 3.0);

        Faculty faculty1 = new Faculty();
        faculty1.addStudent(student1);
        faculty1.addStudent(student2);

        Faculty faculty2 = new Faculty();
        faculty2.addStudent(student3);
        faculty2.addStudent(student4);

        Institute institute = new Institute();
        institute.addFaculty(faculty1);
        institute.addFaculty(faculty2);

        return institute.getAllStudents();
    }
}