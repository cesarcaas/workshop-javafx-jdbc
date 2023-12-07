package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable {
	
	@FXML
	private TableView<Department> tableViewDepartment;
	
	@FXML
	private TableColumn<Department, Integer> tableCollumnId;
	
	@FXML
	private TableColumn<Department, String> tableCollumnName;
	
	@FXML
	private Button btNew;
	
	@FXML
	public void onBtNewAction(){
		System.out.println("onBtNewAction()");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		intializeNode();
	}

	private void intializeNode() {
		tableCollumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableCollumnId.setCellValueFactory(new PropertyValueFactory<>("name"));
		//Para centralizar e esticar a tableview
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
				
	}
	
	

}
