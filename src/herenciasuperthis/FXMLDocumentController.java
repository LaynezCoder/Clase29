package herenciasuperthis;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class FXMLDocumentController implements Initializable {

    @FXML
    private CheckBox checkPiojos;
    @FXML
    private ComboBox<String> comboBoxAnimal;
    @FXML
    private VBox piojosContainer;
    @FXML
    private TextField txtOjos;
    @FXML
    private TextField txtPatas;
    @FXML
    private TextField txtSonido;   // el usuario escribe aquí

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        piojosContainer.managedProperty().bind(piojosContainer.visibleProperty());
        piojosContainer.setVisible(false);

        txtSonido.clear();
        txtSonido.setPromptText("Escribe el texto para sobrescribir...");

        setAnimalsInComboBox();
    }

    private void setAnimalsInComboBox() {
        comboBoxAnimal.setItems(FXCollections.observableArrayList(
                "Perro", "Gato", "Loro", "Loro mutante"
        ));
        comboBoxAnimal.getSelectionModel().selectFirst();

        comboBoxAnimal.valueProperty().addListener((obs, oldVal, newVal) -> {
            boolean esPerro = "Perro".equals(newVal);
            piojosContainer.setVisible(esPerro);
            if (!esPerro) {
                checkPiojos.setSelected(false);
            }
        });

        piojosContainer.setVisible("Perro".equals(comboBoxAnimal.getValue()));
    }

    @FXML
    private void onCrearAnimal() {
        Integer patas = parseEntero(txtPatas.getText());
        Integer ojos = parseEntero(txtOjos.getText());

        if (patas == null || ojos == null) {
            showDialog("Error", "Debes ingresar números válidos para patas y ojos.");
            return;
        }

        String seleccion = comboBoxAnimal.getValue();
        boolean pulgas = checkPiojos.isSelected();

        // Creamos el animal seleccionado (para el flujo)
        switch (seleccion) {
            case "Perro":
                new Perro(patas, ojos, pulgas);
                break;
            case "Gato":
                new Gato(patas, ojos);
                break;
            case "Loro":
                new Loro(patas, ojos);
                break;
            case "Loro mutante":
                new LoroMutante(patas, ojos);
                break;
            default:
                showDialog("Error", "Selecciona un animal.");
                return;
        }

        // Texto escrito por el usuario
        String custom = txtSonido.getText() == null ? "" : txtSonido.getText().trim();
        if (custom.isEmpty()) {
            showDialog("Advertencia", "Debes escribir un texto para sobrescribir.");
            return;
        }

        // Mostrar el texto sobrescrito en un diálogo
        showDialog("Resultado", "Sobrescrito con: " + custom);
    }

    private Integer parseEntero(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return null;
        }
    }

    private void showDialog(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
