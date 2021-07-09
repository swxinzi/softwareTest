package com.swxin.view;

/*
* 游戏窗体
* 实现功能：关闭、显示、最大化
* 需要嵌入面板 启动主线程等
* swing awt 窗体大小（记录用户上次使用软件的窗体样式）
* */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameJFrame extends JFrame {

    //x大小
    public static int GameX = 900;
    //y大小
    public static int GameY = 600;
    private JPanel jPanel = null;
    //键盘监听
    private KeyListener keyListener = null;
    //鼠标监听
    private MouseListener mouseListener = null;
    private MouseMotionListener mouseMotionListener = null;
    //游戏主线程
    private Thread thread = null;

    public GameJFrame() {

        init();
    }

    public void init() {

        this.setSize(GameX,GameY);
        this.setTitle("游戏测试");
        //退出并关闭按钮
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //屏幕居中显示
        this.setLocationRelativeTo(null);
    }

    //窗体布局
    public void addButton() {

//        this.setLayout(manager);
    }

    /**
     * @说明 启动方法
     */
    public void start() {

        if (jPanel != null) {
            this.add(jPanel);
        }
        if (keyListener != null) {
            this.addKeyListener(keyListener);
        }
        if (thread != null) {
            //启动线程
            thread.start();
        }
        //界面刷新
        this.setVisible(true);
        //如果jPanel是Runnable的子类实体对象
        if (this.jPanel instanceof Runnable) {
            //强制类型转换 并开始线程
            new Thread((Runnable) this.jPanel).start();
        }
    }

    public void setJPanel(JPanel jPanel) {

        this.jPanel = jPanel;
    }

    public void setKeyListener(KeyListener keyListener) {
        this.keyListener = keyListener;
    }

    public void setMouseMotionListener(MouseMotionListener mouseMotionListener) {
        this.mouseMotionListener = mouseMotionListener;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
