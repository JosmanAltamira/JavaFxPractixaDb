package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionPostregsql {
	
	private Connection connection;
	private String usuario="postgres";
	private String password="josman5k";
	private String servidor="localhost";
	private String puerto="5432";
	private String nombreBD="EMPRESA2";
	private String url="jdbc:postgresql://"+servidor+":"+puerto+"/"+nombreBD+"?serverTimeZone=UTC";
	private String  driver ="org.postgresql.Driver";
	
	public ConexionPostregsql() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url,usuario, password);
			if (connection != null) {
				System.out.println("conexion establecida");
			}
		} catch (Exception e) {
			System.err.println("Ocurrio un error inesperado");
			System.err.println("EL mensaje de error es: "+e.getMessage());
			System.err.println("Descripcion del error");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}

}
