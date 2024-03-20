import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class test extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label inputLabel = new Label("Input:");
        grid.add(inputLabel, 0, 0);

        TextField inputField = new TextField();
        grid.add(inputField, 1, 0);

        Label outputLabel = new Label("Output:");
        grid.add(outputLabel, 0, 1);

        TextField outputField = new TextField();
        outputField.setEditable(false);
        grid.add(outputField, 1, 1);

        ComboBox<String> converterOptions = new ComboBox<>();
        converterOptions.getItems().addAll(
                "Kilograms to Pounds",
                "Centimeters to Inches",
                "Kilometers to Miles",
                "Grams to Ounces"
        );
        converterOptions.setValue("Kilograms to Pounds");
        grid.add(converterOptions, 0, 2, 2, 1);

        Button convertButton = new Button("Convert");
        grid.add(convertButton, 0, 3, 2, 1);

        convertButton.setOnAction(e -> {
            String option = converterOptions.getValue();
            double inputValue = Double.parseDouble(inputField.getText());
            double result = 0;

            switch (option) {
                case "Kilograms to Pounds":
                    result = inputValue * 2.20462;
                    break;
                case "Centimeters to Inches":
                    result = inputValue / 2.54;
                    break;
                case "Kilometers to Miles":
                    result = inputValue / 1.60934;
                    break;
                case "Grams to Ounces":
                    result = inputValue / 28.3495;
                    break;
            }

            outputField.setText(String.format("%.2f", result));
        });

        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}