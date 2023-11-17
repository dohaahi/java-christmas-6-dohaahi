package christmas.domain.promotion;

public class BadgePromotion {
    public Badge getBadge(final int totalDiscountAmount) {
        return matchBadgeFrom(totalDiscountAmount);
    }

    private Badge matchBadgeFrom(final int totalDiscountAmount) {
        if (totalDiscountAmount >= Badge.SANTA.getMinDiscountAmount()) {
            return Badge.SANTA;
        }

        if (totalDiscountAmount >= Badge.TREE.getMinDiscountAmount()) {
            return Badge.TREE;
        }

        if (totalDiscountAmount >= Badge.STAR.getMinDiscountAmount()) {
            return Badge.STAR;
        }

        return Badge.NONE;
    }
}