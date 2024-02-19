package controllers;

import Entites.Concours;
import Entites.Personne;
import Service.ServiceConcours;
import Service.ServicePersonne;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

public class AfficherConcoursControllers {

    @FXML
    private Label lbname;

    @FXML
    private TableColumn<Concours, Integer> colprix;

    @FXML
    private TableColumn<Concours, String> coldate;

    @FXML
    private TableColumn<Concours, String> coltype;
    @FXML
    private TableColumn<Concours, String> collien;



    @FXML
    private TableView<Concours> tablevew;

    private final ServiceConcours ser=new ServiceConcours();
    public Label getLbname() {
        return lbname;
    }

    public void setLbname(String lbname) {
        this.lbname.setText(lbname);
    }
    @FXML
    void  initialize()
    {

        try {
            List<Concours> list=ser.readAll();
            ObservableList<Concours> obers= FXCollections.observableList(list);
            tablevew.setItems(obers);
            colprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
            coltype.setCellValueFactory(new PropertyValueFactory<>("type"));
            collien.setCellValueFactory(new PropertyValueFactory<>("lien"));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
