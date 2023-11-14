package christmas.view;

import christmas.ChristmasBadge;
import christmas.MenuBoard;
import christmas.OrderedAmount;
import christmas.UserOrder;

public class OutputView {

    public static void startMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public static void menuAndAmount(MenuBoard menuBoard) {
        System.out.println(menuBoard);
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public static void badgeAnnouncement(ChristmasBadge badge) {
        if (badge != ChristmasBadge.NO_BADGE) {
            System.out.println("고객님은 " + badge.getName(badge) + " 배지를 획득 하셨습니다!");
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
        System.out.println("10000원 이상 주문 하면 총금액에서 " + discount + "원 할인");
    }

    public static void totalAmount() {
        System.out.println("<할인 전 총주문 금액>");
        OrderedAmount orderedAmount = OrderedAmount.getOrderedAmount();
        System.out.println(orderedAmount.totalAmount());
        System.out.println();
    }

    public static void present(String present) {
        System.out.println("<증정 메뉴>");
        if (present.length() != 0) {
            System.out.println(present);
            System.out.println();
            return;
        }
        System.out.println("없음");
    }

    public static void totalDiscount() {
        System.out.println("<총혜택 금액>");
        OrderedAmount orderedAmount = OrderedAmount.getOrderedAmount();
        System.out.println(orderedAmount.totalDiscount());
    }

    public static void printSpecialDiscountAnnouncement() {
        System.out.println("특별 할인 이벤트가 적용됩니다!");
        System.out.println("총 주문 금액에서 1000원 할인");
    }

    public static void orderContent(UserOrder userOrder) {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        System.out.println("<주문 메뉴>");
        System.out.println(userOrder);
    }

    public static void discountHistory(String discount) {
        System.out.println("<혜택 내역>");
        if (discount.length() != 0) {
            System.out.println(discount);
            return;
        }
        System.out.println("없음");
    }

    public static void afterDiscount(String afterDiscount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(afterDiscount);
    }

    public static void grantedBadge(ChristmasBadge badge) {
        System.out.println("<12월 이벤트 배지>");
        if (badge.toString().equals("NO_BADGE")) {
            System.out.println("없음");
            return;
        }
        System.out.println(badge);
    }

}
