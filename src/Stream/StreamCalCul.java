package Stream;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamCalCul {
    public static void main(String[] args) {
    /*    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intStream = list.stream();
        intStream.forEach(System.out::println);
        Stream<String> stringStream=Stream.of(new String[]{"a","b","c"});
        stringStream.sorted(String::compareTo);*/

        Stream<File> fileStream=Stream.of(new File("ex1.java"),new File("ex1"),new File("Ex1.bak"));
        Stream<String> filenameStream = fileStream.map(File::getName);
        filenameStream.forEach(System.out::println);


        Stream<File> fileStream1=Stream.of(new File("ex1.java"),new File("ex1"),new File("Ex1.bak"));
        fileStream1.map(File::getName)
                .filter((s) -> s.indexOf(".")!=-1)
                .peek(s ->System.out.println("filename:"+s))
                .map(d->d.substring(d.indexOf('.')+1))
                .map((d)->d.toUpperCase())
                .distinct()
                .forEach(System.out::println);
    }
}