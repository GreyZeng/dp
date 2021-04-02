package factory.factorymethod;

public class IBMMouse implements Mouse {
    @Override
    public void sayHi() {
        System.out.println("我是联想旗下的IBM鼠标");
    }
}
