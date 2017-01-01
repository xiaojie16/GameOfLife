package sample;

import javafx.fxml.FXML;

public class MainController{

    @FXML
    private void btnStart(){
        try {
            Main.replaceSceneContent("game.fxml");   //切换 Stage
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
}
