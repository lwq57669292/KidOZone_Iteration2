package com.hellofit.kidozone.game;


public interface Game {

    /**
     * Add level
     */
    public void addLevel();

    /**
     * Reduce level
     */
    public void reduceLevel();

    /**
     * Change image
     *
     * @param res
     */
    public void changeImage(int res);

}
