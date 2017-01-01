package sample;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author by kissx on 2016/12/31.
 */
class GameCanvas extends javafx.scene.canvas.Canvas{
    // 游戏地图
    private GameMap gameMap;
    private GraphicsContext gContext;
    private int[][] oldIndex = new int[75][50];

    public static Timer timer;
    private int sleep = 100;

    GameCanvas(double width, double height,int[][] mapIndex) {
        super(width,height);
        Image map = new Image(getClass().getResourceAsStream("\\picture\\picture.png"));
        //初始化游戏地图
        gContext = getGraphicsContext2D();
        int tileWidth = 10;
        int tileHeight = 10;
        gameMap = new GameMap(tileWidth, tileHeight, map);
        gameMap.setIndex(mapIndex);
        draw();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {       //主线程更新 UI
                    update();
                });
            }
        },1000,sleep);
    }

    private void draw(){
        gameMap.drawMap(gContext);
    }

    private void update(){
        int count;
        int[][] mapIndex = gameMap.getMapIndex();
        for(int i = 0; i < mapIndex.length; ++i)
            for (int j = 0; j < mapIndex[0].length; j++)
                oldIndex[i][j] = mapIndex[i][j];
        for(int i = 0; i < mapIndex.length; ++i)
            for (int j = 0; j < mapIndex[0].length; j++) {
                if (i <= 1 || i >= 73 || j <= 1 || j >= 48)
                    continue;
                count = countAround(i,j);
                if (count == 3)
                    mapIndex[i][j] = 0;
                else if (count != 2)
                    mapIndex[i][j] = 1;
            }
            draw();
    }

    //查看 x,y 位置周围 0 的个数（生存的个数）
    private int countAround(int x,int y){
        int count = 0;
        if (oldIndex[x-1][y-1] == 0)
            ++count;
        if (oldIndex[x-1][y] == 0)
            ++count;
        if (oldIndex[x-1][y+1] == 0)
            ++count;
        if (oldIndex[x][y-1] == 0)
            ++count;
        if (oldIndex[x][y+1] == 0)
            ++count;
        if (oldIndex[x+1][y-1] == 0)
            ++count;
        if (oldIndex[x+1][y] == 0)
            ++count;
        if (oldIndex[x+1][y+1] == 0)
            ++count;
        return count;
    }
}
