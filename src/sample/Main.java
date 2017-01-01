package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.InputStream;

public class Main extends Application {
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = primaryStage;
        primaryStage.setTitle("GameOfLife");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }

    public static Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * 切换 Stage
     */
    static void replaceSceneContent(String fxml) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        GridPane page;
        try (InputStream in = Main.class.getResourceAsStream(fxml)) {
            page = loader.load(in);
        }
        Scene scene = new Scene(page,800,600);
        stage.setScene(scene);
        stage.sizeToScene();
    }
}
