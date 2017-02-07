package main.jp.ac.uyukyu.ie.e165745;


import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by e165745 on 2017/02/06.
 */
public class MenuWindow {
    private static final int EDGE_WIDTH = 2;

    // 行間の大きさ
    protected static final int LINE_HEIGHT = 8;
    // 1行の最大文字数
    private static final int MAX_CHAR_IN_LINE = 20;
    // 1ページに表示できる最大行数
    private static final int MAX_LINES = 3;
    // 1ページに表示できる最大文字数
    private static final int MAX_CHAR_IN_PAGE = MAX_CHAR_IN_LINE * MAX_LINES;

    // 一番外側の枠
    private Rectangle rect;
    // 一つ内側の枠（白い枠線ができるように）
    private Rectangle innerRect;
    // 実際にテキストを描画する枠
    private Rectangle textRect;

    // メッセージウィンドウを表示中か
    private boolean isVisible = false;



    // メッセージを格納した配列
    private char[] text = new char[128 * MAX_CHAR_IN_LINE];


    // メッセージエンジン
    private MessageEngine messageEngine;

    // テキストを流すタイマータスク
    private Timer timer;
    private TimerTask task;

    void setMessage(String msg) {
        if (isVisible == false) return;


        // 全角スペースで初期化
        for (int i=0; i<text.length; i++) {
            text[i] = '　';
        }
        int p = 0;  // 処理中の文字位置
        for (int i=0; i<msg.length(); i++) {
            char c = msg.charAt(i);
            if (c == '\\') {
                i++;
                if (msg.charAt(i) == 'n') {  // 改行
                    p += MAX_CHAR_IN_LINE;
                    p = (p / MAX_CHAR_IN_LINE) * MAX_CHAR_IN_LINE;
                } else if (msg.charAt(i) == 'f') {  // 改ページ
                    p += MAX_CHAR_IN_PAGE;
                    p = (p / MAX_CHAR_IN_PAGE) * MAX_CHAR_IN_PAGE;
                }
            } else {
                text[p++] = c;
            }
        }



        // 文字を流すタスクを起動
        //task = new MessageWindow.DrawingMessageTask();
        timer.schedule(task, 0L, 20L);


    }

    public void show() {
        isVisible = true;
    }

    public void hide() {
        isVisible = false;
    }
}
