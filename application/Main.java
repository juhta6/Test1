package application;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import javax.swing.JOptionPane;

public class Main extends Application {

	private final ResourceInit resources = new ResourceInit();
	private final BorderPane root = new BorderPane();
	private final Scene scene = new Scene(root,400,400);
	private final Image image = new Image(resources.getURL());
	private final ImageView imageView = new ImageView();
	private final Node node = imageView;
	
	private final double windowH = scene.getHeight();
	private final double windowW = scene.getWidth();
	
	private final double imageH = image.getHeight();
	private final double imageW = image.getWidth();

	private final Text statics = new Text("Window height: "+windowH+"   Window width: "+windowW+"\nImage height: "+imageH+"   Image width: "+imageW);
	
	@Override
	public void start(Stage primaryStage) {
		System.out.println("Loading "+getClass());
		imageView.setImage(image);
		imageView.setLayoutY(windowH/2-imageH/2);
		imageView.setLayoutX(windowW/2-imageW/2);
		statics.setLayoutY(10);
		root.getChildren().addAll(statics, node);
		
		primaryStage.setResizable(false);
		
		primaryStage.setTitle("Test");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) throws Throwable {
		try {
			launch(args);
		} catch (Throwable t) {
			JOptionPane.showMessageDialog(null, t.getClass().getSimpleName() +": "+t.getMessage());
			throw t;
		}
	}
}
