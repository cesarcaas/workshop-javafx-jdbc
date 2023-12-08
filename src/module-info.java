module workshop {
	requires javafx.controls;
	requires javafx.fxml;

	exports gui;
	exports model.entities;
	exports model.services;
	
	opens application to javafx.graphics, javafx.fxml;
	opens gui to javafx.fxml;
}
