package com.gumblemachine.pattern;

import com.gumblemachine.pattern.mode.ModeType;

/**
 * Created by ss on 2017/9/9.
 */
public class Main {

    public static void main(String[] args) {

        //create one gumballMachine in BASIC mode, the BASIC mode is the default mode
        GumballMachine gumballMachine1 = new GumballMachine(3);

        System.out.println(gumballMachine1);

        System.out.println("======");

        //add one coin and eject one gumball in BASIC mode
        gumballMachine1.insertQuarter( 25 );
        gumballMachine1.turnCrank();

        System.out.println(gumballMachine1);

        System.out.println("======");

        //test cannot add two coins into BASIC mode gumballMachine

        gumballMachine1.insertQuarter( 25 );
        gumballMachine1.insertQuarter( 25 );
        gumballMachine1.turnCrank();

        System.out.println(gumballMachine1);

        System.out.println("======");

        //test eject coin from machine

        gumballMachine1.insertQuarter(25);
        gumballMachine1.ejectQuarter();

        System.out.println(gumballMachine1);

        System.out.println("======");

        //the BASIC mode can only insert quarter, so can not insert fifty cents

        gumballMachine1.insertQuarter(50);

        System.out.println(gumballMachine1);

        System.out.println("======");

        //the gumballMachine support NORMAL type and PREMIUM type, all three type have the same function as requirement

        GumballMachine gumballMachine2 = new GumballMachine(4);
        gumballMachine2.setModel(ModeType.NORMAL);
        GumballMachine gumballMachine3 = new GumballMachine(4);
        gumballMachine3.setModel(ModeType.PREMIUM);

        System.out.println(gumballMachine2);
        System.out.println(gumballMachine3);
    }
}
