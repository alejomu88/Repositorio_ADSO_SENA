package stockmaster1;

import java.sql.*;

public class prueba {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/stockmaster";
        String user = "root";
        String password = "8320";
        try {
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement stmt = conn.createStatement();


            String insertQuery = "INSERT INTO administrador (nombre, email) VALUES('berna8320','berna@gmail.com')";
            int rowInsert = stmt.executeUpdate(insertQuery);
            if (rowInsert > 0)
            {
                System.out.println("Insercion exitosa");
            }
            ResultSet resultado = stmt.executeQuery("SELECT * FROM administrador");
            while (resultado.next())
            {
                System.out.println(resultado.getString("nombre"));
                System.out.println(resultado.getString("email"));
            }
            resultado.close();


            String updateQuery = "UPDATE administrador SET nombre = 'berna7012' WHERE id_administrador = 3";
            int rowUpdate = stmt.executeUpdate(updateQuery);
            if (rowUpdate > 0)
            {
                System.out.println("Actualizacion exitosa");
            }


            String deleteQuery = "DELETE FROM administrador WHERE id_administrador > 4";
            int rowdelete = stmt.executeUpdate(deleteQuery);
            if (rowdelete > 0)
            {
                System.out.println("Eliminacion exitosa");
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
