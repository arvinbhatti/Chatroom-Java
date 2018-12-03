package assignment7;



import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {
	public static String user = "no username";
	public static int serverport = 0;
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Welcome to ChatRoom");
        
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

//		Text scenetitle = new Text("Welcome");
//		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//		grid.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);

		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);

		
		
		Label ser = new Label("Server Port:");
		grid.add(ser, 0, 2);
		
		TextField serverTextField = new TextField();
		grid.add(serverTextField, 1, 2);
		
		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 3);
		
		Label kljal = new Label("Server Port:");
		grid.add(kljal, 0, 4);
		
		TextField server2TextField = new TextField();
		grid.add(server2TextField, 1, 4);
		
		Button btn2 = new Button("Make Server");
		HBox hbBtn2 = new HBox(10);
		hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn2.getChildren().add(btn2);
		grid.add(hbBtn2, 1, 5);
		try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/assignment7/Computer_Magic-Microsift-1901299923.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
		final Text actiontarget = new Text();
		btn.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {
		        actiontarget.setFill(Color.FIREBRICK);
		        user = userTextField.getText();
		        serverport = Integer.parseInt(serverTextField.getText());
		        
		        primaryStage.hide();
		        ChatServer.main(null);
		    }
		});
		
		
		
		btn2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {
		        serverport = Integer.parseInt(server2TextField.getText());
		        try {
			        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/assignment7/ie_Short_Cow_MooDTMF_Tones-KevanGC-494166652.wav").getAbsoluteFile());
			        Clip clip = AudioSystem.getClip();
			        clip.open(audioInputStream);
			        clip.start();
			    } catch(Exception ex) {
			        System.out.println("Error with playing sound.");
			        ex.printStackTrace();
			    }
		        primaryStage.hide();	        
		        ChatServer.main(null);
		    }
		});
		
		
		
        grid.add(actiontarget, 1, 6);
        
		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);
        primaryStage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(Login.class);
		
	}
}