package demo.generic;

/**
 * @author Coder编程
 * @Title: GenericFatory
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/16 14:53
 */
public interface GenericFactory<T,N> {

    T nextObject();

    N nextNumber();
}
