package com.gumblemachine.pattern.state;

import com.gumblemachine.pattern.GumballMachine;
import com.gumblemachine.pattern.state.State;

/**
 * Created by ss on 2017/9/9.
 */
public class SoldOutState implements State {

    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter(int coin) {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }

    public void ejectQuarter() {

        if (gumballMachine.getDeposit() > 0) {
            gumballMachine.returnDeposit();
        } else {
            System.out.println("You haven't inserted any coin.");
        }
    }

    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    public String toString() {
        return "sold out";
    }
}
