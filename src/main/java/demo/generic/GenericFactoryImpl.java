package demo.generic;

/**
 * @author Coder编程
 * @Title: GenericFatory
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/16 15:14
 */
public class GenericFactoryImpl<T,N> implements GenericFactory<T,N> {
    @Override
    public T nextObject() {
        return null;
    }

    @Override
    public N nextNumber() {
        return null;
    }
}
