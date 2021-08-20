package proxy.dynamic.cglib;


import net.sf.cglib.proxy.Enhancer;

public class Main {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件
        enhancer.setSuperclass(Tank.class);
        //设置回调函数
        enhancer.setCallback(new MyMethodInterceptor());

        //这里的creat方法就是正式创建代理类
        Tank m = (Tank) enhancer.create();
        m.move();
        m.go();
    }
}