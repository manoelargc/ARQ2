package com.example.cacheManager;

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


//main

public class CacheSimulator extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private Cache cache = new Cache(10);
    private TableView<CacheEntry> cacheTableView = new TableView<>();
    private List<CacheEntry> cacheData = new ArrayList<>();
    private int lastInsertedData = -1;

    List<Integer> insertedData = new ArrayList<Integer>();

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



        checkButton.setOnAction(e -> {
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
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15, 15, 15, 15));
        layout.getChildren().addAll(dataInput, checkButton, resultLabel, cacheTableView);

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
                    setStyle("-fx-background-color: #ADD8E6;"); // azul claro para o último dado inserido
                } else if (insertedData.contains(item.getData())) {
                    setStyle("-fx-background-color: #D3D3D3;"); // cinza claro para dados inseridos anteriormente
                } else {
                    setStyle("-fx-background-color: #FFFFFF;"); // branco para todos os outros casos
                }
            }
        });



        cacheTableView.setItems(FXCollections.observableArrayList(cacheData));
    }
}
