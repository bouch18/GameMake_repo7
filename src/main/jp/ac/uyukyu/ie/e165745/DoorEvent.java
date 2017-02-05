package main.jp.ac.uyukyu.ie.e165745;

/**
 * Created by e165745 on 2017/02/02.
  */
 class DoorEvent extends Event {
    /**
     * @param x X座標
     * @param y Y座標
     */
    DoorEvent(int x, int y) {
        // とびらのチップ番号は18でぶつかる
        super(x, y, 18, true);
    }

    /**
     * イベントを文字列に変換（デバッグ用）
     */
    public String toString() {
        return "DOOR:" + super.toString();
    }
}