package org.example;

public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator){
        /* as-is 방식
        해당 방식은 내부에서 작성되어서 결합도가 높다!
        계속해서 비밀번호가 랜덤으로 만들어져서 테스트가 통과 혹은 실패가 된다.
        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        String randomPassword = randomPasswordGenerator.generatePassword(); */

        // to-be 방식
        //그래서 외부(인터페이스)에서 값을 받아온다. 그러므로 겹합도를 느슨하게 만들었다.
        String password = passwordGenerator.generatePassword();
        /**
         * 비밀번호 최소 8자 이상 12자 이하여야 한다.
         */
        if(password.length() >= 8 && password.length() <= 12){
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
