package demo.generic;

import java.util.Random;

/**
 * @author Coder编程
 * @Title: RobotFactory
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/16 14:55
 */
public class RobotFactory implements GenericFactory<String,Integer>{

    private String[] stringRobot = new String[]{"hello","hi"};

    private Integer[] integerRobot = new Integer[]{111,222};

    @Override
    public String nextObject() {
        Random random = new Random();

        return stringRobot[random.nextInt(2)];
    }

    @Override
    public Integer nextNumber() {

        Random random = new Random();

        return integerRobot[random.nextInt(2)];
    }

    public static void main(String[] args) {
        GenericFactory<String,Integer> factory = new RobotFactory();

        System.out.println(factory.nextObject());
        System.out.println(factory.nextNumber());
    }
}
