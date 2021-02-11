package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

class Test {
	
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
	
	public static void main(String[] args) throws ClassNotFoundException {
	    Connection con = null;
	
	    String url = "jdbc:mysql://localhost:3306/browar_sarenka_recipes";
	    String username = "root";
	    String password = getPassword();// JOptionPane.showInputDialog(null, "", "Input Dialog", JOptionPane.QUESTION_MESSAGE);
	
	    if (password != null) {
			
			try {
				//Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, username, password);
				Statement statement = con.createStatement();
				String query = "SELECT * FROM browar_sarenka_recipes.hops;";
				//resultSet = statement.executeUpdate(query);
				System.out.println("Connected!");
				ResultSet x = statement.executeQuery(query);
				while (x.next()) {
					System.out.print(x.getString(1) + " ");
					System.out.print(x.getString(2) + " ");
					System.out.print(x.getString(3) + " ");
					System.out.println(x.getString(4));
				}
				System.out.println(x);
			} catch (SQLException ex) {
				throw new Error("Error ", ex);
			} finally {
				try {
					if (con != null) {
						con.close();
					}
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
	    }
	}
}