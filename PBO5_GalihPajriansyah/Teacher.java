public class Teacher extends Person {
    private int numCourses = 0;
    private String[] courses = {};

    public Teacher(String name, String address) {
        super(name, address);
    }

    public boolean addCourse(String course) {
        // Return false jika mata kuliah sudah ada
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                return false;
            }
        }

        String[] newCourses = new String[numCourses + 1];
        for (int i = 0; i < numCourses; i++) {
            newCourses[i] = courses[i];
        }
        newCourses[numCourses] = course;
        courses = newCourses;
        numCourses++;
        return true;
    }

    public boolean removeCourse(String course) {
        // Return false jika mata kuliah tidak ada
        int index = -1;
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                index = i;
                break;
            }
        }

        if (index == -1) return false;

        String[] newCourses = new String[numCourses - 1];
        for (int i = 0, j = 0; i < numCourses; i++) {
            if (i != index) {
                newCourses[j++] = courses[i];
            }
        }
        courses = newCourses;
        numCourses--;
        return true;
    }

    @Override
    public String toString() {
        String result = "Teacher: " + super.toString() + "\n  Mata Kuliah Diampu: ";
        if (numCourses == 0) {
            result += "(tidak ada)";
        } else {
            for (int i = 0; i < numCourses; i++) {
                result += courses[i];
                if (i < numCourses - 1) result += ", ";
            }
        }
        return result;
    }
}