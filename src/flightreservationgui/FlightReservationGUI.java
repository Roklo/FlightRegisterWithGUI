/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationgui;

import flightreservationgui.border.ApplicationUI;
import flightreservationgui.border.TestFiller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Håkon
 */
public class FlightReservationGUI extends Application
{

    private static TestFiller filler;
    private static final boolean DEBUG = false;

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("FXML_MainMenu.fxml"));
        Scene scene = new Scene(root);
        //stage.setMaxHeight(900);
        //stage.setMaxWidth(1400);

        stage.getIcons().add(new Image("/Images/Icon3.png"));
        stage.setTitle("Luxury Flights");

        stage.setMinHeight(750);
        stage.setMinWidth(600);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //launch(args);

        if (DEBUG == true)
        {
            filler = new TestFiller();
            filler.startFillingRegister();
        }
        else
        {
            launch(args);
        }
    }
}
