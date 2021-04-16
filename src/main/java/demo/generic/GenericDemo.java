package demo.generic;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Coder编程
 * @Title: GenericDemo
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/16 13:27
 */
@Slf4j
public class GenericDemo {

    public static void handlerMember(GenericClassExample<? super Integer> integerGenericClassExample){
        Integer result = (Integer) integerGenericClassExample.getMember() + 2;
        log.info("result is: {}",result);
    }

    public static void main(String[] args) {
        GenericClassExample<String> stringGeneric = new GenericClassExample<>("abc");
        GenericClassExample<Number> integerGeneric = new GenericClassExample<>(1);

        //泛型类型只会在编译期进行限制，并不会进入到运行期（泛型擦除）
        //进一步测试，可以通过命令行反编译查看
        System.out.println(stringGeneric.getClass());
        System.out.println(integerGeneric.getClass());

        handlerMember(integerGeneric);
        //handlerMember(stringGeneric);

        Integer[] integers = {1,2,3,4,5,6};
        Double[] doubles = {1.1,2.2,3.3,4.4,5.5,6.6};
        Character[] characters = {'A','B','C'};

        GenericClassExample.printArray(integers);
        GenericClassExample.printArray(doubles);
        GenericClassExample.printArray(characters);
    }
}
