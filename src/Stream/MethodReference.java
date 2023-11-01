package Stream;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {
    public static void main(String[] args) {

      /*  Function<String,Integer> f =(String s) -> Integer.parseInt(s);
        System.out.println(f.apply("100")+100);
        f=Integer::parseInt;
        System.out.println(f.apply("200"));*/
        
        
        //Supplier는 입력 x,출력 o
        Supplier<MyClass> s=() -> new MyClass();
        MyClass myClass = s.get();

        System.out.println(myClass);//밑에와 서로 다른 객체
        System.out.println(s.get());//

        Supplier<MyClass> s2=MyClass::new;
        System.out.println(s2.get());

        //Function 으로 생성자 초기화를 한후 해당 필드 반환
        //람다식
        Function<Integer,MyClass2> s3=(a) -> new MyClass2(a);
        System.out.println(s3.apply(100).i);
        //메소드 참조로 바꾸면
        Function<Integer,MyClass2> s4=MyClass2::new;
        System.out.println(s4.apply(100).i);

        //배열 메소드 참조 배열의 배열의 길이를 입력해야 하고 배열을 반환 받아야 하기 때문에 Function을 씀
        Function<Integer,int[]> f=(i) -> new int[i];
        //길이가 100인 배열 반환
        System.out.println(f.apply(100));
        //배열 메소드 참조
        Function<Integer,int[]> f1=int[]::new;
        System.out.println(f1.apply(100).length);
    }
}
class MyClass
{

}
class MyClass2
{
    int i;
    MyClass2(int a)
    {
        this.i=a;
    }

}