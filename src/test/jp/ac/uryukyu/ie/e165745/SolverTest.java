package jp.ac.uryukyu.ie.e165745;
/*
 * Created by e165745 on 2017/02/06.　
 */
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class SolverTest {




    @Test
    public void ispanel() throws Exception {

        Rectangle WND_RECT = new Rectangle(142, 480, 356, 140);

        main.jp.ac.uyukyu.ie.e165745.MessageWindow messagewindow = new main.jp.ac.uyukyu.ie.e165745.MessageWindow(WND_RECT);

        messagewindow.show();

        assertTrue(messagewindow.isVisible());

    }
}