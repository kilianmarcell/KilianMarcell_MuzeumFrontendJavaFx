package hu.petrik.muzeumfrontendjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainController {
    @FXML
    public Tab szobrokTab;
    @FXML
    public TableView szoborTableView;
    @FXML
    public TableColumn szoborEmberCol;
    @FXML
    public TableColumn szoborMagassagCol;
    @FXML
    public TableColumn szoborErtekCol;
    @FXML
    public Tab festmenyekTab;
    @FXML
    public TableView festmenyTableView;
    @FXML
    public TableColumn festmenyCimCol;
    @FXML
    public TableColumn festmenyEvCol;
    @FXML
    public TableColumn festmenyKiallitvaCol;

    @FXML
    public void onHozaadasClick(ActionEvent actionEvent) {
    }

    @FXML
    public void onModositasClick(ActionEvent actionEvent) {
    }

    @FXML
    public void onTorlesClick(ActionEvent actionEvent) {
    }
}