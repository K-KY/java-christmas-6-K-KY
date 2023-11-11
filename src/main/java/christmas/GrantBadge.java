package christmas;

import christmas.view.OutputView;

public class GrantBadge {
    public ChristmasBadge grantedBadge(int point) {
        ChristmasBadge badge = ChristmasBadge.getBadge(point);
        OutputView.badgeAnnouncement(badge);
        return badge;
    }
}