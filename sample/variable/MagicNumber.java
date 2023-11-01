package sample.variable;

/**
 * MagicNumber 금지!
 */
public class MagicNumber {

    public enum CoinCode{
        BITCOIN("BTC"),
        DOZY("D");

        private String code;

        CoinCode(String code) {
            this.code = code;
        }

        public String getCode(){
            return this.code;
        }
    }
    void bad() {
        int commentsLength = 0;

        if (commentsLength > 140) {
            throw new IllegalStateException("140이 무슨 의미가 있길래 예외를 발생시키는가");
        }

        if (commentsLength > 140) {
            System.out.println("140의 값을 여러곳에서 사용할 경우");
        }

        if (commentsLength > 140) {
            System.out.println("140이 하드코딩 되어있는 모든 코드를 수정해야한다.");
        }

        // 리스트 또는 배열이 존재하는 경우
        // 인덱스에 해당하는 값이 무엇인지 판단하기 힘들다.
        String[] cities = {"a" , "b" , "c"};
        String city = cities[0];

        if(city.equals("BTC")){
            System.out.println("BTC가 무슨 의미인가.");
        }
    }

    void good() {
        int commentsLength = 0;
        int commentsLimitCount = 140;
        // int commentsLimitCount = 280; 댓글의 제한 수가 280으로 증가하게 되면 해당 변수의 값만 변경하면 된다.

        if (commentsLength > commentsLimitCount){
            throw new IllegalStateException("140의 의미가 댓글의 최대 갯수임을 알 수 있다.");
        }

        if (commentsLength > commentsLimitCount){
            System.out.println("매직 넘버를 변수로 선언함에 따라 변수의 값만 변경하면된다.");
        }

        // 리스트나 배열의 인덱스에 접근할 때에도 매직 넘버를 사용하지 않고,
        // 인덱스에 의미를 부여해준다.
        int currentCityIdx = 0;
        String[] cities = {"a" , "b" , "c"};
        String currentCity = cities[currentCityIdx];

        String bitcoinCode = "BTC";
        if (currentCity.equals(bitcoinCode)){
            // 하드코딩된 매직 넘버, 매직 문자보다 의미있는 변수와 비교함으로써 의도를 파악하기 쉽다.
        }

        // 값이 여러개인 경우에는 enum을 사용할 수 있다.
        if(currentCity.equals(CoinCode.BITCOIN.getCode())){
            //의도를 파악하기 쉽다.
        }

    }

}
