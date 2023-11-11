package christmas;

public class GrantBadge {
    public ChristmasBadge grantedBadge(int point) {
        ChristmasBadge badge = ChristmasBadge.getBadge(point);
        badgeAnnouncement(badge);
        return badge;
    }

    private void badgeAnnouncement(ChristmasBadge badge) {
        if (badge != ChristmasBadge.NO_BADGE) {
            System.out.println("고객님은 " + badge.getName(badge) +" 배지를 획득 하셨습니다!");
            System.out.println("이후에 진행 될 새해 이벤트에서 배지에 따른 선물이 증정됩니다.");
        }
    }
}