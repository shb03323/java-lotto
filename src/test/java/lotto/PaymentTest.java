package lotto;

import lotto.domain.Payment;
import lotto.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PaymentTest {
    @DisplayName("구입한 로또의 개수는 (구입 금액 / 로또 개당 가격)과 일치한다.")
    @Test
    void createPaymentAndGetLottoAmountSuccess() {
        Payment payment = new Payment(10000);
        assertThat(payment.getAvailableLottoAmount()).isEqualTo(10);
    }

    @DisplayName("지불 가격이 로또 가격에 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createPaymentByInvalidPrice() {
        assertThatThrownBy(() -> new Payment(10020))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_PURCHASE_PRICE.getMessage());
    }
}
