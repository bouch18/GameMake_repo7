package main.jp.ac.uyukyu.ie.e165745;

/**
 * Created by e165745 on 2017/02/01.
 */
public class TreasureEvent extends Event {
    // 宝箱に入っているアイテム名
    private String itemName;

    /**
     * @param x        X座標
     * @param y        Y座標
     * @param itemName 手に入るアイテム名
     */
    public TreasureEvent(int x, int y, String itemName) {
        // 宝箱のチップ番号は17でぶつからない
        super(x, y, 17, false);
        this.itemName = itemName;
    }

    /**
     * アイテム名を返す
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * イベントを文字列に変換（デバッグ用）
     */
    public String toString() {
        return "TREASURE:" + super.toString() + ":" + itemName;
    }
}