package christmas.domain;

import java.util.List;

public enum ChristmasBadge {
    SANTA(20000, "산타"),
    TREE(10000, "트리"),
    STAR(5000, "별"),
    NO_BADGE(0, "");

    private final int point;
    private final String badgeName;

    ChristmasBadge(int point, String badgeName) {
        this.point = point;
        this.badgeName = badgeName;
    }

    public static ChristmasBadge getBadge(int point) {
        List<ChristmasBadge> badges = List.of(ChristmasBadge.values());
        return badges.stream()
                .filter(badge -> badge.point == point)
                .findFirst()
                .orElse(NO_BADGE);
    }

    public String getName(ChristmasBadge badge) {
        return badge.badgeName;
    }
}
