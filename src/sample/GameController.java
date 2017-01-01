package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * @author by kissx on 2016/12/31.
 */
public class GameController implements Initializable{

    private Random random = new Random();
    private int[][] mapIndex = new int[75][50];

    @FXML
    private AnchorPane ap;

    @FXML
    private void btnBack(){
        if (GameCanvas.timer != null) {
            GameCanvas.timer.cancel();
        }
        try {
            Main.replaceSceneContent("main.fxml");   //切换 Stage
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // initialize 用于初始化
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initMapIndex();
        GameCanvas gameCanvas = new GameCanvas(750,500,mapIndex);
        ap.getChildren().add(gameCanvas);
    }

    //初始化 MapIndex
    private void initMapIndex(){
        for (int i = 0; i < 75; i++) {
            for (int j = 0; j < 50; j++) {
                mapIndex[i][j] = 1;
            }
        }
        for (int i = 0;i < mapIndex.length;++i)
            for (int j = 0;j < mapIndex[0].length;++j) {
                if (i == 0 || j == 0 || i == 74 || j == 49){
                    mapIndex[i][j] = 0;
                }else if(i == 1 || j == 1 || i == 73 || j == 48){
                    mapIndex[i][j] = 1;
                }
                //随机初始化
                else
                    mapIndex[i][j] = random.nextInt(2);
            }
//            model1();
//        model2();
    }

    private void model1(){
        mapIndex[6][2] = 0;
        mapIndex[6][3] = 0;
        mapIndex[7][2] = 0;
        mapIndex[7][3] = 0;
        mapIndex[4][14] = 0;
        mapIndex[4][15] = 0;
        mapIndex[5][13] = 0;
        mapIndex[5][17] = 0;
        mapIndex[6][12] = 0;
        mapIndex[6][18] = 0;
        mapIndex[7][12] = 0;
        mapIndex[7][16] = 0;
        mapIndex[7][18] = 0;
        mapIndex[7][19] = 0;
        mapIndex[8][12] = 0;
        mapIndex[8][18] = 0;
        mapIndex[9][13] = 0;
        mapIndex[9][17] = 0;
        mapIndex[10][14] = 0;
        mapIndex[10][15] = 0;

        mapIndex[2][26] = 0;
        mapIndex[3][24] = 0;
        mapIndex[3][26] = 0;
        mapIndex[4][22] = 0;
        mapIndex[4][23] = 0;
        mapIndex[5][22] = 0;
        mapIndex[5][23] = 0;
        mapIndex[6][22] = 0;
        mapIndex[6][23] = 0;
        mapIndex[7][24] = 0;
        mapIndex[7][26] = 0;
        mapIndex[8][26] = 0;
        mapIndex[4][36] = 0;
        mapIndex[4][37] = 0;
        mapIndex[5][36] = 0;
        mapIndex[5][37] = 0;
    }

    private void model2(){
        mapIndex[3][2] = 0;
        mapIndex[4][3] = 0;
        mapIndex[4][4] = 0;
        mapIndex[3][4] = 0;
        mapIndex[2][4] = 0;
    }
}
