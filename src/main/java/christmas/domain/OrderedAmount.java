package christmas.domain;

import java.text.DecimalFormat;

public class OrderedAmount {
    private static final String PRICE_FORMAT = "###,###원";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat(PRICE_FORMAT);

    private static int totalAmount = 0;
    private static int totalDiscount = 0;


    public boolean isOverTenThousand() {
        return totalAmount >= 10000;
    }

    public boolean present() {
        return totalAmount >= 120000;
    }

    public void addTotalAmount(int amount) {
        totalAmount += amount;
    }
    public void discount(long discount) {
        totalDiscount -= discount;
    }

    public String totalAmount() {
        return MONEY_FORMAT.format(totalAmount);
    }

    public String totalDiscount() {
        return MONEY_FORMAT.format(totalDiscount);
    }

    public String afterDiscount() {
        return MONEY_FORMAT.format(totalAmount + totalDiscount);
    }

    public ChristmasBadge getBadge() {
        return ChristmasBadge.getBadge(totalAmount);
    }

    public boolean noDiscount() {
        return totalDiscount == 0;
    }
}
