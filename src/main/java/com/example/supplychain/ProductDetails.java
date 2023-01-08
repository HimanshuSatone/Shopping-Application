package com.example.supplychain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class ProductDetails {

   public TableView<Product> productTable;

   public Pane getAllProducts(){

       TableColumn id = new TableColumn("Id");
       id.setCellValueFactory(new PropertyValueFactory<>("id"));

       TableColumn name = new TableColumn("Name");
       name.setCellValueFactory(new PropertyValueFactory<>("name"));

       TableColumn price = new TableColumn("Price");
       price.setCellValueFactory(new PropertyValueFactory<>("price"));

       TableColumn availability= new TableColumn("Availability");
       availability.setCellValueFactory(new PropertyValueFactory<>("availability"));

       TableColumn stock = new TableColumn("Stock");
       stock.setCellValueFactory(new PropertyValueFactory<>("stock"));


       ObservableList<Product> products = Product.getAllProducts();

       productTable = new TableView<>();
       productTable.setItems(products);
       productTable.getColumns().addAll(id, name,price,availability,stock);
       productTable.setMinSize(SupplyChain.width, SupplyChain.height);//resize the column
       productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);//to remove extra column

       Pane tablePane = new Pane();
       tablePane.setMinSize(SupplyChain.width, SupplyChain.height);
       tablePane.getChildren().add(productTable);
       return tablePane;
   }

    public Pane getProductsByName(String productName){

        TableColumn id = new TableColumn("Id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn price = new TableColumn("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn availability= new TableColumn("Availability");
        availability.setCellValueFactory(new PropertyValueFactory<>("availability"));

        TableColumn stock = new TableColumn("Stock");
        stock.setCellValueFactory(new PropertyValueFactory<>("stock"));


        ObservableList<Product> products = Product.getProductsByName(productName);

        productTable = new TableView<>();
        productTable.setItems(products);
        productTable.getColumns().addAll(id, name,price,availability,stock);
        productTable.setMinSize(SupplyChain.width, SupplyChain.height);//resize the column
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);//to remove extra column

        Pane tablePane = new Pane();
        tablePane.setMinSize(SupplyChain.width, SupplyChain.height);
        tablePane.getChildren().add(productTable);
        return tablePane;
    }

    public Product getSelectedProduct(){

       try{
           Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
           return selectedProduct;
       }catch (Exception e){
           e.printStackTrace();
       }

       return null;
    }
}
