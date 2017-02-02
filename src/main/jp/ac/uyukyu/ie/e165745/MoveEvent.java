package main.jp.ac.uyukyu.ie.e165745;

/**
 * Created by e165745 on 2017/02/02.
 */
public class MoveEvent extends Event {
    // 移動先のマップ番号
    public int destMapNo;
    // 移動先のX座標
    public int destX;
    // 移動先のY座標
    public int destY;

    public MoveEvent(int x, int y, int chipNo, int destMapNo, int destX, int destY) {
        // 上に乗ると移動するようにしたいのでぶつからない（false）に設定
        super(x, y, chipNo, false);
        this.destMapNo = destMapNo;
        this.destX = destX;
        this.destY = destY;
    }

    public String toString() {
        return "MOVE:" + super.toString() + ":" + destMapNo + ":" + destX + ":" + destY;
    }
}