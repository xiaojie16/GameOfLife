package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void btnStart(){
        try {
            replaceSceneContent("game.fxml");   //切换 Stage
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    private void btnRate(){

    }
    @FXML
    private void btnAbout(){

    }

    /**
     * 切换 Stage
     */
    private void replaceSceneContent(String fxml) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        GridPane page;
        try{
            page = loader.load(in);
        }finally {
            in.close();
        }
        Scene scene = new Scene(page,800,600);
        Stage stage = Main.getStage();
        stage.setScene(scene);
        stage.sizeToScene();
    }


}
