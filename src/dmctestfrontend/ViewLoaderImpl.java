/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmctestfrontend;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewLoaderImpl implements ViewLoader {

    public ViewLoaderImpl() {
    }

    @Override
    public void loadAddItemDialog(ObservableList list) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddItemDialogFXML.fxml"));
        AddItemDialogController controller = new AddItemDialogController(list);
        loader.setController(controller);
        loadStage(loader);

    }

    @Override
    public void loadMainView() {
        FXMLLoader loader = new FXMLLoader(DMCTestFrontEnd.class.getResource("DMCFrontEndDocument.fxml"));
        DMCFrontEndController controller = new DMCFrontEndController(this);
        loader.setController(controller);
        loadStage(loader);
    }

    private void loadStage(FXMLLoader loader) {
        try {
            Scene currentScene = new Scene((AnchorPane) loader.load());
            Stage stage = new Stage();
            stage.setScene(currentScene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ViewLoaderImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
