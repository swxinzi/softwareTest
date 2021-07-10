package com.swxin.element;

/*
* 所有元素的基类
* */

import javax.swing.*;
import java.awt.*;

public abstract class ElementObj {

    private int x;
    private int y;
    private int w;
    private int h;
    private ImageIcon icon;
    //生存状态 true代表存在 false代表死亡
    private boolean exist = true;
    //时间限定
    private long gameTime = 0L;

    public ElementObj() {

    }

    /**
     * 带参数的构造函数
     * @param x 左上角x坐标
     * @param y 左上角y坐标
     * @param w 宽度
     * @param h 高度
     * @param icon 图片
     */
    public ElementObj(int x, int y, int w, int h, ImageIcon icon) {

        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.icon = icon;
    }

    /**
     * 抽象方法
     * @param g 画笔
     */
    public abstract void showElement(Graphics g);

    /**
     * @说明  定义接受键盘事件方法
     * @param bl    代表点击的类型，true代表按下，false代表松开
     * @param key   代表触发的键盘的code值
     */
    public void keyClick(boolean bl,int key) {

    }

    /**
     * @说明 模板模式
     */
    public final void model() {

        //先换装
        updateImage();
        //再移动
        move();
        //发射子弹
        send();
    }

    /**
     * @说明 移动方法 如果有需要移动的子类请重写这个方法
     */
    protected void move() { }

    /**
     * @说明 发射子弹方法
     */
    protected void send() { }

    /**
     * @说明 换装方法
     * @param gameTime
     */
    protected void updateImage() { }

    /**
     * @说明 定义创建对象函数 子类需要重写这个方法
     * @param str
     * @return ElementObj
     */
    public ElementObj createElement(String str) {

        return null;
    }

    /**
     * @说明 死亡方法 子类可以对该方法进行重写
     * 死亡也是一个对象
     */
    public void die() {

    }

    /**
     * @说明 返回对象的碰撞矩形对象 方便碰撞检测
     * @return Rectangle
     */
    public Rectangle getRectangle() {

        return new Rectangle(x, y, w, h);
    }

    /**
     * @说明 碰撞方法
     * @return boolean true代表有碰撞 false代表没有碰撞
     */
    public boolean isTouch(ElementObj obj) {

        //返回碰撞结果
        return this.getRectangle().intersects(obj.getRectangle());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
}
