package com.swxin.element;

import com.swxin.manager.ElementManager;

import javax.swing.*;
import java.awt.*;

/**
 * @说明 玩家子弹类
 * 本类的会提对象是由玩家对象调用创建
 */
public class PlayFile extends ElementObj{
    //攻击力
    private int damage = 1;
    //移动速度值
    private int speed = 3;
    //发射方向
    private String fx;

    /**
     * @说明 无参数的构造函数
     */
    public PlayFile() { }

    /**
     * @说明 重写父类方法 对创建playFile对象的过程进行封装
     * @return ElementObj
     */
    @Override
    public ElementObj createElement(String str) {

        //对字符串进行解析
        String[] split = str.split(",");
        for (String s : split) {
            String[] split1 = s.split(":");
            switch (split1[0]) {
                case "x":
                    this.setX(Integer.parseInt(split1[1]));
                    break;
                case "y":
                    this.setY(Integer.parseInt(split1[1]));
                    break;
                case "f":
                    this.fx = split1[1];
                    break;
            }
        }
        //设置子弹宽高
        this.setW(8);
        this.setH(8);
        return this;
    }

    @Override
    public void showElement(Graphics g) {

        //设置颜色
        g.setColor(Color.RED);
        g.fillOval(this.getX(),this.getY(), this.getW(), this.getH());
    }

    @Override
    protected void move() {

        //判定是否出界
        if (this.getX() < 0 || this.getX() > 500
                || this.getY() < 0 || this.getY() > 600) {
            this.setExist(false);
            //出界后停止移动子弹
            return;
        }
        switch (this.fx) {
            case "up":
                this.setY(this.getY() - this.speed);
                break;
            case "left":
                this.setX(this.getX() - this.speed);
                break;
            case "down":
                this.setY(this.getY() + this.speed);
                break;
            case "right":
                this.setX((this.getX() + this.speed));
                break;
        }
    }

    /**
     * 子弹死亡效果
     */
    /*@Override
    public void die() {

        ElementManager em = ElementManager.getManager();
        //图片导入
        ImageIcon icon = new ImageIcon("image/tank/play2/player2_up.png");
        //实例化对象
        ElementObj obj = new Play(this.getX(),this.getY(), 50, 50, icon);
        //将对象放入到元素管理器中
        em.addElement(obj, GameElement.DIE);
    }*/
}
