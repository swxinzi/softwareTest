package com.swxin.manager;

/*
* 元素管理类
* */

import com.swxin.element.ElementObj;
import com.swxin.element.GameElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementManager {

    private List<Object> listMap;
    private List<Object> listPlay;
    private static ElementManager EM = null;

    private Map<GameElement, List<ElementObj>> gameElements;
    public Map<GameElement, List<ElementObj>> getGameElements() {

        return gameElements;
    }

    //添加元素(由加载器调用)
    public void addElement(ElementObj obj,GameElement ge) {

        List<ElementObj> list = gameElements.get(ge);
        list.add(obj);
    }

    //根据key返回list集合，去除某一类元素
    public List<ElementObj> getElementsByKey(GameElement ge) {

        return gameElements.get(ge);
    }

    //使用线程锁，保证只有一个线程
    public static synchronized ElementManager getManager() {

        if (EM == null) {
            //控制判定
            EM = new ElementManager();
        }
        return EM;
    }

    //私有化构造方法
    private ElementManager() {

        init();
    }

    //饿汉实例化对象
    /*static{

        EM = new ElementManager();

    }*/

    //实例化方法
    public void init() {

        gameElements = new HashMap<GameElement, List<ElementObj>>();
        //讲每种元素都放到map中
        /*gameElements.put(GameElement.MAPS, new ArrayList<ElementObj>());
        gameElements.put(GameElement.PLAY, new ArrayList<ElementObj>());
        gameElements.put(GameElement.ENEMY, new ArrayList<ElementObj>());
        gameElements.put(GameElement.BOSS, new ArrayList<ElementObj>());*/

        //第二种写法
        for (GameElement ge : GameElement.values()) {
            gameElements.put(ge, new ArrayList<ElementObj>());
        }

        //道具、子弹、爆炸效果、死亡效果...

    }
}
