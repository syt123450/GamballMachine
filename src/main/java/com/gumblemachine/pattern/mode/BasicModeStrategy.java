package com.gumblemachine.pattern.mode;

import com.gumblemachine.pattern.GumballMachine;
import com.gumblemachine.pattern.mode.ModeStrategy;

/**
 * Created by ss on 2017/9/9.
 */
public class BasicModeStrategy implements ModeStrategy {

    private GumballMachine gumballMachine;

    public BasicModeStrategy(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public boolean validateInsert(int coin) {

        return coin == 25 && gumballMachine.getDeposit() == 0;
    }

    @Override
    public boolean isPrepared() {

        return gumballMachine.getDeposit() >= 25;
    }

    @Override
    public void subDeposit() {
        gumballMachine.setDeposit(gumballMachine.getDeposit() - 25);
    }
}
