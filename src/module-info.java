module workshop {
	requires javafx.controls;
	requires javafx.fxml;

	exports gui;
	exports model.entities;
	
	opens application to javafx.graphics, javafx.fxml;
	opens gui to javafx.fxml;
}
