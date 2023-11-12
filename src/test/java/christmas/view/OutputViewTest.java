package christmas.view;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.ChristmasBadge;
import christmas.GrantBadge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    @Test
    @DisplayName("배지를 획득하면 안내 문구를 출력")
    void badgeAnnouncement_SANTA() {
        GrantBadge grantBadge = new GrantBadge();
        ChristmasBadge christmasBadge = grantBadge.grantedBadge(20000);

        assertThat(christmasBadge.getName(christmasBadge)).isEqualTo("산타");
    }

    @Test
    @DisplayName("배지를 획득하지 못하면 아무것도 출력하지 않는다.")
    void badgeAnnouncement_No_Badge() {
        GrantBadge grantBadge = new GrantBadge();
        ChristmasBadge christmasBadge = grantBadge.grantedBadge(4999);
        assertThat(christmasBadge.getName(christmasBadge)).isEqualTo("");
    }
}
