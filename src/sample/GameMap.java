package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * 画每一个 小块
 * @author by kissx on 2016/12/31.
 */
class GameMap {
    private int[][] mapIndex = new int[75][50];
    private int tileWidth;
    private int tileHeight;
    private Image image;
    private int cols;

    GameMap(int tileWidth, int tileHeight,Image image) {
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.image = image;
        cols = (int)(image.getWidth() / tileWidth);
    }

    void drawMap(GraphicsContext gc){
        for(int x = 0;x < mapIndex.length;x++)
            for(int y = 0;y < mapIndex[0].length;y++){
                int px = mapIndex[x][y] % cols;
                gc.drawImage(image,px * tileWidth, 0, tileWidth, tileHeight, x * tileWidth, y * tileHeight, tileWidth, tileHeight);
                //sx 表示要截取 image 中的相对位置
            }
    }

    void setIndex(int[][] newIndex){
        for (int i =0;i < mapIndex.length;++i)
            System.arraycopy(newIndex[i], 0, mapIndex[i], 0, mapIndex[0].length);
    }

    public int[][] getMapIndex() {
        return mapIndex;
    }
}
