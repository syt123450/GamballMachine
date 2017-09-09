package com.gumblemachine.pattern;

import com.gumblemachine.pattern.mode.ModeStrategy;
import com.gumblemachine.pattern.mode.ModeStrategyFactory;
import com.gumblemachine.pattern.mode.ModeType;
import com.gumblemachine.pattern.state.*;

/**
 * Created by ss on 2017/9/9.
 */
public class GumballMachine {

    private State soldOutState;
    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;
    private State state = soldOutState;
    private int count = 0;
    private int deposit;
    private ModeType modeType;
    private ModeStrategy modeStrategy;

    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }

        this.modeType = ModeType.BASIC;
        this.modeStrategy = ModeStrategyFactory.getStrategy(ModeType.BASIC, this);
    }

    public void setModel(ModeType modeType) {
        System.out.println("Change mode from " + this.modeType + " to " + modeType);
        this.modeType = modeType;
    }

    public void insertQuarter(int coin) {
        state.insertQuarter(coin);
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    public void refill(int count) {
        this.count = count;
        state = noQuarterState;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getDeposit() {
        return this.deposit;
    }

    public void returnDeposit() {
        this.deposit = 0;
    }

    public void addDeposit(int coin) {
        this.deposit += coin;
    }

    public ModeStrategy getModeStrategy() {
        return this.modeStrategy;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model " + modeType);
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
        return result.toString();
    }
}
