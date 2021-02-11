package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Connector {

	String url = "jdbc:mysql://localhost:3306/browar_sarenka_recipes";
	String username = "root";
	String password;
	Statement statement;
	Connection con;
	
	@SuppressWarnings("deprecation")
	public static String getPassword() {
	    JPasswordField jpf = new JPasswordField(24);
	    JLabel jl = new JLabel("Podaj has³o: ");
	    Box box = Box.createHorizontalBox();
	    box.add(jl);
	    box.add(jpf);
	    int x = JOptionPane.showConfirmDialog(null, box, "Name Entry", JOptionPane.OK_CANCEL_OPTION);

	    if (x == JOptionPane.OK_OPTION) {
	      return jpf.getText();
	    }
	    return null;
	  }
	
	public Connector() {
		// TODO Auto-generated constructor stub
		 password = getPassword();// JOptionPane.showInputDialog(null, "", "Input Dialog", JOptionPane.QUESTION_MESSAGE);
	}
	
	public void disconnect() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void connect() {
		con = null;

	    if (password != null) {
			
			try {
				//Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, username, password);
				statement = con.createStatement();
				//return statement;
			} catch (SQLException ex) {
				throw new Error("Error ", ex);
			}
		}
	}

	public List<String[]> executeSelectAll(String xxx, String tableName, Integer columns) throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT" + xxx + "FROM browar_sarenka_recipes." + tableName +";";
		List<String[]> s = new ArrayList<>();
		connect();
		ResultSet x = statement.executeQuery(query);
		while (x.next()) {
			String[] d = new String[columns];
			for (int i = 0; i < d.length; i++) {
				d[i] = x.getString(i + 1);
			}
			s.add(d);
		}
		disconnect();
		return s;
	}

	public Integer executeAddNew(String tableName, String id_column, String[] atribute, String[] params) throws SQLException {
		// TODO Auto-generated method stub
		String query = "INSERT INTO browar_sarenka_recipes." + tableName + "(";
		for (int i = 0; i < atribute.length; i++) {
			query += atribute[i];
			if (i < atribute.length - 1) {
				query += ", ";
			}
		}
		query +=") VALUES (";//'d', '1', 'D');";
		for (int i = 0; i < params.length; i++) {
				query += "'" + params[i] + "'";
				if (i < params.length - 1) {
					query += ", ";
				}	
		}
		query += ");";
		
		connect();
		statement.executeUpdate(query);
		
		ResultSet x = statement.executeQuery("SELECT "+ id_column +" FROM  browar_sarenka_recipes."+ tableName +" ORDER BY "+ id_column +" DESC LIMIT 1;");
		x.next();
		Integer a = Integer.parseInt(x.getString(1));
		disconnect();
		
		return a;
	}

	public void executeUpdate(String tableName, long id, String id_column, String[] atribute, String[] param) throws SQLException {
		// TODO Auto-generated method stub
		String query = "UPDATE browar_sarenka_recipes."+ tableName +" SET ";
		for (int i = 0; i < param.length; i++) {
			query += atribute[i] + " = '" + param[i] +"'";
			if (i < param.length - 1) {
				query += ", ";
			}	
		}
		query += " WHERE (" + id_column + " = '" + id + "');";
		connect();
		statement.executeUpdate(query);
		disconnect();
	}

	public void executeDelete(String tableName, String id_column, long id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "DELETE FROM browar_sarenka_recipes." + tableName + " WHERE (" + id_column + " = '" + id +"');";
		connect();
		statement.executeUpdate(query);
		disconnect();
	}
	
}
