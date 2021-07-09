package com.swxin.game;


import com.swxin.controller.GameListener;
import com.swxin.controller.GameThread;
import com.swxin.view.GameJFrame;
import com.swxin.view.GameMainJPanel;

/*
 * @说明 程序的唯一入口
 * */
public class GameStart {

    public static void main(String[] args) {

        GameJFrame gameJFrame = new GameJFrame();
        //实例化面板，注入到JFrame中
        GameMainJPanel gameMainJPanel = new GameMainJPanel();
        //实例化监听
        GameListener keyListener = new GameListener();
        //实例化主线程
        GameThread thread = new GameThread();
        //注入
        gameJFrame.setJPanel(gameMainJPanel);
        gameJFrame.setKeyListener(keyListener);
        gameJFrame.setThread(thread);
        gameJFrame.start();
    }
}
