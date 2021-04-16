package demo.generic;

import lombok.Data;

/**
 * @author Coder编程
 * @Title: GenericClassExample
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/16 13:19
 */
@Data
public class GenericClassExample<T> {

    /**member这个成员变量的类型为T,T的类型由外部指定*/
    private T member;

    /**泛型构造方法形参member的类型为T,T的类型由外部指定*/
    public GenericClassExample(T member){
        this.member = member;
    }

    public T handlerSomething(T target){
        return target;
    }

    public String sayHello(String name){
        return "haha,"+name;
    }


    public static <E> void printArray(E[] inputArray){
        for (E element : inputArray){
            System.out.printf("%s",element);
            System.out.printf(" ");
        }
        System.out.println();
    }
}
