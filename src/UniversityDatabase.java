import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UniversityDatabase {

    // db connection 
    private static final String URL="jdbc:mysql://localhost:3306/university_db";
    private static final String USER = "admin";
    private static final String PASSWORD = "secure123";

    public static void main(String[] args) {

        // sql statement for creating courses table
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS courses (course_id INT PRIMARY KEY, course_name VARCHAR(100),credits INT, department VARCHAR(50))
                """;

        // sql statement for inserting courses
        String insertSQL = """
                INSERT INTO courses (course_id, course_name, credits, department)
                VALUES (?, ?, ?, ?)
                """;

        // sql  for retrieving computer science courses
        String selectSQL = """
                SELECT course_id, course_name, credits, department
                FROM courses
                WHERE department = ?
                """;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("Connected to university_db");

            // create  courses table
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableSQL);
                System.out.println("courses table created");
            }

            // posting 3 sample courses
            try (PreparedStatement preparedStatement =connection.prepareStatement(insertSQL)) {

                insertCourse(preparedStatement, 104, "Introduction to Programming", 3, "Computer Science");
                insertCourse(preparedStatement, 105, "Database Systems", 3, "Computer Science");
                insertCourse(preparedStatement, 106, "Advanced Programming", 3, "Computer Science");
            }

            // get and display comp science courses
            try (PreparedStatement preparedStatement =connection.prepareStatement(selectSQL)) {
                preparedStatement.setString(1, "Computer Science");
                try (ResultSet resultSet = preparedStatement.executeQuery()) {

                    System.out.println("\nComputer science courses:");
                    System.out.println("==============================");
                   

                    while (resultSet.next()) {
                        System.out.println(
                                "Course ID: " + resultSet.getInt("course_id")
                                + ", Course Name: " + resultSet.getString("course_name")
                                + ", Credits: " + resultSet.getInt("credits")
                                + ", Department: " + resultSet.getString("department")
                        );
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    //  function for inserting a course
    private static void insertCourse(
            PreparedStatement preparedStatement,
            int courseId,
            String courseName,
            int credits,
            String department) throws SQLException {

        preparedStatement.setInt(1, courseId);
        preparedStatement.setString(2, courseName);
        preparedStatement.setInt(3, credits);
        preparedStatement.setString(4, department);

        preparedStatement.executeUpdate();

        System.out.println("Inserted: " + courseName);
    }
}