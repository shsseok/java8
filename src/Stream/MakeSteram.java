import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//스트림 이란
//데이터소스 스트림을 통해서 중간작업 최종작업 처리 -->데이터의 연속적인 흐름이다.
//1.스트림 만들기
//2.중간 연산(0~n)
//3.최종 연산(0~1)
//스트림을 쓰는 이유
//1.원본은 건드리지 않고 원본을 가지고 작업만 할 뿐이다.
//2.일회용 이다. 한번사용하고 나면 다시 스트림을 생성해야함 최종연산을 하면 스트림 닫음.
//3. 최종 연산전까지 중간연산이 수행되지 않는다 --> 지연된 연산이 가능.
//4.스트림은 작업을 내부 반복으로 처리한다.foreach
//5.스트림의 작업을 병렬로 처리 -->병렬 스트림 (멀티 스트림)
//6 기본형 스트림 IntStream DoubleStreaam 등등
//Arrays--> 배열을 다루기 위한 편리한 메서드를 제공 static으로 되어져있다 --> 찾아보면서 사용
public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> integerStream=list.stream();
        integerStream.forEach(System.out::print);
        //integerStream.forEach(System.out::print);-->여기서는 최종연산을 위에 한번했기 때문에 오류가 난다. 스트림이 닫히기 때문에
        integerStream=list.stream();
        integerStream.forEach(System.out::print);

       Stream<String> strStream = Stream.of("a","b","c");
       strStream.forEach(System.out::println);

        int[] intArr={1,2,3,4,5};
        IntStream intStream=Arrays.stream(intArr);
        //System.out.println("count="+intStream.count());//최종연산
        System.out.println("sum="+intStream.sum());

        Integer[] intArr2 = {1,2,3,4,5};
        Stream<Integer> intStream2 =Arrays.stream(intArr2);
           // intStream.forEach(System.out::println);
            System.out.println("count="+intStream2.count());


            //람다식 스트림 --> 중요 iterate() generate() 얘네는 무한 스트림이다. iterator은 이전 요소에 종속적 seed들어감 초기값
            //generate는 이전 요소에 독립적이다 seed사용 x
            //람다식을 소스로하는 스트림 생성하기

            Stream<Integer> intStream3=Stream.iterate(0,n -> n+2);
            intStream3.limit(10)
                    .forEach(System.out::println);
            //generate(Supplier s) : 주기만 하는 것 입력 x 출력만 o
            Stream<Integer> oneStream =Stream.generate(()->1);
            oneStream.limit(10).forEach(System.out::println);
    }
}