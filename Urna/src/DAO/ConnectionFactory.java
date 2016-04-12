package DAO;
/**
 * author by: Matheus de Souza Coutinho;
*Coom ajuda de Gustavo Ribeiro e Leonardo Silva <3;
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection connection = null;
	private static boolean open = false;

	private ConnectionFactory() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/urnaeletronica", "root", "");
	}

	public static boolean openConnection() throws ClassNotFoundException, SQLException {
		if (!open) {
			new ConnectionFactory();
			setOpen(true);
			return true;
		}
		return false;
	}

	public static Connection getConnection() {
		if (open)
			return connection;
		return null;
	}

	public static boolean closeConnection() {
		try {
			connection.close();
			setOpen(false);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static boolean isOpen() {
		return open;
	}

	private static void setOpen(boolean aberto) {
		open = aberto;
	}
}