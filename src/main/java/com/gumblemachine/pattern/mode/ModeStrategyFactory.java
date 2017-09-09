package com.gumblemachine.pattern.mode;

import com.gumblemachine.pattern.GumballMachine;

/**
 * Created by ss on 2017/9/9.
 */
public class ModeStrategyFactory {

    public static ModeStrategy getStrategy(ModeType modeType, GumballMachine gumballMachine) {

        if (modeType.equals(ModeType.BASIC)) {
            return new BasicModeStrategy(gumballMachine);
        } else if (modeType.equals(ModeType.NORMAL)) {
            return new NormalModeStrategy(gumballMachine);
        } else if (modeType.equals(ModeType.PREMIUM)) {
            return new PremiumModeStrategy(gumballMachine);
        } else {
            System.out.println("The modeType " + modeType + " has not supported in this factory now.");
            return null;
        }
    }
}
