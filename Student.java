class Student {
    private final String firstName;
    private final String lastName;
    private final double averageScore;

    public Student(String firstName, String lastName, double averageScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.averageScore = averageScore;
    }

    public double getAverageScore() {
        return averageScore;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ": " + averageScore;
    }
}