package christmas;

import java.util.List;

public enum ChristmasBadge {
    SANTA(20000),
    TREE(10000),
    STAR(5000),
    NO_BADGE(0);

    private final int point;

    ChristmasBadge(int point) {
        this.point = point;
    }

    public static ChristmasBadge getBadge(int point) {
        List<ChristmasBadge> badges = List.of(ChristmasBadge.values());
        return badges.stream()
                .filter(badge -> badge.point == point)
                .findFirst()
                .orElse(NO_BADGE);
    }
}
