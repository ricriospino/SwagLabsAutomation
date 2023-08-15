package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConetion {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/Qadbt?useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "mysql";
    
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    
    public static ResultSet obtenerUsuarioById(int id) throws SQLException {	
        try {
        	Connection con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM Employeeinfo WHERE id = ?");
            preparedStatement.setInt(1, id);
            
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static ResultSet getCredentials() throws SQLException {	
        try {
        	Connection con = getConnection();
            Statement statement = con.createStatement();
        	return statement.executeQuery("SELECT * FROM credentials WHERE scenario = 'rewardscard'");
     	
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } 	
    }
}
