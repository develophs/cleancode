package sample.variable;

import java.util.ArrayList;
import java.util.List;

/**
 * 변수명을 보면 바로 해당 변수가 무슨 의미를 가지는지 파악하기 쉽게 작성해야한다.
 *
 * 작성자만 알 수 있는 약자를 사용하지 말자
 * 주석은 해결책이 아니다.
 * 역할을 설명할 수 있는 명확한 단어를 쓰자.
 */
public class Intention {

    void bad(){
        // 변수명을 대충 작성하면 해당 변수가 어떤 의미, 의도를 파악할 수 없다.
        String d = "";
        
        System.out.println("어떤 의도로 해당 변수를 작성한것인가");

        // 어떤 의미를 가진 문자열의 배열인가.
        String[] stringArray = {"a", "b", "c"};

    }

    void good(){
        // 해당 변수가 선택된 날짜인 것을 파악할 수 있다.
        List<String> selectedDates = new ArrayList<>();

        // 강의 코드 :
        // List <String> selectedMonths = selectedDates.stream().map(data -> data.getMonth()).collect(Collectors.toList());

        // 의미가 정확한 문자열 배열: 댓글 목록
        String[] replyComments = {"a" , "b" , "c"};
    }
}
