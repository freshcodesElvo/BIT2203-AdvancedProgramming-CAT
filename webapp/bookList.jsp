<%@ page import="java.util.List" %>
<%@ page import="library.Book" %>

<!DOCTYPE html>
<html>
<head>
    <title>Library Books</title>
</head>

<body>

<h1>Library Books</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
    </tr>

<%
    List<Book> books =
        (List<Book>) request.getAttribute("books");

    for (Book book : books) {
%>

    <tr>
        <td><%= book.getId() %></td>
        <td><%= book.getTitle() %></td>
        <td><%= book.getAuthor() %></td>
    </tr>

<%
    }
%>

</table>

</body>
</html>