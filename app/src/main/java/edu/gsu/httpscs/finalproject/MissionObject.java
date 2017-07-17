package edu.gsu.httpscs.finalproject;

/**
 * Created by Tong on 2017/7/9.
 */

public class MissionObject {
    private int price;
    private int min;
    private int money;
    private int second;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getPrice() {
        return price;
    }

    public int getMin() {
        return min;
    }

    public int getSecond() {
        return second;
    }
}
