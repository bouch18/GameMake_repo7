package main.jp.ac.uyukyu.ie.e165745;

/**
 * Created by e165745 on 2017/01/18.
 */
import java.awt.Container;

import javax.swing.JFrame;

/*
 * Created on 2005/10/09
 *
 */

/**
 * @author mori
 *
 */
public class Rpg extends JFrame {
    public Rpg() {
        // タイトルを設定
        setTitle("勇者登場");

        // パネルを作成
        MainPanel panel = new MainPanel();
        Container contentPane = getContentPane();
        contentPane.add(panel);

        // パネルサイズに合わせてフレームサイズを自動設定
        pack();
    }

    public static void main(String[] args) {
        Rpg frame = new Rpg();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
