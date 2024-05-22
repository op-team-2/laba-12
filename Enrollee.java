class Enrollee {
    private final String lastName;
    private final int score;

    public Enrollee(String lastName, int score) {
        this.lastName = lastName;
        this.score = score;
    }

    public String getLastName() {
        return lastName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return lastName + ": " + score;
    }
}