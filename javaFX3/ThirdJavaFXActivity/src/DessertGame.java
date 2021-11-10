import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.geometry.Pos;
import java.util.Random;

public class DessertGame extends Application {
	
	private int score =0;
	

    @Override
    public void start(final Stage stage) {
        // Step 3 & 4
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 640, 480);
        stage.setTitle("Dessert in the Desert JavaFX Game");
        
        // Step 5
        Label scoreLabel = new Label("Score: 0");
        borderPane.setTop(scoreLabel);
        BorderPane.setAlignment(scoreLabel, Pos.TOP_LEFT);

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> {
            Platform.exit();
        });
        borderPane.setBottom(exitButton);
        BorderPane.setAlignment(exitButton, Pos.BOTTOM_RIGHT);
        
        // Step 6
        Pane pane = new Pane();
        borderPane.setCenter(pane);
        BorderPane.setAlignment(pane, Pos.CENTER);

        // TODO: Step 7-10
        
        Button[] buttons = new Button[7];
        Random random = new Random();     
        
        buttons[0] = new Button("Dessert");
        buttons[0].setOnAction((event)-> {
    		this.score++;
    	randomizeButtonPositions(random,buttons);
        scoreLabel.setText("Score: " +score);
        exitButton.requestFocus();
    	});   
        
        
        for(int i=1; i<buttons.length;i++) {
        	buttons[i] = new Button("Desert");
        	buttons[i].setOnAction((event)-> {
        		this.score--;
        	randomizeButtonPositions(random,buttons);
            scoreLabel.setText("Score: " +score);
            exitButton.requestFocus();
        	});       	
        }
        
        randomizeButtonPositions(random,buttons);
        exitButton.requestFocus();
        pane.getChildren().addAll(buttons);       

        
        stage.setScene(scene);
        stage.show();
    }
    
    public void randomizeButtonPositions(Random random, Button buttons[]) {
    	for (int i=0; i<buttons.length;i++)    	{
    		buttons[i].setLayoutX(random.nextInt(600));
        	buttons[i].setLayoutY(random.nextInt(400));    		
    	}
    }

    public static void main(String[] args) {
        Application.launch();
    }
}