package Interfejs;

import Watki.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class Main extends Application {
    static Thread c1, c2, c3, c4;
    static Polyline workStation;
    static Polyline device;
    static Polyline workStation2;
    static Polyline device2;
    static Polyline workStation3;
    static Polyline device3;
    static Polyline workStation4;
    static Polyline device4;
    public static boolean buffor = true;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Sieć komputerowa");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void przerwijWatki(){
        try{
            c1.interrupt();
            c2.interrupt();
            c3.interrupt();
            c4.interrupt();
        }catch(NullPointerException ignored){

        }
    }

    public static void startWatki() {
        if(workStation != null && device!=null)
        {
            c1 = new Connection(workStation, device);
            c1.start();
        }

        if(workStation2 != null && device2!=null)
        {
            c2 = new Connection(workStation2, device2);
            c2.start();
        }

        if(workStation3 != null && device3!=null)
        {
            c3 = new Connection(workStation3, device3);
            c3.start();
        }

        if(workStation4 != null && device4!=null)
        {
            c4 = new Connection(workStation4, device4);
            c4.start();
        }
    }

}
