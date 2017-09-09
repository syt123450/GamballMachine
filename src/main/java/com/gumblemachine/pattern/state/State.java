package com.gumblemachine.pattern.state;

/**
 * Created by ss on 2017/9/9.
 */
public interface State {

    void insertQuarter(int coin);

    void ejectQuarter();

    void turnCrank();

    void dispense();
}