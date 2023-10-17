package com.example.cacheManager;

//main
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class CacheSimulator extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private Cache cache; // Cache atualmente usado
    private TableView<CacheEntry> cacheTableView = new TableView<>();
    private List<CacheEntry> cacheData = new ArrayList<>();
    private int lastInsertedData = -1;
    private List<Integer> insertedData = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        // Configurar a tabela
        TableColumn<CacheEntry, Integer> indexColumn = new TableColumn<>("Índice");
        indexColumn.setCellValueFactory(new PropertyValueFactory<>("index"));

        TableColumn<CacheEntry, Integer> dataColumn = new TableColumn<>("Dado");
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));

        cacheTableView.getColumns().addAll(indexColumn, dataColumn);

        // Configurar os controles
        TextField dataInput = new TextField();
        dataInput.setStyle("-fx-background-color: #ADD8E6;");

        Button checkButton = new Button("Check Cache");
        checkButton.setStyle("-fx-background-color: #0099cc; -fx-text-fill: #FFFFFF;");

        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #0099cc;");

        cacheTableView.setStyle("-fx-background-color: #F0F8FF;");

        ComboBox<String> cacheTypeComboBox = new ComboBox<>(FXCollections.observableArrayList("Mapeamento Direto", "Totalmente Associativa", "Associativa por Conjuntos"));

        checkButton.setOnAction(e -> {
            String selectedCacheType = cacheTypeComboBox.getValue();
            if (selectedCacheType != null) {
                if (cache == null) {
                    if (selectedCacheType.equals("Mapeamento Direto")) {
                        cache = new DirectMappedCache(10);
                    } else if (selectedCacheType.equals("Totalmente Associativa")) {
                        cache = new FullyAssociativeCache(10);
                    } else if (selectedCacheType.equals("Associativa por Conjuntos")) {
                        cache = new SetAssociativeCache(4, 10); // 4 conjuntos
                    }
                }

                int data = Integer.parseInt(dataInput.getText());
                lastInsertedData = data;

                boolean hit = cache.checkCache(data);
                if (hit) {
                    resultLabel.setText("Data: " + data + " Hit ");
                } else {
                    resultLabel.setText("Data: " + data + " Miss");
                }

                //design
                data = Integer.parseInt(dataInput.getText());
                insertedData.add(data);
                lastInsertedData = data;

                // Atualize os dados da tabela
                updateCacheTable();
                cache.printCache();
            } else {
                // Código para lidar com a situação em que nenhum tipo de cache foi selecionado
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15, 15, 15, 15));
        layout.getChildren().addAll(dataInput, cacheTypeComboBox, checkButton, resultLabel, cacheTableView);

        Scene scene = new Scene(layout, 400, 300);

        primaryStage.setTitle("Cache Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateCacheTable() {
        cacheData.clear();
        for (int i = 0; i < cache.getCacheSize(); i++) {
            int data = cache.getCacheData(i);
            cacheData.add(new CacheEntry(i, data));
        }

        cacheTableView.setRowFactory(tv -> new TableRow<CacheEntry>() {
            @Override
            public void updateItem(CacheEntry item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null) {
                    setStyle("");
                } else if (item.getData() == lastInsertedData) {
                    setStyle("-fx-background-color: #ADD8E6;");
                } else if (insertedData.contains(item.getData())) {
                    setStyle("-fx-background-color: #D3D3D3;");
                } else {
                    setStyle("-fx-background-color: #FFFFFF;");
                }
            }
        });

        cacheTableView.setItems(FXCollections.observableArrayList(cacheData));
    }
}
