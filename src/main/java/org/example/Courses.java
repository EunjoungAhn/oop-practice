package org.example;

import java.util.List;

public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        double multipliedCreditAndCourseGrade = 0;
        for(Course course: courses){
            //응집도가 낮다, 이 코드를 여러군데에서 사용한다면, 사용한 곳 마다 다 바꾸어 주어야 한다.
//           multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade(); //객체에게 작업을 위임해서 처리하도록 수정
        }
        return multipliedCreditAndCourseGrade;
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
