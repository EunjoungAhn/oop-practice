package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 요구사항
 * • 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
 * • MVC패턴(Model-View-Controller) 기반으로 구현한다.
 * • 일급 컬렉션 사용
 *
 * 1. 도메인을 구성하는 객체에는 어떤 것들이 있는지 고민
 * 2. 객체들 간의 관계를 고민
 * 3. 동적인 객체를 정적인 타입으로 추상화해서 도메인 모델링 하기
 * 4. 협력을 설계
 * 5. 객체들을 포괄하는 타입에 적절한 책임을 할당
 * 6. 구현하기
 */
public class GradeCalculatorTest {
    // 1.학점계산기 도메인 : 이수한 과목, 학점 계산기

    // 3. 이수한 과목: 객체지향프로그래밍 수업, 자료구조 수업 등 --> 과목(코스) 라는 클래스로 만들 수 있다.

    //4. 이수한 과목을 전달하여 평균학점 계산 요청 --> 학점 계산기 --> (학점수×교과목 평점)의 합계 --> 과목(코스)에게 요구 가능
    //                                                    --> 수강신청 총학점 수 --> 과목(코스)에게 요구 가능

    //테스트 코드를 미리 작성하는 이유는 메서드 안에 기능을 작성했을때 로직이 잘 작동하는지 확인하기 위해서 미리 작성한다.
    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest() {
        List<Course> courses = List.of(new Course("OOP", 3, "A+"), new Course("자료구조", 3, "A+"));

        //이수한 과목을 전달받고, 성적을 계산해 달라고 요청
        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        double gradeResult = gradeCalculator.calculateGrade();

        assertThat(gradeResult).isEqualTo(4.5);
    }
}
