package application;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.stage.StageStyle;

import java.sql.Date;
import java.time.LocalDate;

import DAO.DepartamentoDao;
import DAO.EmpleadoDao;
import Model.Empleado;
import Model.Empresa;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;

public class Page2Controller {
	@FXML
	private TextField txtNombreEmp;
	@FXML
    private TextField txtNombre;
	@FXML
	private TextField txtApellidoPaterno;
	@FXML
	private TextField txtApellidoMaterno;
	@FXML
	private DatePicker txtFechaNacimiento;
	@FXML
	private TextField txtDepartamento;
	@FXML
	private EmpleadoDao	empleadoDao;
	@FXML
    void initialize() {
        this.empleadoDao=new EmpleadoDao();
    }

	// Event Listener on Button.onAction
	@FXML
	public void btnGuardarEmpleadoOnAction(ActionEvent event) {
		String nombre = txtNombreEmp.getText();
		String apPaterno = txtApellidoPaterno.getText();
		String apMaterno = txtApellidoMaterno.getText();
		LocalDate fechaNacimiento = txtFechaNacimiento.getValue();
		String departamento = txtDepartamento.getText();

		if (nombre.isEmpty() || apPaterno.isEmpty() || apMaterno.isEmpty() || fechaNacimiento == null || departamento.isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error en los datos");
			alert.setHeaderText(null);
			alert.setContentText("Por favor, completa todos los campos");
			alert.initStyle(StageStyle.UTILITY);
			alert.showAndWait();
			return;
		}
		
		String pattern = "[a-zA-Z]+";
		if (!nombre.matches(pattern) || !apPaterno.matches(pattern) || !apMaterno.matches(pattern)) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error en los datos");
			alert.setHeaderText(null);
			alert.setContentText("Nombre y apellidos no pueden contener caracteres especiales");
			alert.initStyle(StageStyle.UTILITY);
			alert.showAndWait();
			return;
		}
		
		LocalDate fechaLimite = LocalDate.of(2022, 1, 1);

		if (fechaNacimiento.isAfter(fechaLimite)) {
		    Alert alert = new Alert(Alert.AlertType.ERROR);
		    alert.setTitle("Fecha de nacimiento inválida");
		    alert.setHeaderText(null);
		    alert.setContentText("La fecha de nacimiento no puede ser después del 1 de Enero de 2022");
		    alert.initStyle(StageStyle.UTILITY);
		    alert.showAndWait();
		    return;
		}
		
		Empleado empleado = new Empleado();
		empleado.setNombre(nombre);
		empleado.setAppaterno(apPaterno);
		empleado.setApmaterno(apMaterno);
		empleado.setFecha_nacimiento(Date.valueOf(fechaNacimiento));
		empleado.setDepartamento(Integer.parseInt(departamento));

		boolean rsp = this.empleadoDao.registrarempleado(empleado);
		
		if(rsp) {
			Alert alert = new Alert (Alert.AlertType.INFORMATION);
			alert.setTitle("Operacion correcta");
			alert.setHeaderText(null);
			alert.setContentText("Empleado registrado correctamente :)");
			alert.initStyle(StageStyle.UTILITY);
			alert.showAndWait();
			
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Operacion incorrecta");
			 alert.setHeaderText(null);
			 alert.setContentText("Revise la informacion");
			 alert.initStyle(StageStyle.UTILITY);
			 alert.showAndWait();
		}
	
	}
}
