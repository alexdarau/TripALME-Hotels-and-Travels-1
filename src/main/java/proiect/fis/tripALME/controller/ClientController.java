package proiect.fis.tripALME.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ClientController {

    @FXML
    private AnchorPane client;

    @FXML
    private Label requestStatus;



    private JSONArray requests;

    private String requestString = "";

    public void initialize(){


        Object obj;
        JSONParser parser = new JSONParser();
        try {
            FileReader readFile = new FileReader("src/main/java/data/request.json");
            BufferedReader read = new BufferedReader(readFile);
            obj = parser.parse(read);
            if (obj instanceof JSONArray) {
                requests = (JSONArray) obj;
            }

        } catch (ParseException | IOException ex) {
            ex.printStackTrace();
        }
        for (int i=0;i<requests.size();i++) {

            JSONObject o=(JSONObject) requests.get(i);

            requestString = requestString + o.get("request").toString() + " " + o.get("status").toString() + "\n" ;
        }
        requestStatus.setText(requestString);

    }
    @FXML
    void SearchCity() {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("HotelSelection.fxml"));
            client.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println("Cant load the window");
        }


    }

    @FXML
    void Logout() {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("Login.fxml"));
            client.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println("Cant load the window");
        }


    }
}
