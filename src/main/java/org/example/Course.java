package org.example;

public class Course {
    private final String subject; //과목명
    private final int credit;   //학점
    private final String grade; //성적

    public Course(String subject, int create, String grade) {
        this.subject = subject;
        this.credit = create;
        this.grade = grade;
    }

    //getter을 이용하는 방식이 아닌 직접 수행.
    public double multiplyCreditAndCourseGrade() {
        return credit * getGradeToNumber();
    }

    public int getCredit() {
        return credit;
    }

    public double getGradeToNumber() {
        double grade = 0;
        switch (this.grade) {
            case "A+":
                grade = 4.5;
                break;
            case "A":
                grade = 4.0;
                break;
            case "B+":
                grade = 3.5;
                break;
            case "B":
                grade = 3.0;
                break;
            case "C+":
                grade = 2.5;
                break;
            case "C":
                grade = 2.0;
                break;
            case "D+":
                grade = 1.5;
                break;
            case "D":
                grade = 1.0;
                break;
            case "F":
                grade = 0.0;
                break;
        }

        return grade;
    }


}
