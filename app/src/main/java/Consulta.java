import static android.content.ContentValues.TAG;
import static java.sql.DriverManager.getConnection;

import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta {
    try {
        Connection connection = getConnection();

        String query = "DECLARE @nasc as varchar(11)='17/04/2008'; " +
                "SELECT DATEDIFF(YEAR, CAST(@nasc AS DATE), GETDATE()) AS idade;";
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        try {
            if (resultSet.next()) {
                int idade = resultSet.getInt("idade");

                Log.d(TAG, "Idade: " + idade);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        try {
            resultSet.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        try {
            statement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


}
