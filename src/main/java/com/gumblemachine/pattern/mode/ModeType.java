package com.gumblemachine.pattern.mode;

/**
 * Created by ss on 2017/9/9.
 */

/**
 * there is three modes:basic, normal, premium
 * the basic type can just add one quarter, which is the same as the first gumballMachine in the requirement,
 * the normal type can add at most two quarter, which is the same as the second gumballMachine in the requirement
 * the premium type can add any coins, which is the same as the third gumballMachine in the requirement
 */
public enum ModeType {
    BASIC, NORMAL, PREMIUM
}
