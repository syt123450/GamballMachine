package com.gumblemachine.pattern.mode;

/**
 * Created by ss on 2017/9/9.
 */

/**
 * I use strategy design pattern to implement three modes of GumballMachine in one machine,
 * if there is more mode in the future, they can implement this interface to create new Strategy class
 */
public interface ModeStrategy {

    boolean validateInsert(int coin);

    boolean isPrepared();

    void subDeposit();
}
