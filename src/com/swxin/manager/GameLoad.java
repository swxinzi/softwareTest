package com.swxin.manager;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @说明 假的加载器
 */
public class GameLoad {
    //图片集合 使用map来进行存储
    public static Map<String, ImageIcon> imageMap;

    /**
     * 静态导入图片 暂时性
     */
    static {
        imageMap = new HashMap<>();
        //暂时存储图片
        imageMap.put("left", new ImageIcon("image/tank/play1/player1_left.png"));
        imageMap.put("up", new ImageIcon("image/tank/play1/player1_up.png"));
        imageMap.put("right", new ImageIcon("image/tank/play1/player1_right.png"));
        imageMap.put("down", new ImageIcon("image/tank/play1/player1_down.png"));
    }
}
