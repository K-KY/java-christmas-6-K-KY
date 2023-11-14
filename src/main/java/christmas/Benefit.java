package christmas;

import java.util.ArrayList;
import java.util.List;

public class Benefit {
    private static final List<String> ownBenefit = new ArrayList<>();
    private static Benefit benefit;

    private Benefit() {

    }

    public static Benefit getBenefit() {
        if (benefit == null) {
            benefit = new Benefit();
        }
        return benefit;
    }

    public void addBenefit(String benefit) {
        ownBenefit.add(benefit);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ownBenefit.forEach(benefits -> stringBuilder.append(benefits).append("\n"));
        return stringBuilder.toString();
    }
}
