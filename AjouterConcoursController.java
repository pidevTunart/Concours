package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import Entites.Concours;
import Service.ServiceConcours;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.SQLException;

public class AjouterConcoursController {


    @FXML
    private TextField txtdate;

    @FXML
    private TextField txtlien;

    @FXML
    private TextField txtprix;

    @FXML
    private TextField txttype;

    private final ServiceConcours ser=new ServiceConcours();

    @FXML
    void ajouterconcours(ActionEvent event) {


        int prix=Integer.parseInt(txtprix.getText());
        String date=txtdate.getText();
        String type=txttype.getText();
        String lien=txtlien.getText();
        Concours p1=new Concours(prix,date,type,lien);

        Alert alert1=new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation");
        alert1.setContentText("Concour ajouté avec succés");
        alert1.showAndWait();

        try {
            ser.ajouter(p1);
        } catch (SQLException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }


    }

    @FXML
    void afficherConcours(ActionEvent event) {

        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/afficherConcours.fxml"));
            Parent root=loader.load();

            AfficherPersonneControllers dc=loader.getController();
            dc.setLbname(txtdate.getText());
            txtprix.getScene().setRoot(root);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
