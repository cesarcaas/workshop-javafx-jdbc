package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {
	
	private DepartmentService service;
	
	@FXML
	private TableView<Department> tableViewDepartment;
	
	@FXML
	private TableColumn<Department, Integer> tableCollumnId;
	
	@FXML
	private TableColumn<Department, String> tableCollumnName;
	
	@FXML
	private Button btNew;
	
	private ObservableList<Department> obslist;
	
	//private ObservableList<> activeSession = FXCollections.observableArrayList();

	@FXML
	public void onBtNewAction(){
		System.out.println("onBtNewAction()");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		intializeNode();
	}
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}

	private void intializeNode() {
		
		tableCollumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableCollumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		//Para centralizar e esticar a tableview
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
		
		/*
		tableCollumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableCollumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		//Para centralizar e esticar a tableview
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
		*/		
	}
	
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Department> list = service.findAll();
		obslist = FXCollections.observableArrayList(list);
		tableViewDepartment.setItems(obslist);
	}

}