package com.swxin.controller;

import com.swxin.element.ElementObj;
import com.swxin.element.GameElement;
import com.swxin.element.Play;
import com.swxin.manager.ElementManager;

import javax.swing.*;
import java.util.List;
import java.util.Map;

/**
 * @说明  游戏的主线程，用于控制游戏的加载，游戏关卡，游戏运行时自动化，游戏判定，游戏地图切换，资源释放，重新读取
 * @继承  使用继承的方法实现多线程
 */
public class GameThread extends Thread{
    private ElementManager em;

    /**
     * @说明 无参数的构造方法
     */
    public GameThread() {

        em = ElementManager.getManager();
    }

    /**
     * @说明 游戏主线程 run方法
     */
    @Override
    public void run() {

        while (true) {
            //游戏开始前 读进度条 加载游戏资源
            gameLoad();
            //游戏进行时
            gameRun();
            //游戏场景结束 游戏资源回收
            gameOver();
            //进行休眠
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @说明 游戏结束
     */
    private void gameOver() {

    }

    /**
     * @说明 游戏进行时 游戏切换关卡
     * 自动化玩家的移动 碰撞 死亡
     * 新元素的增加 游戏暂停
     */
    private void gameRun() {

        while (true) {

            Map<GameElement, List<ElementObj>> all = em.getGameElements();
            //得到所有的key集合
            for (GameElement ge : GameElement.values()) {
                List<ElementObj> list = all.get(ge);
                for (int i = 0; i < list.size(); i++) {
                    //读取为基类
                    ElementObj obj = list.get(i);
                    //调用模板方法
                    obj.model();
                }
            }
            //休眠
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @说明 游戏加载
     */
    private void gameLoad() {

        load();
    }

    //测试代码
    public void load() {

        //图片导入
        ImageIcon icon = new ImageIcon("image/tank/play1/player1_up.png");
        //实例化对象
        ElementObj obj = new Play(100, 100, 50, 50, icon);
        //将对象放入到元素管理器中
        //em.getElementsByKey(GameElement.PLAY).add(obj);
        //直接添加对象
        em.addElement(obj, GameElement.PLAY);
    }
}
