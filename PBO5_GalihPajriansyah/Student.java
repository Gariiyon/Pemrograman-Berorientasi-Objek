public class Student extends Person {
    private int numCourses = 0;
    private String[] courses = {};
    private int[] grades = {};

    public Student(String name, String address) {
        super(name, address);
    }

    public void addCourseGrade(String course, int grade) {
        // Tambah ukuran array
        String[] newCourses = new String[numCourses + 1];
        int[] newGrades = new int[numCourses + 1];

        for (int i = 0; i < numCourses; i++) {
            newCourses[i] = courses[i];
            newGrades[i] = grades[i];
        }

        newCourses[numCourses] = course;
        newGrades[numCourses] = grade;

        courses = newCourses;
        grades = newGrades;
        numCourses++;
    }

    public void printGrades() {
        System.out.println("Nilai " + getName() + ":");
        for (int i = 0; i < numCourses; i++) {
            System.out.println("  " + courses[i] + ": " + grades[i]);
        }
    }

    public double getAverageGrade() {
        if (numCourses == 0) return 0.0;
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return (double) total / numCourses;
    }

    @Override
    public String toString() {
        return "Student: " + super.toString();
    }
}