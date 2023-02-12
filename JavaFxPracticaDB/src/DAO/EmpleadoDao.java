package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Calendar;

import Conexion.ConexionPostregsql;
import Model.Empleado;

public class EmpleadoDao {
	
private ConexionPostregsql conexion;
	
	public EmpleadoDao() {
		this.conexion = new ConexionPostregsql();
	}
	
public boolean registrarempleado (Empleado empleado) {
		
		try {
			
			String SQL= "insert into empleados(nombre,appaterno,apmaterno,fecha_nacimiento,idepto)values(?,?,?,?,?)";
			
			Connection connection = this.conexion.getConnection();
			PreparedStatement sentencia = connection.prepareStatement(SQL);
			sentencia.setString(1, empleado.getNombre());
			sentencia.setString(2, empleado.getAppaterno());
			sentencia.setString(3, empleado.getApmaterno());
			sentencia.setDate(4 ,empleado.getFecha_nacimiento());
			sentencia.setInt(5, empleado.getDepartamento());
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
