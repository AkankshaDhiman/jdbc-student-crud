import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public void addStudent(String name, String email, int age) throws Exception {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO students (name, email, age) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.setInt(3, age);
        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    public List<Student> getAllStudents() throws Exception {
        List<Student> students = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM students";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            student.setAge(rs.getInt("age"));
            students.add(student);
        }

        rs.close();
        stmt.close();
        conn.close();

        return students;
    }

    public void updateStudentById(int id, String name, String email, int age) throws Exception {
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE students SET name = ?, email = ?, age = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.setInt(3, age);
        stmt.setInt(4, id);
        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    public void deleteStudentById(int id) throws Exception {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM students WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

}
