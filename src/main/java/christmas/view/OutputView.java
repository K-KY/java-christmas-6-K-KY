package christmas.view;

import christmas.domain.ChristmasBadge;
import christmas.domain.orderinfo.Date;
import christmas.domain.MenuBoard;
import christmas.domain.orderinfo.UserOrder;

public class OutputView {

    private static final String GREETING = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String VISIT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ORDER_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String CUSTOMER = "고객님은 ";
    private static final String GET_BADGE = " 배지를 획득 하셨습니다!";
    private static final String PRESENT_NEXT_EVENT = "이후에 진행 될 새해 이벤트에서 배지에 따른 선물이 증정됩니다.";
    private static final String WEEKDAY_DISCOUNT = "평일 할인이 적용됩니다!";
    private static final String THIS_YEAR = "2023";
    private static final String DESSERT_DISCOUNT = "10,000원 이상 주문하면 모든 디저트메뉴 " + THIS_YEAR + "원 할인";
    private static final String WEEKEND_DISCOUNT = "주말 할인이 적용됩니다!";
    private static final String MAIN_MENU_DISCOUNT = "10,000원 이상 주문하면 모든 메인메뉴 " + THIS_YEAR + "원 할인";
    private static final String CHRISTMAS_DISCOUNT = "크리스마스 디데이 할인이 적용됩니다!";
    private static final String IF_ORDER_TEN_THOUSAND = "10000원 이상 주문 하면 총금액에서 ";
    private static final String DISCOUNT = "원 할인";
    private static final String BEFORE_DISCOUNT = "<할인 전 총주문 금액>";
    private static final String PRESENT_MENU = "<증정 메뉴>";
    private static final String NONE = "없음\n";
    private static final String TOTAL_BENEFIT = "<총혜택 금액>";
    private static final String SPECIAL_DISCOUNT = "특별 할인 이벤트가 적용됩니다!";
    private static final String DISCOUNT_THOUSAND = "총 주문 금액에서 1000원 할인";
    private static final String BENEFIT_PREVIEW = "12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDERED_MENU = "<주문 메뉴>";
    private static final String DISCOUNT_HISTORY = "<혜택 내역>";
    private static final String AFTER_DISCOUNT = "<할인 후 예상 결제 금액>";
    private static final String DECEMBER_EVENT_BADGE = "<12월 이벤트 배지>";
    private static final int NO_DISCOUNT = 0;

    public static void startMessage() {
        System.out.println(GREETING);
        System.out.println(VISIT_DATE);
    }

    public static void menuAndAmount(MenuBoard menuBoard) {
        System.out.println(menuBoard);
        System.out.println(ORDER_MENU);
    }

    public static void badgeAnnouncement(ChristmasBadge badge) {
        if (badge != ChristmasBadge.NO_BADGE) {
            System.out.println();
            System.out.println(CUSTOMER + badge.getName() + GET_BADGE);
            System.out.println(PRESENT_NEXT_EVENT);
        }
    }

    public static void printWeekDiscountAnnouncement(boolean weekend) {
        if (weekend) {
            printWeekendDiscountAnnouncement();
            System.out.println();
            return;
        }
        printWeekDayDiscountAnnouncement();
    }

    public static void printWeekDayDiscountAnnouncement() {
        System.out.println(WEEKDAY_DISCOUNT);
        System.out.println(DESSERT_DISCOUNT);
        System.out.println();
    }

    public static void printWeekendDiscountAnnouncement() {
        System.out.println(WEEKEND_DISCOUNT);
        System.out.println(MAIN_MENU_DISCOUNT);
    }

    public static void printChristMasDiscountAnnouncement(Date date) {
        if (date.isBeforeChristmas()) {
            System.out.println(CHRISTMAS_DISCOUNT);
            System.out.println(IF_ORDER_TEN_THOUSAND + date.discount() + DISCOUNT);
            System.out.println();
        }
    }

    public static void totalAmount(String totalAmount) {
        System.out.println(BEFORE_DISCOUNT);
        System.out.println(totalAmount);
        System.out.println();
    }

    public static void present(String present) {
        System.out.println(PRESENT_MENU);
        if (present.length() != NO_DISCOUNT) {
            System.out.println(present);
            System.out.println();
            return;
        }
        System.out.println(NONE);
    }

    public static void totalDiscount(String totalDiscount) {
        System.out.println(TOTAL_BENEFIT);
        System.out.println(totalDiscount);
        System.out.println();
    }

    public static void printSpecialDiscountAnnouncement(boolean stared) {
        if (stared) {
            System.out.println(SPECIAL_DISCOUNT);
            System.out.println(DISCOUNT_THOUSAND);
            System.out.println();
        }
    }

    public static void orderContent(UserOrder userOrder) {
        System.out.println(BENEFIT_PREVIEW);
        System.out.println(ORDERED_MENU);
        System.out.println(userOrder);
    }

    public static void discountHistory(String discount) {
        System.out.println(DISCOUNT_HISTORY);
        if (discount.length() != NO_DISCOUNT) {
            System.out.println(discount);
            return;
        }
        System.out.println(NONE);
    }

    public static void afterDiscount(String afterDiscount) {
        System.out.println(AFTER_DISCOUNT);
        System.out.println(afterDiscount);
        System.out.println();
    }

    public static void grantedBadge(ChristmasBadge badge) {
        System.out.println(DECEMBER_EVENT_BADGE);
        if (badge.isBadge()) {
            System.out.println(NONE);
            return;
        }
        System.out.println(badge.getName());
        badgeAnnouncement(badge);
    }

}
