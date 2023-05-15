import java.util.Arrays;
import java.util.Comparator;

public class Group {
    private String groupName;
    private final Student[] students;

    public Group() {
        super();
        students = new Student[10];
    }
    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students2) {
    }

    public void addStudent(Student student) throws GroupOverflowException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }
        throw new GroupOverflowException("Group is full");
    }

    public Student searchStudentByLasName(String lastName) throws StudentNotFoundException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getLastName() == lastName) {
                    return students[i];
                }
            }
        }
        throw new StudentNotFoundException("Student not found");
    }

    public boolean removeStudentByID(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getId() == id) {
                    students[i] = null;
                    System.out.println("successufully removed student with id#" + id);
                    return true;
                }
            }
        }
        System.out.println("there is no such id");
        return false;
    }

    public void sortStudentsByLastName() {
        Arrays.sort(students, Comparator.nullsFirst(new ByLastNameComparator()));
    }


    @Override
    public String toString() {
        int positions = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                positions++;
            }
        }
        System.out.println(positions + " out of " + students.length + " positions are placed");
        return "Group [groupName=" + groupName + ", students=" + Arrays.toString(students) + "]";

    }



}
