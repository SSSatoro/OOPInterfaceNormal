import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws GroupOverflowException, IOException {
        Student st1 = new Student("Ivan", "Ivanov", Genders.MALE, 34, "group Java");
        Student st2 = new Student("Petr", "Petrov", Genders.MALE, 23, "group Java");
        Student st3 = new Student("Misha", "Mishkin", Genders.MALE, 28, "group Java");
        Student st4 = new Student("Masha", "Mashkina", Genders.MALE, 24, "group Java");
        Student st5 = new Student("Lera", "Lerkina", Genders.FEMALE, 57, "group Java");
        Student st6 = new Student("Vasya", "Vasimna", Genders.FEMALE, 12, "group Java");
        Student st7 = new Student("Galya", "Galina", Genders.FEMALE, 29, "group Java");
        Student st8 = new Student("Zhenya", "Zhenina", Genders.FEMALE, 13, "group Java");
        Student st9 = new Student("Nikita", "Nikitof", Genders.MALE, 44, "group Java");
        Student st10 = new Student("Dima", "Dimich", Genders.MALE, 89, "group Java");
        Student st11 = new Student("Kiril", "Kirilov", Genders.MALE, 98, "group c#");

        Student[] students = new Student[]{st1, st2, st3, st4, st5, st6, st7, st8, st9, st10};
        Group group = new Group();
        for (int i = 0; i < students.length; i++) {
            group.addStudent(students[i]);
        }
        System.out.println("");
        for(Student student : students){
            System.out.println(student);
        }
        System.out.println("");
        Arrays.sort(students,new ByLastNameComparator());
        System.out.println("");
        for(Student student : students){
            System.out.println(student);
        }

        group.removeStudentByID(13);
        System.out.println(group.toString());
        Input input = new Input();
        group.addStudent(input.newStudent());
        System.out.println(group.toString());

        GroupFileStorage groupStorage = new GroupFileStorage();
        groupStorage.saveGroupToCSV(group,"GROUP1.csv");










    }
}







