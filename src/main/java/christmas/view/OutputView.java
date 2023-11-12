package christmas.view;

import christmas.ChristmasBadge;
import christmas.MenuCategory;

public class OutputView {

    public static void badgeAnnouncement(ChristmasBadge badge) {
        if (badge != ChristmasBadge.NO_BADGE) {
            System.out.println("고객님은 " + badge.getName(badge) +" 배지를 획득 하셨습니다!");
            System.out.println("이후에 진행 될 새해 이벤트에서 배지에 따른 선물이 증정됩니다.");
        }
    }

    public static void printWeekDayDiscountAnnouncement() {
        System.out.println("평일 할인이 적용됩니다!");
        System.out.println("10,000원 이상 주문하면 모든 디저트메뉴 2023원 할인");
    }

    public static void printWeekendDiscountAnnouncement() {
        System.out.println("주말 할인이 적용됩니다!");
        System.out.println("10,000원 이상 주문하면 모든 메인메뉴 2023원 할인");
    }
}
