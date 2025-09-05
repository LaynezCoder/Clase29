/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciasuperthis;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ejemplo en una sola clase: - Excepción personalizada ValorNoValido - Interfaz
 * JavaFX para ingresar un número - Validación y manejo de excepciones con Alert
 */


public class EjemploExcepcionFX extends Application {

    // ===== Excepción personalizada (misma idea que en consola) =====
    @SuppressWarnings("serial")
    public static class ValorNoValido extends Exception {

        public ValorNoValido() {
            super();
        }

        public ValorNoValido(String mensaje) {
            super(mensaje);
        }
    }

    // ====== UI ======
    private TextField txtNumero;
    private Label lblResultado;
    private Button btnCalcular;

    @Override
    public void start(Stage stage) {
        txtNumero = new TextField();
        txtNumero.setPromptText("Introduce un número > 0");

        btnCalcular = new Button("Calcular √");
        btnCalcular.setDefaultButton(true);

        lblResultado = new Label();  // se llena con el resultado

        // Acción del botón
        btnCalcular.setOnAction(e -> calcularRaiz());

        // Layouts
        HBox fila = new HBox(8, new Label("x:"), txtNumero, btnCalcular);
        VBox root = new VBox(12, fila, lblResultado);
        root.setPadding(new Insets(14));

        stage.setTitle("Ejemplo Excepción con JavaFX");
        stage.setScene(new Scene(root, 380, 120));
        stage.show();
    }

    private void calcularRaiz() {
        try {
            double x = leerValor();  // puede lanzar ValorNoValido
            double r = Math.sqrt(x);
            lblResultado.setText(String.format("Raíz cuadrada de %.4f = %.4f", x, r));
            mostrarInfo("Cálculo exitoso", lblResultado.getText());
        } catch (ValorNoValido e) {
            lblResultado.setText("");
            mostrarError("Valor no válido", e.getMessage());
        } catch (NumberFormatException e) {
            lblResultado.setText("");
            mostrarError("Formato inválido", "Ingresa un número válido (usa punto decimal).");
        }
    }

 
    public double leerValor() throws ValorNoValido, NumberFormatException {
        String texto = txtNumero.getText();
        double n = Double.parseDouble(texto.trim()); // puede lanzar NumberFormatException
        if (n <= 0) {
            throw new ValorNoValido("El número debe ser positivo.");
        }
        return n;
    }

    // ===== Helpers de diálogos =====
    private void mostrarError(String titulo, String mensaje) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(mensaje);
        a.showAndWait();
    }

    private void mostrarInfo(String titulo, String mensaje) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(mensaje);
        a.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
