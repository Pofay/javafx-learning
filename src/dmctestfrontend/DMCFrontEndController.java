/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmctestfrontend;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

/**
 *
 * @author GianCarlo
 */
public class DMCFrontEndController implements Initializable {

    private ObservableList<Materials> data = FXCollections.observableArrayList();

    ViewLoader viewLoader;

    @FXML
    private TableView inventoryTable;

    @FXML
    private Button addItemButton;

    @FXML
    private Button deleteItemButton;

    public DMCFrontEndController(ViewLoader viewLoader) {
        this.viewLoader = viewLoader;
    }

    @FXML
    private void addItem(ActionEvent event) {
        viewLoader.loadAddItemDialog(data);
    }

    @FXML
    private void deleteItem(ActionEvent e) {
        ObservableList<Materials> selectedItems = inventoryTable.getSelectionModel().getSelectedItems();

        selectedItems.forEach(selectedMaterial -> data.remove(selectedMaterial));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.add(new Materials("C-purlins", "2x3x1.2"));
        data.add(new Materials("GI Sheet Corrugated ", "10mm"));
        data.add(new Materials("Common Wire Nails", "#1"));

        addItemButton.setOnAction(e -> addItem(e));
        deleteItemButton.setOnAction(e -> deleteItem(e));

        inventoryTable.setItems(data);
    }

}
