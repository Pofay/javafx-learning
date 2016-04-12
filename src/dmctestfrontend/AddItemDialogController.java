/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmctestfrontend;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author GianCarlo
 */
public class AddItemDialogController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField itemNameField;

    @FXML
    private TextField measurementField;

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    ObservableList<Materials> materials;

    public AddItemDialogController(ObservableList materials) {
        this.materials = materials;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        submitButton.setOnAction(e -> addItem());

        cancelButton.setOnAction(e -> closeAction());
    }

    @FXML
    private void addItem() {
        String itemName = itemNameField.getText();
        String measurement = measurementField.getText();

        if (!itemName.isEmpty() && !measurement.isEmpty()) {
            materials.add(new Materials(itemName, measurement));
        }

        closeWindow();
    }

    @FXML
    private void closeAction() {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

}
