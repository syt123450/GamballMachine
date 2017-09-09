package com.gumblemachine.typical;

/**
 * Created by ss on 2017/9/9.
 */
public class GumballMachine {

    private int gumballsNumber;
    private ModeType modeType = ModeType.BASIC;

    //I use proxy design pattern to let the gumballMachine support three types which is described in the requirement
    private ModeProxy operationProxy = new BasicProxy();

    public GumballMachine(int gumballsNumber) {
        System.out.println("Create a gumballMachine with default type.");
        this.gumballsNumber = gumballsNumber;
    }

    public GumballMachine(int num_gumballs, ModeType modeType) {
        System.out.println("Create a gumballMachine with the mode type " + modeType);
        this.gumballsNumber = num_gumballs;
        this.modeType = modeType;
        this.operationProxy = ProxyFactory.getProxy(modeType);
    }

    public void insertCoin(int coin) {
        operationProxy.insertCoin(coin);
    }

    public void turnCrank() {
        if (gumballsNumber > 0) {
            if (operationProxy.turnCrank()) {
                gumballsNumber--;
            }
        } else {
            System.out.println("Sorry, these is no gumball left in the gumball machine.");
        }
    }

    public void setModel(ModeType modeType) {
        System.out.println("Change mode from " + this.modeType + " to " + modeType);
        this.modeType = modeType;
        this.operationProxy = ProxyFactory.getProxy(modeType);
    }

    @Override
    public String toString() {
        return "Machine info: " + modeType + " Gumball machine has " + gumballsNumber + " left in stock.";
    }

    /**
     * there is three modes:basic, normal, premium
     * the basic type can just add one quarter, which is the same as the first gumballMachine in the requirement,
     * the normal type can add at most two quarter, which is the same as the second gumballMachine in the requirement
     * the premium type can add any coins, which is the same as the third gumballMachine in the requirement
     */
    public enum ModeType {
        BASIC, NORMAL, PREMIUM
    }

    /**
     * this is a inner proxy factory, which can return the proxy instance based on the parameter of modeType,
     * now the proxy factory support three modes:
     * Basic Proxy instance for BASIC mode;
     * Normal Proxy instance for NORMAL mode;
     * Premium Proxy instance for PREMIUM mode.
     */
    private static class ProxyFactory {

        private static ModeProxy getProxy(ModeType modeType) {
            if (modeType.equals(ModeType.BASIC)) {
                return new BasicProxy();
            } else if (modeType.equals(ModeType.NORMAL)) {
                return new NormalProxy();
            } else if (modeType.equals(ModeType.PREMIUM)) {
                return new PremiumProxy();
            } else {
                System.out.println("GumballMachine can not support such model now.");
                return null;
            }
        }
    }

    //proxy interface, if there is more mode in the future, they can implement this interface to create new Proxy class
    private interface ModeProxy {

        void insertCoin(int coin);

        boolean turnCrank();
    }

    //implement for BASIC mode
    private static class BasicProxy implements ModeProxy {

        private boolean has_quarter;

        public void insertCoin(int coin) {

            if (coin == 25) {
                if (!has_quarter) {
                    this.has_quarter = true;
                    System.out.println("Successfully add a quarter to a BASIC mode gumballMachine.");
                } else {
                    System.out.println("You can not add more than one quarter to a BASIC mode gumballMachine.");
                }
            } else {
                System.out.println("You can only add one quarter to a BASIC mode gumballMachine.");
            }
        }

        public boolean turnCrank() {
            if (this.has_quarter) {
                this.has_quarter = false;
                System.out.println("Gumball Ejected from a BASIC mode gumballMachine!");
                return true;
            } else {
                System.out.println("Please insert a quarter to a BASIC mode gumballMachine.");
                return false;
            }
        }
    }

    //implement for NORMAL mode
    private static class NormalProxy implements ModeProxy {

        private int deposit;

        public void insertCoin(int coin) {
            if (coin == 25) {
                if (deposit < 50) {
                    deposit += 25;
                    System.out.println("Successfully add a quarter to a NORMAL gumballMachine, your funds now are $" + deposit / 100);
                } else {
                    System.out.println("Sorry, Normal mode gumballMachine can only accept two quarters.");
                }
            } else {
                System.out.println("Sorry, you can only add quarters to a Normal mode gumballMachine.");
            }
        }

        public boolean turnCrank() {
            if (deposit == 50) {
                deposit -= 50;
                System.out.println("Gumball ejected from a NORMAL mode gumballMachine!");
                return true;
            } else {
                System.out.println("To get a gumball from NORMAL mode gumballMachine, you funds should be $50, your funds now are: $" + deposit / 100);
                return false;
            }
        }
    }

    //implement for PREMIUM mode
    private static class PremiumProxy implements ModeProxy {

        private int deposit;

        public void insertCoin(int coin) {
            deposit = deposit + coin;
            System.out.println("Successfully add $" + coin / 100
                    + " to PREMIUM mode gumballMachine, your funds is " + deposit / 100 + "now.");
        }

        public boolean turnCrank() {

            if (deposit > 50) {
                deposit -= 50;
                System.out.println("Gumball ejected from PREMIUM gumballMachine, $" + deposit / 100 + " left.");
                return true;
            } else {
                System.out.println("Not sufficient funds in PREMIUM gumballMachine, $"
                        + deposit / 100 + " left, you need to insert at least $0.5.");
                return false;
            }
        }
    }
}