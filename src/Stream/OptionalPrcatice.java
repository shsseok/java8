package Stream;

import java.util.Optional;

public class OptionalPrcatice {
    public static void main(String[] args) {
    String str="abc";
    Optional<String> optional1 = Optional.of(str);
    Optional<String> optional2 = Optional.of("abc");
    //Optional<String> optional3=Optional.of(null);
    Optional<String> optional4=Optional.ofNullable("ㅁㄴㅇㅁㄴㅇ");

    Optional<String> optional5=Optional.empty();
        System.out.println(optional1);
        System.out.println(optional2);
       // System.out.println(optional3);
        System.out.println(optional4);
        String str1=optional4.orElse("dddd"); //Null일 때는 무엇을 가지고 올래? (파라미터 값)
        System.out.println(str1);
        String str2=optional4.orElseGet(()->new String()); //--Suplier 람다식 사용가능
        System.out.println(str2);

        optional4.ifPresent(System.out::println); //널이 아닐떄만 안에 작업을 수행하도록한다. null이라면 아무일도안한다.
        int result2=Optional.of("12345")
                .filter(x->x.length()>0)
                .map(Integer::parseInt)
                .orElse(-1);
    }
}
