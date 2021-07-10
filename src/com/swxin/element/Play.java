package com.swxin.element;

import com.swxin.manager.ElementManager;
import com.swxin.manager.GameLoad;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @说明 玩家游戏类
 */
public class Play extends ElementObj {
    //使用4属性代表上下左右  true代表移动    false代表不移动
    private boolean left = false;   //左
    private boolean up = false;     //上
    private boolean right = false;  //右
    private boolean down = false;   //下

    //记录当前主角面向的方向 默认是向上
    private String fx = "up";
    //攻击状态 true为攻击 false为停止攻击
    private boolean attackType = false;

    /**
     * @param x    左上角x坐标
     * @param y    左上角y坐标
     * @param w    宽度
     * @param h    高度
     * @param icon 图片
     */
    public Play(int x, int y, int w, int h, ImageIcon icon) {

        super(x, y, w, h, icon);
    }

    /**
     * @param g 画笔
     * @说明 绘制图片
     */
    @Override
    public void showElement(Graphics g) {

        g.drawImage(this.getIcon().getImage(),
                this.getX(),
                this.getY(),
                this.getW(),
                this.getH(), null);
    }

    /**
     * @说明 键盘监听事件 控制坦克
     * @param bl  代表点击的类型，true代表按下，false代表松开
     * @param key 代表触发的键盘的code值
     */
    @Override
    public void keyClick(boolean bl, int key) {

        if (bl) {
            switch (key) {
                case 37:
                    this.fx = "left";
                    this.right = false;
                    this.up = false;
                    this.down = false;
                    this.left = true;
                    break;
                case 38:
                    this.fx = "up";
                    this.down = false;
                    this.left = false;
                    this.right = false;
                    this.up = true;
                    break;
                case 39:
                    this.fx = "right";
                    this.left = false;
                    this.up = false;
                    this.down = false;
                    this.right = true;
                    break;
                case 40:
                    this.fx = "down";
                    this.up = false;
                    this.left = false;
                    this.right = false;
                    this.down = true;
                    break;
                case 32:
                    //开启攻击状态
                    this.attackType = true;
                    break;
            }
        } else {
            switch (key) {
                case 37:
                    this.left = false;
                    break;
                case 38:
                    this.up = false;
                    break;
                case 39:
                    this.right = false;
                    break;
                case 40:
                    this.down = false;
                    break;
                case 32:
                    //关闭攻击状态
                    this.attackType = false;
                    break;
            }
        }
    }

    /**
     * @说明 重写移动方法
     * 判定位置 设定边界值
     */
    @Override
    public void move() {

        if (this.left && this.getX() > 0) {
            this.setX(this.getX() - 5);
        }
        if (this.up && this.getY() > 0) {
            this.setY(this.getY() - 5);
        }
        if (this.right && this.getX() < 900 - this.getW()) {
            this.setX(this.getX() + 5);
        }
        if (this.down && this.getY() < 600 - this.getH()) {
            this.setY(this.getY() + 5);
        }
    }

    /**
     * @说明 重写换装方法 刷新方向
     */
    @Override
    protected void updateImage() {

        //重新设置图片 达到改变图片方向
        this.setIcon(GameLoad.imageMap.get(fx));
    }

    /**
     * @说明 重写射击方法
     */
    @Override
    protected void send() {

        //不是攻击状态，停止攻击
        if (!this.attackType) {
            return;
        }
        attackType = false;
        //创建对象
        ElementObj element = new PlayFile().createElement(this.toString());
        //装入到集合中
        ElementManager.getManager().addElement(element,GameElement.PLAYFILE);
    }

    @Override
    public String toString() {

        //调整子弹位置
        int x = this.getX();
        int y = this.getY();
        switch (this.fx) {
            case "up":
                x += 20;
                break;
            case "down":
                x += 20;
                y += 40;
                break;
            case "left":
                y += 20;
                break;
            case "right":
                y += 20;
                x += 40;
                break;
        }
        return "x:" + x + ",y:" + y + ",f:" + this.fx;
    }
}
