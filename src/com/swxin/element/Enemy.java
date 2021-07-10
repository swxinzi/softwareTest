package com.swxin.element;

import com.swxin.element.ElementObj;
import com.swxin.manager.ElementManager;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * 敌人类
 */
public class Enemy extends ElementObj {
    //记录敌人的方向
    private String fx = "up";

    /**
     * 绘制敌人图片
     * @param g 画笔
     */
    @Override
    public void showElement(Graphics g) {

        //绘制图片
        g.drawImage(this.getIcon().getImage(),
                this.getX(), this.getY(), this.getW(), this.getH(),null);
    }

    /**
     * @说明 创建随机敌人对象
     * @param str
     * @return ElementObj
     */
    @Override
    public ElementObj createElement(String str) {

        //设置随机位置
        Random random = new Random();
        this.setX(random.nextInt(800));
        this.setY(random.nextInt(600));
        this.setW(50);
        this.setH(50);
        //设置随机方向
        switch (random.nextInt(4)) {
            case 0:
                this.setFx("left");
                this.setIcon(new ImageIcon("image/tank/bot/bot_left.png"));
                break;
            case 1:
                this.setFx("up");
                this.setIcon(new ImageIcon("image/tank/bot/bot_up.png"));
                break;
            case 2:
                this.setFx("right");
                this.setIcon(new ImageIcon("image/tank/bot/bot_right.png"));
                break;
            case 3:
                this.setFx("down");
                this.setIcon(new ImageIcon("image/tank/bot/bot_down.png"));
                break;
        }
        return this;
    }

    /**
     * @说明 重写父类的移动方法
     */
    @Override
    protected void move() {

        //向左走的敌人走到了边界
        if (this.getX() <= 0) {
            this.setFx("right");
            this.setIcon(new ImageIcon("image/tank/bot/bot_right.png"));
        }
        //向右走的敌人走到了边界
        if (this.getX() >= 500) {
            this.setFx("left");
            this.setIcon(new ImageIcon("image/tank/bot/bot_left.png"));
        }
        //向上走的敌人走到了边界
        if (this.getY() <= 0) {
            this.setFx("down");
            this.setIcon(new ImageIcon("image/tank/bot/bot_down.png"));
        }
        //向右走的敌人走到了边界
        if (this.getY() >= 600) {
            this.setFx("up");
            this.setIcon(new ImageIcon("image/tank/bot/bot_up.png"));
        }
        //根据敌人方向设置动作
        switch (this.fx) {
            case "left":
                this.setX(this.getX() - 1);
                break;
            case "up":
                this.setY(this.getY() - 1);
                break;
            case "right":
                this.setX(this.getX() + 1);
                break;
            case "down":
                this.setY(this.getY() + 1);
                break;
        }
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }
}
