package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Conexion.ConexionPostregsql;
import Model.Empleado;
import Model.Empresa;


public class DepartamentoDao {

	private ConexionPostregsql conexion;
	
	public DepartamentoDao() {
		this.conexion = new ConexionPostregsql();
	}
	
	public boolean registrar (Empresa empresa) {
		
		try {
			
			String SQL= "insert into departamentos(nombre)values(?)";
			
			Connection connection = this.conexion.getConnection();
			PreparedStatement sentencia = connection.prepareStatement(SQL);
			sentencia.setString(1, empresa.getNombre());
			sentencia.executeUpdate();
			sentencia.close();
			return true;

			
			
			
			
		}catch (Exception e){
			System.err.println("Ocurrio un error al registrar");
			System.err.println("Mensaje de error: "+e.getMessage());
			System.err.println("Detalle del error");
			e.printStackTrace();
			
			return false;
			
		}
		
	}
}
