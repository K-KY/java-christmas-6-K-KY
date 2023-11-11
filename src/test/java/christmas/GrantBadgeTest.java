package christmas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GrantBadgeTest {
    @Test
    @DisplayName("5000원은 별 배지")
    void grantBadgeStarTest() {
        GrantBadge grantBadge = new GrantBadge();
        assertThat(grantBadge.grantedBadge(5000).name()).isEqualTo(ChristmasBadge.STAR.name());
    }
    @Test
    @DisplayName("10000원은 트리 배지")
    void grantBadgeTreeTest() {
        GrantBadge grantBadge = new GrantBadge();
        assertThat(grantBadge.grantedBadge(10000).name()).isEqualTo(ChristmasBadge.TREE.name());
    }

    @Test
    @DisplayName("20000원은 산타")
    void grantBadgeSantaTest() {
        GrantBadge grantBadge = new GrantBadge();
        assertThat(grantBadge.grantedBadge(20000).name()).isEqualTo(ChristmasBadge.SANTA.name());
    }

    @Test
    @DisplayName("배지를 획득하면 안내 문구를 출력")
    void grantBadgePrintTest() {
        GrantBadge grantBadge = new GrantBadge();
        ChristmasBadge christmasBadge = grantBadge.grantedBadge(20000);

        assertThat(christmasBadge.getName(christmasBadge)).isEqualTo("산타");
    }


}