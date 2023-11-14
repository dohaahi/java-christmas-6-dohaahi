package christmas.domain.promotion;

public enum Badge {
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000),
    NONE("없음", 0);
    private final String name;
    private final int minDiscountAmount;

    Badge(final String name, final int minDiscountAmount) {
        this.name = name;
        this.minDiscountAmount = minDiscountAmount;
    }

    public String getName() {
        return name;
    }

    public int getMinDiscountAmount() {
        return minDiscountAmount;
    }
}