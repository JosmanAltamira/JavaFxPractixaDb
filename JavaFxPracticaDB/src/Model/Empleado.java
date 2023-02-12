package Model;

import java.sql.Date;

import DAO.DepartamentoDao;

public class Empleado {
	private int id;
	private String nombre;
	private String appaterno;
	private String apmaterno;
	private Date fecha_nacimiento;
	private int departamento;

	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getAppaterno() {
		return appaterno;
	}



	public void setAppaterno(String appaterno) {
		this.appaterno = appaterno;
	}



	public String getApmaterno() {
		return apmaterno;
	}



	public void setApmaterno(String apmaterno) {
		this.apmaterno = apmaterno;
	}



	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}



	public void setFecha_nacimiento(Date fecha_nacimiento) {

		this.fecha_nacimiento = fecha_nacimiento;
	}






	public int getDepartamento() {
		return departamento;
	}



	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}



	@Override
	public String toString() {
		return "Empleado{" + "id: " + id +", Nombre:" + nombre +"Apellido Paterno: "+ appaterno +" Apellido Materno: " + apmaterno +" Fecha de nacimiento:"+ fecha_nacimiento + " Departamento:"+ departamento +"}";
	}
}
