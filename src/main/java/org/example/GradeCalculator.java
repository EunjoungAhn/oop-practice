package org.example;

import java.util.List;

public class GradeCalculator {
    //일급 콜렉션 사용하기
    private final Courses courses;

    // 위의 Courses 클래스로 이동
    // private final List<Course> course;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    /**
    * 요구사항
     * • 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
     * • MVC패턴(Model-View-Controller) 기반으로 구현한다.
     * • 일급 컬렉션 사용
     */
    public double calculateGrade() {
        //학점수x교과목 평균 = 합계
        double totalMultipledCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();
        // 수강신청 총학점 수
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();

        return totalMultipledCreditAndCourseGrade / totalCompletedCredit;
    }
}
