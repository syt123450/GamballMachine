package com.gumblemachine.pattern.mode;

import com.gumblemachine.pattern.GumballMachine;
import com.gumblemachine.pattern.mode.ModeStrategy;

/**
 * Created by ss on 2017/9/9.
 */
public class PremiumModeStrategy implements ModeStrategy {

    private GumballMachine gumballMachine;

    public PremiumModeStrategy(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public boolean validateInsert(int coin) {
        return gumballMachine.getDeposit() + coin <= 50;
    }

    @Override
    public boolean isPrepared() {
        return gumballMachine.getDeposit() == 50;
    }

    @Override
    public void subDeposit() {
        gumballMachine.setDeposit(gumballMachine.getDeposit() - 50);
    }
}
