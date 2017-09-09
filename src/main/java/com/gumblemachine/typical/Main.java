package com.gumblemachine.typical;

/**
 * Created by ss on 2017/9/9.
 */
public class Main {

    public static void main(String[] args) {

        //GumballMachine can be created by given the gumball number in it without set mode, the default mode is BASIC
        GumballMachine gumballMachine = new GumballMachine(10);

        System.out.println(gumballMachine);

        System.out.println("======");

        //add one coin and eject one gumball in BASIC mode
        gumballMachine.insertCoin( 25 );
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        System.out.println("======");

        //test cannot add two coins into BASIC mode gumballMachine

        gumballMachine.insertCoin( 25 );
        gumballMachine.insertCoin( 25 );
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        System.out.println("======");

        //change gumballMachine's mode from BASIC to NORMAL, add two quarter, and then eject gumball

        gumballMachine.setModel(GumballMachine.ModeType.NORMAL);
        System.out.println(gumballMachine);

        gumballMachine.insertCoin(25);
        gumballMachine.insertCoin(25);
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        System.out.println("======");

        //change gumballMachine's mode from NORMAL to PREMIUM, add 50 cents, and then eject gumball

        gumballMachine.setModel(GumballMachine.ModeType.PREMIUM);
        System.out.println(gumballMachine);

        gumballMachine.insertCoin(50);
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        System.out.println("======");

        //directly create a new PREMIUM mode gumballMachine

        GumballMachine newGumballMachine = new GumballMachine(10, GumballMachine.ModeType.PREMIUM);
        System.out.println(newGumballMachine);
    }
}
