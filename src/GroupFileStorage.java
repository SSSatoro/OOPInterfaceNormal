import java.io.*;

public class GroupFileStorage {

    public static void groupToCSV(Group gr, String fileName) throws IOException {
        File file = new File(fileName);
        try (PrintWriter s1 = new PrintWriter(file)) {
            Student[] students = gr.getStudents();
            {
                for (int i = 0; i < students.length; i++) {
                    if (students[i] != null) {
                        String newStud = toStringOutput(students[i]);
                        s1.write(newStud + System.lineSeparator());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String toStringOutput(Student student) {
        return student.getName() + " / " + student.getLastName() + " / " +
                student.getId() + " / " + student.getGroupName();
    }

    public static Student outStringOutput(String str) {
        String[] array = str.split(",");
        Student student = new Student(array[0], array[1], Genders.valueOf(array[2]), Integer.valueOf(array[3]), array[4]);
        return student;
    }


    public static Group loadGroupFromCSV(File file) throws IOException {
        Group group = new Group();
        Student[] students = group.getStudents();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String result = "";
            for (int i = 0; i < students.length; i++) {
                result = br.readLine();
                if (result == null) {
                    break;
                }
                students[i] = outStringOutput(result);
            }
        } catch (Exception e1){
            e1.printStackTrace();
        }
        group.setStudents(students);
        return group;
    }

    public static File findFileByGroupName(String groupName, File workFolder) {
        File[]files = workFolder.listFiles();
        for(int i=0; i<files.length; i++){
            if(files[i].isFile()){
                if(files[i].getName().equals(groupName + ".csv")){
                    return files[i];
                }
            }
        }
        return null;

    }
}
