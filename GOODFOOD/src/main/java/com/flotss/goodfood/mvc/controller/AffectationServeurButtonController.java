package com.flotss.goodfood.mvc.controller;

import com.flotss.goodfood.mvc.view.AffectationServeurView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AffectationServeurButtonController implements EventHandler<ActionEvent> {

    private final int numServ;
    private final String nomServeur;

    public AffectationServeurButtonController(String numServ, String nomServeur) {
        this.numServ = Integer.parseInt(numServ);
        this.nomServeur = nomServeur;
    }

    @Override
    public void handle(ActionEvent event) {
        Stage stage = new Stage();
        stage.setTitle("Affectation du serveur " + numServ);

        AffectationServeurView affectationServeurView;
        try {
            affectationServeurView = new AffectationServeurView(numServ, nomServeur);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        stage.setScene(new Scene(affectationServeurView));
        stage.show();
    }
}