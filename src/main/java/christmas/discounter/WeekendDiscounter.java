package christmas.discounter;

public class WeekendDiscounter {

    public int discount(int mainAmount, int orderAmount) {
        if (orderAmount >= 10000) {
            orderAmount -= mainAmount * 2023;
        }
        return orderAmount;
    }
}
