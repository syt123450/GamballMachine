package com.gumblemachine.pattern.state;

import com.gumblemachine.pattern.GumballMachine;
import com.gumblemachine.pattern.state.State;

/**
 * Created by ss on 2017/9/9.
 */
public class NoQuarterState implements State {

    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter(int coin) {

        if (gumballMachine.getModeStrategy().validateInsert(coin)) {
            gumballMachine.addDeposit(coin);
            System.out.println("You inserted $" + 1.0 * coin / 100);
            if (gumballMachine.getModeStrategy().isPrepared()) {
                gumballMachine.setState(gumballMachine.getHasQuarterState());
            }
        } else {
            System.out.println("Insert coin error.");
        }
    }

    public void ejectQuarter() {
        if (gumballMachine.getDeposit() > 0) {
            gumballMachine.returnDeposit();
        } else {
            System.out.println("You haven't inserted any coin.");
        }
    }

    public void turnCrank() {
        System.out.println("You turned, but there's no enough coins, you need to add more coins, to get gumball.");
    }

    public void dispense() {
        System.out.println("You need to pay first");
    }

    public String toString() {
        return "waiting for coins";
    }
}
