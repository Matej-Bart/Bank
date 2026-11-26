package currency;

public enum Currency {
    CZK(1.0),
    EUR(24.30),
    USD(22.50);

    // kolik CZK stojí jedna jednotka měny (pevné ukázkové kurzy)
    private final double rateToCzk;

    Currency(double rateToCzk) {
        this.rateToCzk = rateToCzk;
    }

    public double getRateToCzk() {
        return rateToCzk;
    }
}
