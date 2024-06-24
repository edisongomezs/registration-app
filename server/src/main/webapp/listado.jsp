<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listado de Usuarios por País</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 50%;
            margin: auto;
            background-color: white;
            padding: 20px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            margin-top: 50px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Listado de Usuarios por País</h1>
        <table>
            <thead>
                <tr>
                    <th>País</th>
                    <th>Cantidad de Usuarios</th>
                </tr>
            </thead>
            <tbody>
                <%
                    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/registrationdb", "yourusername", "yourpassword")) {
                        String query = "SELECT pais, COUNT(*) AS cantidad FROM usuarios GROUP BY pais";
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        while (rs.next()) {
                            String pais = rs.getString("pais");
                            int cantidad = rs.getInt("cantidad");
                            out.println("<tr><td>" + pais + "</td><td>" + cantidad + "</td></tr>");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
