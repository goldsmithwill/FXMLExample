package application;

import buddies.ClientBuddy;
import buddies.ServerBuddy;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {
	public static TextArea convoBox = new TextArea();

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("TalkBuddy");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text botName = new Text("KnockKnockBot");
		botName.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(botName, 0, 0, 2, 1);

		Label answer = new Label("Answer:");
		grid.add(answer, 0, 1);

		TextField answerTextField = new TextField();
		grid.add(answerTextField, 1, 1);

		convoBox.setEditable(false);

		convoBox.setPrefSize(145, 1000);

		grid.add(convoBox, 1, 2);

		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);
		primaryStage.show();

		String portNumber = "3300";
		String hostName = "192.168.1.154";
		ServerBuddy server = new ServerBuddy(portNumber);
		ClientBuddy client = new ClientBuddy(hostName, portNumber);

		new Thread(server).start();
		client.run();

	}

	public static void main(String[] args) {
		launch(args);

	}
}
