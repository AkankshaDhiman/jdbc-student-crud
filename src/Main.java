import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            StudentDAO dao = new StudentDAO();

            // Create
            dao.addStudent("Charlie", "charlie@example.com", 25);

            // Read
            List<Student> students = dao.getAllStudents();
            for (Student s : students) {
                System.out.println(s.getId() + ": " + s.getName() + ", " + s.getEmail() + ", " + s.getAge());
            }

            // Update
            dao.updateStudentById(1, "Updated Name", "updatedemail@example.com", 30);

            // Delete
            dao.deleteStudentById(2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
