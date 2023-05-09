import java.util.Scanner;

public class Input {

    public Input() {
        super();
    }

    public Student newStudent() {
        Scanner scan = new Scanner(System.in);
        System.out.println("input name : ");
        String testName = scan.nextLine();
        System.out.println("input surname : ");
        String testSurname = scan.nextLine();
        System.out.println("input id : ");
        int testId = scan.nextInt();
        System.out.println("input MALE/FEMALE : ");
        Genders genderResult = Genders.valueOf(scan.next().toUpperCase());
        System.out.println("input ur group : ");
        String testGroup = scan.next();

        return new Student(testName,testSurname,genderResult,testId,testGroup);


    }
}
