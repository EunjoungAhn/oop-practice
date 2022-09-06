package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    @DisplayName("패스워드 초기화한다.")
    @Test
    void passwordTest() {
        //given
        User user = new User();

        //when
        //user.initPassword(new CorrectFixedPasswordGenerator());
        user.initPassword(() -> "abcdefgh"); //PasswordGenerator에 @FunctionalInterface을 적용하여서 람다 가능

        //then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사항에 부합되지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2() {
        //given
        User user = new User();

        //when
        //user.initPassword(new WrongFixedPasswordGenerator());
        //구현체를 만들 필요 없지 적용
        user.initPassword(() -> "ab"); //PasswordGenerator에 @FunctionalInterface을 적용하여서 람다 가능

        //then
        assertThat(user.getPassword()).isNull();
    }
}