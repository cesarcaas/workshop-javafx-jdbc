module workshop_javafx_jdc {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
