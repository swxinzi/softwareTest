package com.swxin.controller;

import com.swxin.element.ElementObj;
import com.swxin.element.GameElement;
import com.swxin.manager.ElementManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @监听类 用于监听用户操作
 */
public class GameListener implements KeyListener {
    private ElementManager em = ElementManager.getManager();

    /**
     * 通过一个集合记录所有按下的键，如果重复触发，就直接结束
     * 第一次按下松开就记录到集合中，第二次判定集合中是否有。
     * 松开就直接删除集合中的记录
     */
    private Set<Integer> set = new HashSet<Integer>();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * @按下键盘事件
     * 一直按会重复   左37 上38 右39 下40
     * 实现主角的移动
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {

        //获取玩家集合
        List<ElementObj> play = em.getElementsByKey(GameElement.PLAY);
        //判定是否包含重复值 是的话直接结束
        if (set.contains(e.getKeyCode())) {
            return;
        }
        //没有包含 加入到集合中
        set.add(e.getKeyCode());
        for (ElementObj obj : play) {
            obj.keyClick(true, e.getKeyCode());
        }
    }

    /**
     * @松开键盘事件
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {

        //获取玩家集合
        List<ElementObj> play = em.getElementsByKey(GameElement.PLAY);
        //判定是否包含重复值 是的话直接结束
        if (!set.contains(e.getKeyCode())) {
            return;
        }
        //没有包含 移除掉对应的值
        set.remove(e.getKeyCode());
        for (ElementObj obj : play) {
            obj.keyClick(false, e.getKeyCode());
        }
    }
}
