package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class Benefit {
    private final List<String> ownBenefit = new ArrayList<>();

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
