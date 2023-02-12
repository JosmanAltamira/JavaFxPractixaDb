package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import DAO.DepartamentoDao;
import DAO.EmpleadoDao;
import Model.Empleado;
import Model.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.StageStyle;

public class Page1Controller {
	@FXML
	private TextField txtNombre;
	@FXML
    private DepartamentoDao departamentoDao;
	@FXML
    private EmpleadoDao	empleadoDao;
	@FXML
	private Button btbEnviarDepartamento;
	@FXML
    void initialize() {
        this.departamentoDao=new DepartamentoDao();
    }

	// Event Listener on Button[#btbEnviarDepartamento].onAction
	@FXML
	public void btnGuardarDepartamentoOnAction(ActionEvent event) {
		String nombre = txtNombre.getText().trim();
		
		if (nombre.isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText(null);
			alert.setContentText("El campo no puede estar vacio");
			alert.initStyle(StageStyle.UTILITY);
			alert.showAndWait();
			return;
		}
		
		if (!nombre.matches("[a-zA-Z0-9 ]+.*/´-,")) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText(null);
			alert.setContentText("No se aceptan caracteres especiales");
			alert.initStyle(StageStyle.UTILITY);
			alert.showAndWait();
			return;
		}
		
		Empresa empresa = new Empresa();
		empresa.setNombre(nombre);
		
		System.out.println(empresa.toString());
		
		boolean rsp = this.departamentoDao.registrar(empresa);
		
		if (rsp) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("EXITO");
			alert.setHeaderText(null);
			alert.setContentText("Registrado correctamente :)");
			alert.initStyle(StageStyle.UTILITY);
			alert.showAndWait();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("FALLO");
			alert.setHeaderText(null);
			alert.setContentText("Revise la información");
			alert.initStyle(StageStyle.UTILITY);
			alert.showAndWait();
		}
	}
}
