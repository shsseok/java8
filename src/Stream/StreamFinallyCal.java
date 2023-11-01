package Stream;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamFinallyCal {
    public static void main(String[] args)
    {
    String[] strArr = {
            "Inheritance", "Java","Lambda","Stream",
            "OptionalDouble","IntStream","count","sum"

    };
    Stream.of(strArr).forEach(System.out::println); //foreach연산
        //만약에 병렬로 처리하고 싶다면?
        Stream.of(strArr).parallel().forEach(System.out::println); //--> 이런식으로 사용 매번 순서가 바뀐다 왜?
        // 서로다른 스레드가 찍어주고 있기 때문에 하지만 순서를 보장하고 싶다면 forEachOrdered 사용
        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() ==0); // 일치하는 것이 하나도 없다면  없으니깐 true
        boolean noStr1 = Stream.of(strArr).allMatch(s -> s.length() > 2); // 모든 요소가 ok?  길이가 2가 다 넘기 때문에 true
        boolean noStr2 = Stream.of(strArr).anyMatch(s -> s.length() < 4); // sum은 길이가 4보다 작으니깐 true
        System.out.println("noEmptyStr="+noEmptyStr);
        System.out.println("noStr1 = " + noStr1);
        System.out.println("noStr2 = " + noStr2);

        Optional<String> sWord =Stream.of(strArr).filter(s -> s.charAt(0) =='s').findFirst();
        System.out.println("sWord.get() = " + sWord.get());
    }
}
