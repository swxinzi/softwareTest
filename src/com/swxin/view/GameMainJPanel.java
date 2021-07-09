package com.swxin.view;

/*
* 游戏主要面板
* 进行元素的显示，同时进行界面的刷新（多线程）
* */

import com.swxin.element.ElementObj;
import com.swxin.element.GameElement;
import com.swxin.element.Play;
import com.swxin.manager.ElementManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 本类实现元素的显示，同时进行界面的刷新
 */
public class GameMainJPanel extends JPanel implements Runnable{

    //联动管理器
    private ElementManager em;

    /**
     * @说明 无参数的构造函数
     */
    public GameMainJPanel() {

        init();
    }

    /**
     * @说明 初始化方法
     */
    public void init() {

        //得到元素管理器对象
        em = ElementManager.getManager();
    }

    /**
     * @说明 绘画功能 本方法只是执行一次 没有界面刷新功能
     * @param g
     */
    @Override
    public void paint(Graphics g) {

        super.paint(g);
        Map<GameElement, List<ElementObj>> all = em.getGameElements();
        //得到所有的key集合
        for (GameElement ge : GameElement.values()) {
            List<ElementObj> list = all.get(ge);
            for (int i = 0; i < list.size(); i++) {
                //读取为基类
                ElementObj obj = list.get(i);
                obj.showElement(g);
            }
        }

        /*Set<GameElement> set = all.keySet();
        for (GameElement ge : set) {
            List<ElementObj> list = all.get(ge);
            for (int i = 0; i < list.size(); i++) {
                //读取为基类
                ElementObj obj = list.get(i);
                obj.showElement(g);
            }
        }*/

    }

    /**
     * @说明 多线程重写run方法 实现界面不断刷新
     */
    @Override
    public void run() {

        while (true) {
            this.repaint();
            //控制刷新速度
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
