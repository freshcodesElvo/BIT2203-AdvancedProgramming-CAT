package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/library_db";

    private static final String USER = "root";
    private static final String PASSWORD = "masidza";

    public List<Book> getAllBooks() {

        List<Book> books = new ArrayList<>();

        String sql = "SELECT id, title, author FROM books";

        try (
            Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet resultSet =
                    statement.executeQuery()
        ) {

            while (resultSet.next()) {

                Book book = new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author")
                );

                books.add(book);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }
}