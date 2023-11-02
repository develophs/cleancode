package sample.function;

/**
 * PureFunction의 정의
 * 1. 특정 input값에 대한 output 값이 항상 같아야한다.
 * 2. 부수효과(Side Effect)가 없어야한다.
 * >> 외부 환경이 메소드 내부에 영향이 미치지 않게 한다.
 *
 * Side Effect:
 * 메소드 내부에 생긴 변화가 메소드 밖에 영향을 미치지 않게한다.
 */
public class PureFunction {
    private static int outerValue = 10;

    public static void main(String[] args) {
        // 두 메소드는 outerValue의 값에 파라미터로 넘어온 값을 받아 출력한다.
        impure(3); // 13
        otherImpure(3); // 13

        // 여기서 outerValue의 값을 변경해 impure 메소드의 출력값만 변경하려 하면
        // otherImpure()의 출력값도 의도치 않게 변경된다.

        // 함수에서 사용하는 값은 외부에서 참조하는게 아닌 파라미터로 받는다.
        // outerValue의 값을 바꿔도 pure 메소드의 출력값은 변하지 않는다.
        pure(3, 100); // 103

        // sideEffect() 메소드는 함수 외부에 영향을 미친다.
        // 똑같은 sideEffect(3), impure(3)을 호출해도 출력값이 변한다.
        sideEffect(3); //13
        impure(3); //14
        sideEffect(3); //14
        impure(3); //15
    }

    public static void impure(int value) {
        System.out.println(value + outerValue);
    }

    public static void otherImpure(int value) {
        System.out.println(value + outerValue);
    }

    public static void pure(int value, int pureValue) {
        System.out.println(value + pureValue);
    }

    public static void sideEffect(int value) {
        System.out.println(value + outerValue);
        outerValue++;
    }

    public static void impureLogin(String password) {
        // impureCheckPassword 메소드를 수행하면서 비밀번호 체크 및 세션관리를 한다.
        // 이렇게 되면 비밀번호 체크 로직이 변경되면 세션관련 로직도 영향을 받게 된다.
        boolean isTrue = impureCheckPassword(password);

        if (isTrue) System.out.println("로그인 성공");
    }

    public static boolean impureCheckPassword(String password) {
        if ("password".equals(password)) {
            // 부수효과를 발생시킨 후 true를 반환
            session();
            return true;
        }
        return false;
    }

    // 부수효과를 제거하고, 퓨어함수는 단일 책임 원칙을 지킬 수 있다.
    // 비밀번호 체크 로직과 세션 로직 분리
    // 메소드 내부 로직에 의해 메소드 이름에 XAndY로 명명되면 의심을 해보자.
    public static void pureLogin(String password) {
        boolean isTrue = pureCheckPassword(password);

        if (isTrue) {
            session();
            System.out.println("로그인 성공");
        }
    }

    public static boolean pureCheckPassword(String password) {
        return "password".equals(password);
    }

    public static void session() {
        System.out.println("Session");
    }
}
