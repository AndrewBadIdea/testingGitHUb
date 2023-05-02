/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author andre
 */
public class RegistrationOK extends Application {
    

    
    @Override
    public void start(Stage primaryStage){
        
        
        
           
        
         primaryStage.setTitle("Sign up");
        
        Label l1 = new Label("ID");
        TextField txt1 = new TextField();
        
         Label l2 = new Label("Email");
        TextField txt2 = new TextField();
        
         Label l3 = new Label("Password");
        TextField txt3 = new TextField();
        
         Label l4 = new Label("Name");
        TextField txt4 = new TextField();
        
        HBox hbox1 = new HBox(l1,txt1);
        hbox1.setSpacing(12);
        hbox1.setAlignment(Pos.CENTER);
        
          HBox hbox2 = new HBox(l2,txt2);
        hbox2.setSpacing(12);
        hbox2.setAlignment(Pos.CENTER);
        
          HBox hbox3 = new HBox(l3,txt3);
        hbox3.setSpacing(12);
        hbox3.setAlignment(Pos.CENTER);
        
          HBox hbox4 = new HBox(l4,txt4);
        hbox4.setSpacing(12);
        hbox4.setAlignment(Pos.CENTER);
        
        
        
        Button b1 = new Button("Sign up");
         Button b2 = new Button("Update");
             HBox hbox5 = new HBox(b1,b2);
        hbox5.setSpacing(12);
        hbox5.setAlignment(Pos.CENTER);
        
        b1.setOnAction(event -> {
        // database operation
        
        int id = Integer.parseInt(txt1.getText());
        String email = txt2.getText();
        String password = txt3.getText();
        String name = txt4.getText();
        
        //create querry
        
        
    
        String s = "Insert into registration values('"+id+"','"+email+"','"+password+"','"+name+"')";
        
     try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "1234");
                // Statement creation
            Statement stmt = con.createStatement();

            stmt.execute(s);
            con.close();
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        
        });
        
        b2.setOnAction(event -> {
          int id = Integer.parseInt(txt1.getText());
        String email = txt2.getText();
        String password = txt3.getText();
        String name = txt4.getText();
        
        //create querry
        
        
    
        String s = "Update registration set email='"+email+"', password='"+password+"', name='"+name+"' where id='"+id+"' ";
        
     try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "1234");
                // Statement creation
            Statement stmt = con.createStatement();

            stmt.execute(s);
            con.close();
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        
        
        
        
        });
        
        
        VBox vbox = new VBox(hbox1,hbox2,hbox3,hbox4,hbox5);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(12);
        
        
        Scene scene = new Scene(vbox,300,300);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
}
