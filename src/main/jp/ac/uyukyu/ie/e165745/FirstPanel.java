package main.jp.ac.uyukyu.ie.e165745;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;


/**
 * Created by e165745 on 2017/02/05.
  */
class FirstPanel extends JFrame implements Common{

    private boolean first_or_continue = false;

    private Graphics gm;

    static final int WIDTH = 640;
    public static final int HEIGHT = 640;

    private static final int EDGE_WIDTH = 2;

    private ActionKey leftKey;
    private ActionKey rightKey;
    private ActionKey upKey;
    private ActionKey downKey;
    private ActionKey spaceKey;

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

    // カーソルのアニメーションGIF
    private Image cursorImage;

    // 最大ページ
    private int maxPage;
    // 現在表示しているページ
    private int curPage = 0;

    // メッセージエンジン


    FirstPanel() {
        // パネルがキー操作を受け付けるように登録する
        setFocusable(true);
        //addKeyListener(this);

        // アクションキーを作成
        leftKey = new ActionKey();
        rightKey = new ActionKey();
        upKey = new ActionKey();
        downKey = new ActionKey();
        spaceKey = new ActionKey(ActionKey.DETECT_INITIAL_PRESS_ONLY);

        this.rect = rect;

        innerRect = new Rectangle(
                rect.x + EDGE_WIDTH,
                rect.y + EDGE_WIDTH,
                rect.width - EDGE_WIDTH * 2,
                rect.height - EDGE_WIDTH * 2);

        textRect = new Rectangle(
                innerRect.x + 16,
                innerRect.y + 16,
                320,
                120);

        // メッセージエンジンを作成


        // カーソルイメージをロード
        ImageIcon icon = new ImageIcon(getClass().getResource("image/cursor.gif"));



        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        JPanel p = new JPanel();

        JLabel label1 = new JLabel("今日の天気：");
        JLabel label2 = new JLabel();
        label2.setText("晴れのち曇り");


//        g.drawString("asdf", 100, 100);

    }
    /*public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // マップを描く
        //drawString(g);
        g.drawString("asdf", 100, 100);
    }*/

    public void show() {
        first_or_continue = true;
    }


    public boolean isFirst_or_continue(){
        return first_or_continue;

    }
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT) {
            leftKey.release();
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            rightKey.release();
        }
        if (keyCode == KeyEvent.VK_UP) {
            upKey.release();
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            downKey.release();
        }
        if (keyCode == KeyEvent.VK_SPACE) {
            spaceKey.release();
        }
    }
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT) {
            leftKey.press();
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            rightKey.press();
        }
        if (keyCode == KeyEvent.VK_UP) {
            upKey.press();
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            downKey.press();
        }
        if (keyCode == KeyEvent.VK_SPACE) {
            spaceKey.press();
        }
    }
}


