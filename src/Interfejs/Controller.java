package Interfejs;

import javafx.animation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

import java.util.Objects;

import static Interfejs.Main.*;

public class Controller {

    ObservableList<String> stacjeRobocze =
            FXCollections.observableArrayList("W1", "W2", "W3", "W4");
    ObservableList<String> zasoby =
            FXCollections.observableArrayList("Skaner1", "Skaner2", "Drukarka1", "Drukarka2");

    @FXML
    public ComboBox<String> combo1;
    @FXML
    private ComboBox<String> combo2;
    @FXML
    private ComboBox<String> combo3;
    @FXML
    private ComboBox<String> combo4;
    @FXML
    private ComboBox<String> combo5;
    @FXML
    private ComboBox<String> combo6;
    @FXML
    private ComboBox<String> combo7;
    @FXML
    private ComboBox<String> combo8;

    @FXML
    private Polyline line_w1;
    @FXML
    private Polyline line_w2;
    @FXML
    private Polyline line_w3;
    @FXML
    private Polyline line_w4;
    @FXML
    private Polyline line_skaner1;
    @FXML
    private Polyline line_skaner2;
    @FXML
    private Polyline line_drukarka1;
    @FXML
    private Polyline line_drukarka2;

    @FXML Button start;
    @FXML Button przerwij;

    @FXML
    private void initialize()
    {
        combo1.setItems(stacjeRobocze);
        combo5.setItems(zasoby);
        LinesOff();
    }

    @FXML
    private void pickComputer(){
        ObservableList<String> workingStations =
                FXCollections.observableArrayList("W1", "W2", "W3", "W4");
        if(combo1.getValue() != null && combo2.getValue() == null){
            combo2.setItems(workingStations);
            combo2.getItems().remove(combo1.getValue());
        }
        ObservableList<String> workingStations2 =
                FXCollections.observableArrayList("W1", "W2", "W3", "W4");
        if(combo2.getValue() != null && combo1.getValue() != null){
            combo3.setItems(workingStations2);
            combo3.getItems().remove(combo2.getValue());
            if(combo1.getValue() != null)
                combo3.getItems().remove(combo1.getValue());
            if((Objects.equals(combo1.getValue(), "W1") && combo2.getValue().equals("W2")) || (combo1.getValue().equals("W2") && combo2.getValue().equals("W1")) ||
                    (combo1.getValue().equals("W3") && combo2.getValue().equals("W4")) || (combo1.getValue().equals("W4") && combo2.getValue().equals("W3")))
            {
                if(combo5.getValue().equals("Skaner1"))
                {
                    combo6.getItems().remove("Skaner2");
                }
                if(combo5.getValue().equals("Skaner2"))
                {
                    combo6.getItems().remove("Skaner1");
                }
                if(combo5.getValue().equals("Drukarka1"))
                {
                    combo6.getItems().remove("Drukarka2");
                }
                if(combo5.getValue().equals("Drukarka2"))
                {
                    combo6.getItems().remove("Drukarka1");
                }
            }
        }
        ObservableList<String> workingStations3 =
                FXCollections.observableArrayList("W1", "W2", "W3", "W4");
        if(combo3.getValue() != null && combo2.getValue() != null && combo1.getValue() != null){
            combo2.getItems().remove(combo3.getValue());
            combo4.setItems(workingStations3);
            combo4.getItems().remove(combo3.getValue());
            if(combo1.getValue() != null)
                combo4.getItems().remove(combo1.getValue());
            if(combo2.getValue() != null)
                combo4.getItems().remove(combo2.getValue());
        }
    }

    @FXML
    private void pickDevice(){
        ObservableList<String> devices =
                FXCollections.observableArrayList("Skaner1", "Skaner2", "Drukarka1", "Drukarka2");
        if(combo5.getValue() != null && combo6.getValue() == null){
            combo6.setItems(devices);
            combo6.getItems().remove(combo5.getValue());
        }
        ObservableList<String> devices2 =
                FXCollections.observableArrayList("Skaner1", "Skaner2", "Drukarka1", "Drukarka2");
        if(combo6.getValue() != null && combo5.getValue() != null){
            combo7.setItems(devices2);
            combo7.getItems().remove(combo6.getValue());
            if(combo5.getValue() != null)
                combo7.getItems().remove(combo5.getValue());
        }
        ObservableList<String> devices3 =
                FXCollections.observableArrayList("Skaner1", "Skaner2", "Drukarka1", "Drukarka2");
        if(combo7.getValue() != null && combo6.getValue() != null && combo5.getValue() != null){
            combo8.setItems(devices3);
            combo8.getItems().remove(combo7.getValue());
            if(combo5.getValue() != null)
                combo8.getItems().remove(combo5.getValue());
            if(combo6.getValue() != null)
                combo8.getItems().remove(combo6.getValue());
        }
    }


    @FXML
    private void StartButtonPushed() {
        if(combo1.getValue() == null && combo2.getValue() == null && combo3.getValue() == null && combo4.getValue() == null)
        {
            System.out.println("Wybierz połączenia");
            return;
        }
        FindAll();
        startWatki();
        start.setDisable(true);
        przerwij.setDisable(false);
    }

    private Polyline FindWorkingStation(Object value) {
        if ("W1".equals(value))
        {
            LineAnimation(line_w1);
            return line_w1;
        }
        else if ("W2".equals(value))
        {
            LineAnimation(line_w2);
            return line_w2;
        }
        else if ("W3".equals(value))
        {
            LineAnimation(line_w3);
            return line_w3;
        }
        else if ("W4".equals(value))
        {
            LineAnimation(line_w4);
            return line_w4;
        }
        return null;
    }

    private Polyline FindDevice(Object value) {
        if ("Skaner1".equals(value))
        {
            LineAnimation(line_skaner1);
            return line_skaner1;
        }
        else if ("Skaner2".equals(value))
        {
            LineAnimation(line_skaner2);
            return line_skaner2;
        }
        else if ("Drukarka1".equals(value))
        {
            LineAnimation(line_drukarka1);
            return line_drukarka1;
        }
        else if ("Drukarka2".equals(value))
        {
            LineAnimation(line_drukarka2);
            return line_drukarka2;
        }
        return null;
    }

    private void FindAll(){
            workStation = FindWorkingStation(combo1.getValue());
            device = FindDevice(combo5.getValue());
            workStation2 = FindWorkingStation(combo2.getValue());
            device2 = FindDevice(combo6.getValue());
            workStation3 = FindWorkingStation(combo3.getValue());
            device3 = FindDevice(combo7.getValue());
            workStation4 = FindWorkingStation(combo4.getValue());
            device4 = FindDevice(combo8.getValue());
    }

    @FXML
    private void PrzerwijButtonPushed() {
        przerwijWatki();
        combo1.setValue(null);
        combo2.setValue(null);
        combo3.setValue(null);
        combo4.setValue(null);
        combo5.setValue(null);
        combo6.setValue(null);
        combo7.setValue(null);
        combo8.setValue(null);
        LinesOff();
        przerwij.setDisable(true);
        start.setDisable(false);
    }

    private void LinesOff() {
        line_w1.setVisible(false);
        line_w2.setVisible(false);
        line_w3.setVisible(false);
        line_w4.setVisible(false);
        line_skaner1.setVisible(false);
        line_skaner2.setVisible(false);
        line_drukarka1.setVisible(false);
        line_drukarka2.setVisible(false);
    }

    private void LineAnimation(Polyline line) {
        final double maxOffset =
                line.getStrokeDashArray().stream()
                        .reduce(
                                0d,
                                (a, b) -> a - b
                        );

        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        new KeyValue(
                                line.strokeDashOffsetProperty(),
                                0,
                                Interpolator.LINEAR
                        )
                ),
                new KeyFrame(
                        Duration.seconds(4),
                        new KeyValue(
                                line.strokeDashOffsetProperty(),
                                maxOffset,
                                Interpolator.LINEAR
                        )
                )
        );
        if(timeline.getStatus() != Animation.Status.RUNNING){
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }

    }

}

