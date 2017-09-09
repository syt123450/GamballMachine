package com.gumblemachine.pattern.state;

import com.gumblemachine.pattern.GumballMachine;
import com.gumblemachine.pattern.state.State;

/**
 * Created by ss on 2017/9/9.
 */
public class HasQuarterState implements State {

    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter(int coin) {

        System.out.println("You can not add any coin");
    }

    public void ejectQuarter() {
        System.out.println("Coins returned");
        gumballMachine.returnDeposit();
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    public String toString() {
        return "waiting for turn of crank";
    }
}
