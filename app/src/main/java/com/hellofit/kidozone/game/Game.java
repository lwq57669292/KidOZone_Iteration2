package com.hellofit.kidozone.game;

/**
 * @Author Zaifeng
 * @Create 2017/7/13 0013
 * @Description Content
 */

public interface Game {

    /**
     * 增加难度
     */
    public void addLevel();

    /**
     * 减少难度
     */
    public void reduceLevel();

    /**
     * 修改图片
     *
     * @param res
     */
    public void changeImage(int res);

}
