package christmas.discounter;

public class WeekDayDiscounter {

    public int discount(int dessertAmount, int orderAmount) {
        if (orderAmount >= 10000) {
            orderAmount -= dessertAmount * 2023;
        }
        return orderAmount;
    }
}
