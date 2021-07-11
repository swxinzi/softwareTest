package com.swxin.manager;

import javax.swing.*;
import java.io.InputStream;
import java.util.*;

/**
 * @说明 加载器 用于读取配置文件
 */
public class GameLoad {
    //图片集合 使用map来进行存储
    public static Map<String, ImageIcon> imageMap;

    /**
     * 静态导入图片
     */
    static {
        imageMap = new HashMap<>();
        //暂时存储图片
        imageMap.put("left", new ImageIcon("image/tank/play1/player1_left.png"));
        imageMap.put("up", new ImageIcon("image/tank/play1/player1_up.png"));
        imageMap.put("right", new ImageIcon("image/tank/play1/player1_right.png"));
        imageMap.put("down", new ImageIcon("image/tank/play1/player1_down.png"));
    }

    //读取地图配置文件
    private static Properties properties = new Properties();
    /**
     * @说明 加载地图配置文件
     * @param mapID 关卡地图标识 文件ID
     */
    public static void mapLoad(int mapID) {

        //得到配置文件路径
        String mapName = "com/swxin/text/" + mapID + ".map";
        //通过io流读取文件 得到类加载器
        ClassLoader classLoader = GameLoad.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream(mapName);
    }
}
