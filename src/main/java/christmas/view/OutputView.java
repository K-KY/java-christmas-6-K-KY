package christmas.view;

import christmas.ChristmasBadge;
import christmas.MenuCategory;

public class OutputView {

    public static void startMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

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

    public static void printChristMasDiscountAnnouncement(int discount) {
        System.out.println("크리스마스 디데이 할인이 적용됩니다!");
        System.out.println("10000원 이상 주문 하면 총금액에서 " + discount +"원 할인");
    }

    public static void printSpecialDiscountAnnouncement() {
        System.out.println("특별 할인 이벤트가 적용됩니다!");
        System.out.println("총 주문 금액에서 1000원 할인");
    }
}
