package lotto.domain;

public class PurchaseAmount {

  private static final int LOTTO_PRICE = 1000;
  public static final String INVALID_PURCHASE_AMOUNT_MESSAGE = "구입 금액은 1000원 단위로 입력해주세요.";

  private final int value;

  public PurchaseAmount(int value) {
    validate(value);
    this.value = value;
  }

  private void validate(int value) {
    if (value <= 0 || value % LOTTO_PRICE != 0) {
      throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_MESSAGE);
    }
  }

  public int getLottoCount() {
    return value / LOTTO_PRICE;
  }

  public double getYield(double other) {
    return other / value;
  }
}
