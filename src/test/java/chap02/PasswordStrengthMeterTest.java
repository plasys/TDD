package chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {

    // 여러 테스트 메서드에서 사용하는 객체를 필드에서 생성하도록 함
    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    // 암호 강도 측정 기능 실행, 확인 메서드
    private void assertStrength(String password, PasswordStrength expStr) {

        PasswordStrength result = meter.meter(password);

        assertEquals(expStr, result);

    }

    // 모든 조건을 만족시켰을 때
    @Test
    void meetsAllCriteria_Then_Strong() {

        assertStrength("ab12!@AB", PasswordStrength.STRONG);

        assertStrength("abc1!Add", PasswordStrength.STRONG);

    }

    // 길이를 제외한 다른 조건을 만족시켰을 때
    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {

        assertStrength("ab12!@A", PasswordStrength.NORMAL);

        assertStrength("Ab12!c", PasswordStrength.NORMAL);
    }

    // 숫자가 없는 경우를 제외한 다른 조건을 만족시켰을 때
    @Test
    void meetsOtherCritera_except_for_number_Then_Normal() {

        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);

    }
}