import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.application.Platform;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import java.util.Random;

public class test_2 extends Application {
  
//defining score as an instance variable
private int score = 0;

@Override
public void start(final Stage stage) {
//creating label
final Label label = new Label("Score: 0");
//exit button
Button btnExit = new Button("Exit");
//adding event handler for exit button
btnExit.setOnAction(e -> Platform.exit());

//creating a Random number generator
final Random random = new Random();
//creating an array of 8 buttons
final Button btns[] = new Button[8];
//looping and initializing array
for (int i = 0; i < btns.length; i++) {
//creating a Button
Button btn = new Button();
//if i is 0, using "Dessert" as label, else using "Desert"
if (i == 0) {
btn.setText("Dessert");
} else {
btn.setText("Desert");
}
//adding action listener
btn.setOnAction(e -> {
//if clicked button has text "Dessert", incrementing score, else decrementing
if (btn.getText().equals("Dessert")) {
score++;
} else {
score--;
}
//displaying updated score
label.setText("Score: " + score);
//randomizing button locations
randomizeButtonPositions(random, btns);
//changing focus to exit button
btnExit.requestFocus();
});
//adding button to the array
btns[i] = btn;
  
}
  
//randomizing buttons locations initially
randomizeButtonPositions(random, btns);

Pane pane = new Pane();
//adding all buttons to the pane
pane.getChildren().addAll(btns);
BorderPane bp = new BorderPane();

bp.setTop(label);
bp.setBottom(btnExit);
bp.setCenter(pane);
//adjusting alignment of btnExit
BorderPane.setAlignment(btnExit, Pos.BOTTOM_RIGHT);
Scene scene = new Scene(bp, 640, 480);
stage.setScene(scene);
stage.setTitle("Desert JavaFX Game");
stage.show();
}

//method to randomize button positions
private void randomizeButtonPositions(Random random, Button btns[]) {
//looping through the array
for (int i = 0; i < btns.length; i++) {
//using a random x value between 0 and 600 and y value between 0 and 400
btns[i].setLayoutX(random.nextInt(600));
btns[i].setLayoutY(random.nextInt(400));
}
}

public static void main(String[] args) {
Application.launch();
	}
}
