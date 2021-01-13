# 设计模式

作者：[Grey](https://www.cnblogs.com/greyzeng)

原文地址：

[Github](https://github.com/GreyZeng/dp/blob/master/README.md)

[语雀](https://www.yuque.com/greyzeng/uzfhep/gzxzch)

[博客园](https://www.cnblogs.com/greyzeng/articles/14107751.html)

## UML和代码

[UML图](https://www.processon.com/view/link/5e93b9e1e0b34d6feaa65b19)

[代码](https://github.com/GreyZeng/dp)

## 单例模式

![UML](https://cdn.nlark.com/yuque/0/2020/png/757806/1585815368299-cf029297-38cf-493d-9e91-7155d03af486.png)

### 饿汉式

类加载的时候就会初始化这个实例, JVM保证唯一实例,线程安全， 但是可以通过反射破坏

方式一

```java
public class Singleton1 {
    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
```

方式二

```java
public class Singleton2 {
    private static final Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}
```

### 懒汉式

虽然可以实现按需初始化，但是线程不安全, 因为在判断INSTANCE == null的时候，如果是多个线程操作的话， 一个线程还没有把INSTANCE初始化好，另外一个线程判断INSTANCE==null 得到true，就会继续初始化

```java


public class Singleton3 {
    private static Singleton3 INSTANCE;

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        if (INSTANCE == null) {
            // 模拟初始化对象需要的耗时操作
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton3();
        }
        return INSTANCE;
    }
}
```

为了防止线程不安全，可以在getInstance方法上加锁，这样既实现了按需初始化，又保证了线程安全，但是加锁可能会导致一些性能的问题

```java
public class Singleton4 {
    private static Singleton4 INSTANCE;

    private Singleton4() {
    }

    public static synchronized Singleton4 getInstance() {
        if (INSTANCE == null) {
            // 模拟初始化对象需要的耗时操作
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton4();
        }
        return INSTANCE;
    }
}
```

为了提升一点点性能，可以不给getInstance整个方法加锁，而是对INSTANCE判空这段代码加锁, 但是又带来了线程不安全的问题

```java
public class Singleton5 {
    private static Singleton5 INSTANCE;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton5.class) {
                // 模拟初始化对象需要的耗时操作
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Singleton5();
            }
        }
        return INSTANCE;
    }
}
```

Double Check Locking模式,就是双加锁检查模式

***这种方式中，Volatile是必需的，目的为了防止指令重排，生成一个半初始化的的实例，导致生成两个实例***

具体可参考 [双重检索(DCL)的思考: 为什么要加volatile?](https://blog.csdn.net/weixin_37505014/article/details/97302345)
说了这个问题

```java
public class Singleton6 {
    private volatile static Singleton6 INSTANCE;

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton6.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton6();
                }
            }
        }
        return INSTANCE;
    }
}
```

以下两种更为优雅的方式，既保证了线程安全，又实现了按需加载

方式一：静态内部类方式，JVM保证单例，加载外部类时不会加载内部类，这样可以实现懒加载

```java
public class Singleton7 {
    private Singleton7() {
    }

    public static Singleton7 getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final Singleton7 INSTANCE = new Singleton7();
    }

}
```

方式二： 使用枚举, 这是实现单例模式的最佳方法。它更简洁，自动支持序列化机制，绝对防止多次实例化,这种方式是 Effective Java 作者 Josh Bloch
提倡的方式，它不仅能避免多线程同步问题，而且还自动支持序列化机制，防止反序列化重新创建新的对象，绝对防止多次实例化。

```java
public enum Singleton8 {
    INSTANCE;
}
```

## 策略模式

![策略模式](https://cdn.nlark.com/yuque/0/2020/png/757806/1585876508201-2a10502a-777e-48af-80e2-415d547be72a.png)

实例： 假设我们有一个猫类，这个类里面有体重和身高这两个属性，给你一个猫的集合，然后需要你按猫的体重从小到大排序

思路： 我们可以把体重从小到大这个看成是一个策略，后续可能衍生其他的策略，比如： 按身高从高到低 按体重从小到大，体重一样的身高从高到低

以身高从低到高排序这个策略为例

```java
public class CatSortStrategy implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.getHeight() - o2.getHeight();
    }
}
```

假设我们定义猫排序的方法是: sort 那么这个方法必然需要传入一个排序策略的参数（否则我怎么知道要怎么排序猫？） 所以定义的sort方法可以是：

```java
public class Sorter {

    public Cat[] sort(Cat[] items, Comparator<Cat> strategy) {
        int length = items.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (strategy.compare(items[i], items[j]) > 0) {
                    Cat tmp = items[i];
                    items[i] = items[j];
                    items[j] = tmp;
                }
            }
        }
        return items;
    }
}
```

进一步抽象，如果我想让Sorter这个工具类不仅可以对猫进行各种策略的排序(基于比较的排序算法)，还可以对狗进行各种策略的排序(基于比较排序算法)，可以将Sorter定义成泛型

```java
public class Sorter<T> {

    public T[] sort(T[] items, Comparator<T> strategy) {
        int length = items.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (strategy.compare(items[i], items[j]) > 0) {
                    T tmp = items[i];
                    items[i] = items[j];
                    items[j] = tmp;
                }
            }
        }
        return items;
    }
}
```

调用的时候, 泛型版本的Sorter可以对猫和狗都进行基于特定排序策略的排序。

```java
Sorter<Cat> sorter=new Sorter<>();
        Cat[]sortedCats=sorter.sort(cats,new CatSortStrategy());

        Sorter<Dog> sorter=new Sorter<>();
        Dog[]sortedCats=sorter.sort(dogs,new DogSortStrategy());
```

## 工厂模式

### 抽象工厂

举例，现在需要通过工厂来制造交通工具，如果是现代的工厂，制造的就是汽车，如果是古代的工厂，制造的就是马车, 我们可以先把工厂抽象出来，

```java
public abstract class AbstractFactory {
    // 制造交通工具的抽象工厂
    protected abstract Transportation createTransportation();
}

```

交通工具我们也可以抽象出来

```java
public abstract class Transportation {
    protected abstract void go();
}
```


对于马车和汽车来说，只需要继承这个Transportation类，实现对应的go方法即可,以汽车为例

```java
public class Car extends Transportation {
    @Override
    protected void go() {
        System.out.println("car go");
    }
}
```

对于现代工厂还是古代工厂，我们只需要继承AbstractFactory这个类，实现createTransportation方法即可，以现代工厂为例

```java
public class ModernFactory extends AbstractFactory {

    @Override
    protected Transportation createTransportation() {
     	// 现代工厂制造汽车
        return new Car();
    }
}
```

主方法在调用的时候，只需要

```java
public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new ModernFactory();
        factory.createTransportation().go();
    }
}
```

抽象工厂的UML图如下：

![abstract_factory](https://cdn.nlark.com/yuque/0/2020/png/757806/1608882981745-e5a7c7ca-e8a9-48bc-bee6-818145b461fe.png)



> note

> 单例模式就是一种工厂模式（静态工厂）


应用

- Spring IOC DI
- Hibernate 换数据库只需换方言和驱动就可以切换不同数据库

## 门面模式

[TODO] 可以有更好的例子

假设我们有一个需求，是在画板上画圆形和矩形，“暴力”写法就是：

```java
public static void main(String[]args){
    Sharp circle=new Circle();
    Sharp rectangle=new Rectangle();
    circle.draw();
    rectangle.draw();
}

```

如果后续要改变画圆和画矩形逻辑，我们就需要动到这个主方法， 用门面模式的方式，我们可以通过一个SharpMarker来完成画圆形和矩形的逻辑（当作外部调用的门面），那么在改变画圆和画矩形逻辑的时候，就不需要改动主方法了

```java
public class SharpMarker {
    private Sharp circle;
    private Sharp rectangle;

    public SharpMarker(Sharp circle, Sharp rectangle) {
        this.circle = circle;
        this.rectangle = rectangle;
    }

    public void draw() {
        circle.draw();
        rectangle.draw();
    }
}
```

主方法只需要：

```java
public class Main {
    public static void main(String[] args) {
        SharpMarker marker = new SharpMarker(new Rectangle(), new Circle());
        marker.draw();
    }
}
```

门面模式的UML图如下

![门面模式](https://cdn.nlark.com/yuque/0/2020/png/757806/1607650357202-5e6a8361-a8ec-4c73-9af2-1eb642e749e5.png)

- 应用
    - 消息中间件

## 调停者/中介模式

举个简单的例子，如果一个聊天室里面的用户1和用户2要聊天，聊天室就相当于中介的地位，用户1和用户2只管调用发消息方法，聊天室即可把消息给对方

```java
public class ChatRoom {
    public static void showMessage(User user, String content) {
        System.out.println("user :" + user.getName() + " send a message, content is " + content);
    }
}
```

以上代码表示，聊天室将user说的content展示出来

主方法只需要如下调用即可：

```java
public class Main {
    public static void main(String[] args) {
        User user = new User("Peter");
        user.sendMessage("Hello ");
        user = new User("Harry");
        user.sendMessage("Hi");
    }
}
```

User中的sendMessage方法

```java
public void sendMessage(String content){
        ChatRoom.showMessage(this,content);
        }
```

![UML](https://cdn.nlark.com/yuque/0/2020/png/757806/1607688441427-88798ea0-9ebb-47a7-8058-fdb4c8e18fb1.png)

## 责任链模式

有一段文本需要过滤敏感字，我们可以通过责任链模式来设计这个功能，假设文本是：scripts Hell World! 996

我们有多个过滤规则，比如第一个规则是：过滤 scripts 这个关键字(实际的规则可能很复杂，目前只是举这个简单例子来说明情况)
第二个规则是：过滤 996 这个关键字

我们可以抽象一个Filter接口，各种过滤规则无非就是实现这个接口即可

```java

public interface Filter {
    boolean doFilter(Msg msg);
}

```

过滤 996 的规则：

```java
public class SensitiveFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        msg.setContent(msg.getContent().replace("996", ""));
        return true;
    }
}
```

过滤 scripts 的规则：

```java
public class HTMLFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        msg.setContent(msg.getContent().replace("scripts", ""));
        return true;
    }
}
```

主方法调用的时候，就直接New 相应的Filter来处理即可：

```java
Msg msg=new Msg();
        msg.setContent("scripts Hell World! 996");
        System.out.println("before filter , the content is : "+msg.getContent());
        Filter html=new HTMLFilter();
        Filter sensitive=new SensitiveFilter();
        html.doFilter(msg);
        sensitive.doFilter(msg);
        System.out.println("after filter , the content is : "+msg.getContent());
```

不过，更为优雅的一种方式是设计一个FilterChain，我们把所有的Filter都加入到这个FilterChain里面，对于Msg直接去调用FilterChain的过滤方法即可把FilterChain中的所有Filter都执行(
而且还可以很灵活指定Filter顺序)

```java
public class FilterChain implements Filter {
    // 这里存所有需要应用的Filter
    private List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Msg msg) {
        // 这里可以灵活指定Filter的执行顺序
        for (Filter filter : filters) {
            if (!filter.doFilter(msg)) {
                return false;
            }
        }
        return true;
    }
}
```

那么主方法在调用的时候，可以直接通过如下的方式：

```java
public class Main {
    public static void main(String[] args) {
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter());
        Msg msg = new Msg();
        msg.setContent("scripts Hell World! 996");
        System.out.println("before filter , the content is : " + msg.getContent());
        filterChain.doFilter(msg);
        System.out.println("after filter , the content is : " + msg.getContent());
    }
}

```

UML图如下：



![UML](https://cdn.nlark.com/yuque/0/2020/png/757806/1607906942723-793f3c5d-d08a-4252-b961-01360438fa8e.png?x-oss-process=image%2Fresize%2Cw_582)

应用

- Servlet filter[TODO]
- Structs interceptor
- SpringMVC interceptor



## 装饰器模式
顾名思义，就是对某个方法或者对象进行装饰，举个简单的例子，有个圆形类（Circle），我需要把这个圆形的涂上红色，其实就是新增一个装饰器来装饰这个圆形类。
如果要让装饰器通用一些，可以处理圆形类对应的抽象类 Sharpe，那么对于任意Shape的子类，都可以用红色装饰器来涂红色。

我们先定义Sharp这个抽象类：

```java
public abstract class Sharp {
    protected abstract void draw();
}
```

然后我们定义Sharp的装饰类：SharpDecorator,这个类是所有装饰器类的抽象类，后续的装饰器只需要实现这个抽象类就可以对Sharp进行各种装饰了，

```java
public abstract class SharpDecorator extends Sharp {
    protected Sharp decoratedSharp;

    public SharpDecorator(Sharp decoratedSharp) {
        this.decoratedSharp = decoratedSharp;
    }
}
```

红色装饰器实现这个抽象类即可：

```java
public class RedSharpDecorator extends SharpDecorator {

    public RedSharpDecorator(Sharp decoratedSharp) {
        super(decoratedSharp);
    }

    private static void redIt() {
        System.out.println("[RED]");
    }

    @Override
    protected void draw() {
        redIt();
        this.decoratedSharp.draw();
        redIt();
    }
}

```

主方法调用的时候只需要：

```java
 new RedSharpDecorator(new Circle()).draw(); 
```

UML图如下：

![UML](https://cdn.nlark.com/yuque/0/2020/png/757806/1608170853179-3be30d25-ce72-4d61-9541-b6373bb8281d.png?x-oss-process=image%2Fresize%2Cw_746)



装饰器模式的应用
- Java中的IO流， Read/InputStream ,Write/OutputStream

## 观察者模式

一般可以用做事件处理往往和责任链模式搭配使用, 举个例子
按钮上一般都可以绑定事件，当我们按下按钮的时候，可以触发这些事件的执行，这里就可以用观察者模式来做, 我们先定义按钮这个对象

```java
public class Button {
    private List<ActionListener> listeners = new ArrayList<>();

    public void addActionListener(ActionListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public String toString() {
        return "Button{" +
                "listeners=" + listeners +
                '}';
    }

    public void buttonPressed() {
        ActionEvent event = new ActionEvent(System.currentTimeMillis(), this);
        listeners.forEach(item -> item.actionPerformed(event));
    }
}

```

由上可知，Button中持有了一个列表，这个列表里面装的就是所有事件的列表，我们可以把事件绑定到这个按钮的事件列表中，这样就可以实现按钮执行press操作的时候，把对应的事件触发执行了

```java
public interface ActionListener {
    void actionPerformed(ActionEvent event);
}
```

模拟两个监听事件

```java
public class Listener1 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("Listener 1 listened it source: [" + event.getSource() + "], when is [" + event.getWhen() + "]");
    }
}
```

```java
public class Listener2 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("Listener 2 listened it source: [" + event.getSource() + "], when is [" + event.getWhen() + "]");
    }
}
```

主方法在调用的时候

```java
public class Main {
    public static void main(String[] args) {
        Button button = new Button();
        button.addActionListener(new Listener1());
        button.addActionListener(new Listener2());
        button.buttonPressed();
    }
}
```

当执行

```java
button.buttonPressed()
```

的时候，对应的listener1和listener2就可以执行了。

UML图如下

![observer](https://cdn.nlark.com/yuque/0/2020/png/757806/1608778788874-ed2d6e8e-856a-4bea-9dd7-523b84d3f06d.png?x-oss-process=image%2Fresize%2Cw_746)

应用
Spring ApplicationEvent

## 组合模式

组合模式中，最常用的一个用法就是目录层级的遍历，话不多说，直接上代码,主方法中

```java
BranchNode root=new BranchNode("root");
BranchNode branch1=new BranchNode("branch1");
BranchNode branch2=new BranchNode("branch2");
branch1.addNode(new LeafNode("leaf1"));
root.addNode(branch1);
root.addNode(branch2);
tree(root,0);
```

其中，BranchNode为分支节点，LeafNode是叶子节点 达到的效果就是打印如下的形式
```
root
--branch1
----leaf1
--branch2
```

其中BranchNode和LeafNode都实现了Node接口，Node接口(也可以为定义抽象类)仅提供了一个属性(content:标识节点内容)和一个打印方法：

```java
public abstract class Node {
    protected String content;

    protected abstract void print();
}
```

BranchNode下可以包含多个Node，因为一个分支下面可以有多个分支（这个分支可以是任意的Node子类)

```java
public class BranchNode extends Node {
    private List<Node> nodes = new ArrayList<>();

    public BranchNode(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println(content);
    }
    // get..set方法略 
}

```

组合模式的UML图如下：

![UML](https://cdn.nlark.com/yuque/0/2020/png/757806/1607996573171-ee1d3a43-4106-4afa-b101-ed23ad3babb3.png?x-oss-process=image%2Fresize%2Cw_746)

## 享元模式

运用共享技术有效地支持大量细粒度的对象。主要解决：在有大量对象时，有可能会造成内存溢出，我们把其中共同的部分抽象出来，如果有相同的业务请求，直接返回在内存中已有的对象，避免重新创建。

假设我们有一个子弹类,同时我们设计一个子弹池，子弹池负责提供子弹

```java
public class BulletPool {
    List<Bullet> bullets = new ArrayList<>();

    {
        for (int i = 0; i < 10; i++) {
            bullets.add(new Bullet(true));
        }
    }

    public Bullet getBullet() {
        for (int i = 0; i < bullets.size(); i++) {
            if (bullets.get(i).living) {
                return bullets.get(i);
            }
        }
        return new Bullet(true);
    }
}

```

可以看到getBullet逻辑，如果池子中有子弹，就拿池中的子弹，如果没有，就new一个新的子弹返回

UML图如下

![flyweight](https://cdn.nlark.com/yuque/0/2020/png/757806/1608861497667-ff8087e9-873b-4185-af97-759a63a121dd.png)



应用

- Java中Boolean的valueOf(boolean b) 方法 ，这个方法返回的Boolean对象不会新new出来，而是复用的同一个, 源码如下：

```java
public static Boolean valueOf(boolean b) {
    return (b ? TRUE : FALSE);
}
public static final Boolean TRUE = new Boolean(true);
public static final Boolean FALSE = new Boolean(false);

```


- 连接池管理

## 代理模式

静态代理

举例说明，假设我们需要在某个类的某段代码的前后加上日志记录，我们就可以通过静态代理的方式实现

```java
public class Main {
    public static void main(String[] args) {
       new Tank().move();
    }
}
```

假设我们需要在move()方法的前后都加上日志记录，我们可以设置一个代理类

```java
public class TankLogProxy implements Moveable {
    private Moveable m;

    public TankLogProxy(Moveable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("log before");
        m.move();
        System.out.println("log after");
    }
}
```

这样的话，原先的调用就改成了：

```java
public class Main {
    public static void main(String[] args) {
        new TankLogProxy(new Tank()).move();
    }
}
```

即可实现在move方法调用前后加入日志记录的操作。

UML图如下：

![proxy_static](https://cdn.nlark.com/yuque/0/2020/png/757806/1608883975491-06b130c6-6f39-4cf8-9093-0c23532b0459.png)

动态代理

如果需要通过动态代理（jdk自带的方式）的方式来完成上述功能，我们可以这样来做

```java
public class MovableProxy implements InvocationHandler {
    private Movable movable;

    public MovableProxy(Movable movable) {
        this.movable = movable;
    }

    public void before() {
        System.out.println("before , do sth");
    }

    public void after() {
        System.out.println("after , do sth");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(movable, args);
        after();
        return o;
    }
}
```

主方法调用的时候：

```java
public class Main {
    public static void main(String[] args) {
        Movable tank = new Tank();

        //reflection 通过二进制字节码分析类的属性和方法

        Movable m = (Movable) Proxy.newProxyInstance(Movable.class.getClassLoader(),
                new Class[]{Movable.class},
                new MovableProxy(tank)
        );

        m.move();
        m.go();
    }
}

```


UML图如下：

![dy_proxy](https://cdn.nlark.com/yuque/0/2020/png/757806/1608883986761-04440e84-f392-4509-b121-53513ef293ee.png)


实际应用

- Spring AOP

- jdk自带
	- **ASM操作二进制码**
	- Java Instrumentation
	- 必须面向接口
	
- cglib
	- final类不行，代理类的子类 底层也是ASM

## 迭代器模式

迭代器最典型的应用是容器遍历

![iterator](https://cdn.nlark.com/yuque/0/2020/png/757806/1608776439431-59dc6b87-b90f-45ba-9da6-38a631bf9d19.png)

模仿JDK的容器，我们自定义一个容器并实现iterator方法
我们先定义一个容器接口：Collection_.java

```java
public interface Collection_<E> {
    int size();

    void add(E element);

    Iterator_<E> iterator();
}

```

里面包括了一个iterator方法，所以每个实现这个容器接口的具体容器类型，都必须自定义iterator方法,
然后定义一个Iterator接口Iterator_.java, 具体容器中可以增加一个内部类来专门实现这个接口，
比如我们的具体容器类是ArrayList_.java

```java
package Iterator;

import static java.lang.System.arraycopy;

/**
 * @author Grey
 * @date 2020/4/15
 */
public class ArrayList_<E> implements Collection_<E> {
    private E[] objects = (E[]) new Object[10];
    private int index = 0;

    @Override
    public int size() {
        return index;
    }

    @Override
    public void add(E element) {
        // 见源码，这里略
    }

    @Override
    public Iterator_<E> iterator() {
        return new ArrayListIterator_<>();
    }

    private class ArrayListIterator_<E> implements Iterator_<E> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < index;
        }

        @Override
        public E next() {
            E o = (E) objects[currentIndex];
            currentIndex++;
            return o;
        }
    }

}
```

我们主要看ArrayListIterator_这个内部类，里面其实是实现了Iterator_这个接口，所以ArrayList_的遍历操作会执行这个内部类中的操作规则来对其进行遍历。



## 访问者模式

访问者模式在**结构不变**的情况下动态改变对于内部元素的动作，举例说明：

假设我们需要构造一台电脑，有主板（Board），CPU，内存（Memory），但是针对企业用户和个人用户，电脑组件的价格是不一样的，我们需要根据不同客户获取一台电脑的总价格。

我们先抽象出电脑组件这个类

```java
public abstract class ComputerPart {
    abstract void accept(Visitor visitor);
    abstract int getPrice();
}
```

每个具体组件会继承这个抽象类,以主板(Board)为例

```java
public class Board extends ComputerPart {
    @Override
    void accept(Visitor visitor) {
        visitor.visitBoard(this);
    }

    @Override
    int getPrice() {
        return 20;
    }
}
```

抽象出一个访问者(Visitor)接口，

```java
public interface Visitor {
    void visitCPU(CPU cpu);

    void visitBoard(Board board);

    void visitMemory(Memory memory);
}
```

每个具体类型的访问者实现这个接口，然后定义其不同的价格策略，以公司访问者为例(CorpVisitor)

```java
public class CorpVisitor implements Visitor {
    private int totalPrice;

    @Override
    public void visitCPU(CPU cpu) {
        totalPrice += cpu.getPrice() - 1;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice() - 2;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() - 3;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
```

个人访问者(PersonalVisitor）类似

主方法调用

```java
ComputerPart cpu = new CPU();
ComputerPart memory = new Memory();
ComputerPart board = new Board();
PersonalVisitor personalVisitor = new PersonalVisitor();
cpu.accept(personalVisitor);
memory.accept(personalVisitor);
board.accept(personalVisitor);
System.out.println(personalVisitor.getTotalPrice());
```

UML图如下

![Visitor](https://cdn.nlark.com/yuque/0/2020/png/757806/1608796432294-bf88b955-39df-4149-9504-e8d60839225d.png?x-oss-process=image%2Fresize%2Cw_746)


应用：

1. 做编译器的时候，需要生成AST，进行类型检查 根据抽象语法树，生成中间代码

2. XML文件解析

## 构造器模式

我们在对一个实体类进行属性的get/set的时候，可以通过封装一些常用的构造方法来简化实体类的构造，

比如 [Effective Java中文版（第3版）](https://book.douban.com/subject/30412517/) 中举到到这个例子

```java
public class NutritionFacts {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;

	public static class Builder {
		// Required parameters
		private final int servingSize;
		private final int servings;

		// Optional parameters - initialized to default values
		private int calories      = 0;
		private int fat           = 0;
		private int sodium        = 0;
		private int carbohydrate  = 0;

		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings    = servings;
		}

		public Builder calories(int val) {
			calories = val;
			return this;
		}

		public Builder fat(int val) {
			fat = val;
			return this;
		}

		public Builder sodium(int val) {
			sodium = val;
			return this;
		}

		public Builder carbohydrate(int val) {
			carbohydrate = val;
			return this;
		}

		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}

	private NutritionFacts(Builder builder) {
		servingSize  = builder.servingSize;
		servings     = builder.servings;
		calories     = builder.calories;
		fat          = builder.fat;
		sodium       = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
}
```

其中Builder就是一个内部类，用于构造NutritionFacts的必要信息，外部调用NutritionFacts的构造方法时候，可以这样使用：

```java

NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();

```

![UML](https://cdn.nlark.com/yuque/0/2021/png/757806/1610539905996-0e846f1e-cd6b-4e43-98f6-a9c0f7f1e971.png)

构造器模式也适用于类层次结构。抽象类有抽象的Builder，具体类有具体的Builder。[Effective Java中文版（第3版）](https://book.douban.com/subject/30412517/) 中还有一个例子，
假设我们抽象出一个披萨类，各种各样的披萨均可以继承披萨这个抽象类来实现自己的具体类型的披萨。

Pizza抽象类如下：

```java
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// Effective Java 3th examples
public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
    final Set<Topping> toppings;
    
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }
        
        abstract Pizza build();
        
        // Subclasses must override this method to return "this"
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // See Item 50
    }
}
```
其中的Builder方法是abstract的，所以子类需要实现具体的Builder策略，

一种披萨的具体实现：NyPizza

```java
import java.util.Objects;

public class NyPizza extends Pizza {
	public enum Size {
		SMALL, MEDIUM, LARGE
	}

	private final Size size;

	public static class Builder extends Pizza.Builder<Builder> {
		private final Size size;

		public Builder(Size size) {
			this.size = Objects.requireNonNull(size);
		}

		@Override
		public NyPizza build() {
			return new NyPizza(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	private NyPizza(Builder builder) {
		super(builder);
		size = builder.size;
	}
}

```

另一种披萨的具体实现Calzone:

```java
public class Calzone extends Pizza {
	private final boolean sauceInside;

	public static class Builder extends Pizza.Builder<Builder> {
		private boolean sauceInside = false; // Default

		public Builder sauceInside() {
			sauceInside = true;
			return this;
		}

		@Override
		public Calzone build() {
			return new Calzone(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	private Calzone(Builder builder) {
		super(builder);
		sauceInside = builder.sauceInside;
	}
}

```
我们在具体调用的时候，可以通过如下方式：

```java

NyPizza pizza = new NyPizza.Builder(SMALL).addTopping(SAUSAGE).addTopping(ONION).build();
Calzone calzone = new Calzone.Builder().addTopping(HAM).sauceInside().build();

```


实际应用有非常多，很多组件都提供这样的构造方式，比如OkHttpClient的构造方法：

```java
public static OkHttpClient create(long connectTimeOut) {
        return new OkHttpClient().newBuilder()
                .connectionSpecs(Arrays.asList(
                        ConnectionSpec.MODERN_TLS,
                        ConnectionSpec.COMPATIBLE_TLS,
                        ConnectionSpec.CLEARTEXT))
                .connectTimeout(connectTimeOut, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectionPool(CONNECTION_POOL)
                .retryOnConnectionFailure(true)
                .followRedirects(true)
                .followSslRedirects(true)
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String s, SSLSession sslSession) {
                        return true;
                    }
                })
                .cookieJar(new CookieJar() {
                    private List<Cookie> cookies;

                    @Override
                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                        this.cookies = cookies;
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl url) {
                        if (cookies != null) {
                            return cookies;
                        }
                        return Collections.emptyList();

                    }
                })
                .build();
    }
```



## 适配器模式

举例说明，假设又一个播放器，需要根据不同格式以及对应的文件来播放，接口设计如下：

```java
public interface MediaPlayer {
    void play(String type, String fileName);
}

```

不同类型的播放器只需要实现这个接口即可，比如我们有一个ClassicMediaPlayer，这个只能播放mp3类型的文件

```java
public class ClassicMediaPlayer implements MediaPlayer {
    @Override
    public void play(String type, String fileName) {
        if ("mp3".equalsIgnoreCase(type)) {
            System.out.println("play mp3");
        } else {
            System.out.println("not supported format");
        }

    }
}

```

如果我想扩展，我们可以增加一个适配器：

```java
public class PlayerAdapter implements MediaPlayer {
    private AdvanceMediaPlayer advanceMediaPlayer;

    public PlayerAdapter(String type) {
        if ("mp4".equalsIgnoreCase(type)) {
            advanceMediaPlayer = new MP4Player();
        } else if ("AVI".equalsIgnoreCase(type)) {
            advanceMediaPlayer = new AVIPlayer();
        }
    }

    @Override
    public void play(String type, String fileName) {
        if ("mp4".equalsIgnoreCase(type)) {
            advanceMediaPlayer.playMP4(fileName);
        } else if ("AVI".equalsIgnoreCase(type)) {
            advanceMediaPlayer.playAVI(fileName);
        } else {
            new ClassicMediaPlayer().play(type, fileName);
        }
    }
}
```

这个适配器就是根据不同类型来构造不同的播放器的，然后定义一个ExtendMediaPlayer，在里面持有PlayAdapter，这样，ExtendMediaPlayer就拥有了播放不同类型文件的能力，所以我们在调用的时候，只需要：

```java
ExtendMediaPlayer audioPlayer = new ExtendMediaPlayer();
audioPlayer.play("mp3", "beyond the horizon.mp3");
audioPlayer.play("mp4", "alone.mp4");
audioPlayer.play("avi", "far far away.vlc");
```

UML图如下：

![adaptor](https://cdn.nlark.com/yuque/0/2020/png/757806/1608867626986-80cd66e0-9a02-4e57-a6df-94a2b5d5c30a.png?x-oss-process=image%2Fresize%2Cw_746)

应用

- java.io 

- jdbc-odbc bridge 

- ASM transformer

## 桥接模式

使用桥接模式，可以将抽象和具体的发展单独分支(抽象中持有一个具体的引用 )
举例说明：

GG在追MM的时候，可以送书和花两种礼物

```java
public class GG {
    public void chase(MM mm) {
        Gift g = new WarmGift(new Flower());
        give(mm, g);
    }
    public void give(MM mm, Gift g) {
        System.out.println(g + "gived!");
    }
}
```

如上代码，Flower被包装成了一个WarmGift送给MM，WarmGift和WildGift都是Gift的一种抽象，Flower和Book都算Gift的一种具体实现, 我们让Gift这个抽象类中，持有一个GiftImpl的引用

```java
public abstract class Gift {
    protected GiftImpl impl;
}

```

```java
public class Flower extends GiftImpl {
}
```

```java
public class WarmGift extends Gift {
    public WarmGift(GiftImpl impl) {
        this.impl = impl;
    }
}
```

UML示例图如下：

![bridge](https://cdn.nlark.com/yuque/0/2020/png/757806/1608867105480-312dea95-3703-4189-994c-436ba28d7068.png?x-oss-process=image%2Fresize%2Cw_746)



## 命令模式

通过调用者调用接受者执行命令，顺序：调用者→命令→接受者，比如：CopyCommand中的doit方法，就是执行这个copy的命令，undo就是撤销上一次执行的命令，我们可以抽象出Command这个接口：

```java
public interface Command {
     void doit();

     void undo();
}
```

CopyCommand实现这个接口，并实现doit和undo这两个方法，其他的命令也可以类似的实现出来

```java
public class CopyCommand implements Command {
    private Content content;

    public CopyCommand(Content content) {
        this.content = content;
    }


    @Override
    public void doit() {
        content.msg = content.msg + content.msg;
    }

    @Override
    public void undo() {
        content.msg = content.msg.substring(0, content.msg.length() / 2);
    }
}
```

UML图如下

![Command](https://cdn.nlark.com/yuque/0/2020/png/757806/1608860025027-5e35d0c2-acf4-476f-9575-d56805f2c2e9.png)

命令模式可以
1. 结合责任链模式实现多次undo 
2. 结合组合模式实现宏命令 
3. 结合记忆模式实现transaction回滚

## 原型模式

原型模式用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象，典型的应用是对象的克隆方法

```java
public class Person implements Cloneable {
    String name = "lisa";
    int age = 1;
    Location loc = new Location("xy", 10);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.loc = (Location) loc.clone();
        return p;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", loc=" + loc +
                '}';
    }
}
```

```java
public class Location implements Cloneable {
    private String street;
    private int roomNo;

    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo=" + roomNo +
                '}';
    }
}
```

```java
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person();
        System.out.println(p);
        Person p2 = (Person) p.clone();
        System.out.println(p2);
    }
}
```
UML图如下：

![UML](https://cdn.nlark.com/yuque/0/2020/png/757806/1608514221624-8a094461-e7fd-4f0b-a7e1-6601f65e55ff.png)




## 备忘录模式

用于记录对象的某个瞬间 类似快照
应用实例：
1. 后悔药。
2. 打游戏时的存档。
3. Windows 里的 ctri + z。
4. IE 中的后退。
5. 数据库的事务管理。

一个简单的示例

```java
public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        person.name = "zhangsan";
        person.age = 12;
        new Main().save(person);
        new Main().load();
    }

    public void save(Person person) {
        File c = new File("/tank.data");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(c));) {
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        File c = new File("/tank.data");
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(c));) {

            Person myTank = (Person) oos.readObject();
            System.out.println(myTank);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

UML图：

![UML](https://cdn.nlark.com/yuque/0/2020/png/757806/1608627185954-cef8f8d0-ab59-4344-bcd7-6790fb0101cc.png)



## 模板方法

假设我们要实现一个游戏，这个游戏有初始化，启动，结束三个方法，我们可以定义一个游戏的模板：

```java
public abstract class Game {
    protected abstract void init();

    protected abstract void start();

    protected abstract void end();

    protected final void play() {
        init();
        start();
        end();
    }
}
```



每种类似这样结构（有初始化，启动，结束）的游戏都可以继承这个类来实现这三个方法，比如BasketballGame

```java
public class BasketballGame extends Game {
    @Override
    protected void init() {
        System.out.println("basketball init");
    }

    @Override
    protected void start() {

        System.out.println("basketball start");
    }

    @Override
    protected void end() {

        System.out.println("basketball end");
    }
}

```

FootballGame

```java
public class FootballGame extends Game {
    @Override
    protected void init() {
        System.out.println("football init");
    }

    @Override
    protected void start() {

        System.out.println("football start");
    }

    @Override
    protected void end() {

        System.out.println("football end");
    }
}
```

主方法在调用的时候，直接：

```java
Game basketballGame = new BasketballGame();
basketballGame.play();
Game footballGame = new FootballGame();
footballGame.play();
```



UML图如下：

![UML](https://cdn.nlark.com/yuque/0/2020/png/757806/1608454147289-150b6953-6f40-42a6-b8a5-5669bac0fa1f.png)



实际应用场景

- 钩子函数 

- RestTemplate /JDBCTemplate



## 状态模式

对象的行为依赖于它的状态（属性），并且可以根据它的状态改变而改变它的相关行为。

举个例子，Person有Cry, Smile, Say三种行为，但是在不同状态(SadState, HappyState)下，这三种行为不一样，

```java
public class Person {
    private State state;

    public Person(State state) {
        this.state = state;
    }

    void cry() {
        state.cry();
    }

    void smile() {
        state.smile();
    }

    void say() {
        state.say();
    }
}
```

在Sad状态下，行为可能是：

```java
public class SadState implements State {

    @Override
    public void cry() {
        System.out.println("Sad cry");
    }

    @Override
    public void smile() {
        System.out.println("Sad smile");
    }

    @Override
    public void say() {
        System.out.println("Sad say");
    }
}
```
Happy状态下同理，那么主方法在调用的时候：

```java
public class Main {
    public static void main(String[] args) {
        Person person = new Person(new SadState());
        person.cry();
        person.say();
        person.smile();
        person = new Person(new HappyState());
        person.cry();
        person.say();
        person.smile();

    }
}
```
Person就可以根据不同的状态来执行cry，say，smile的行为了

UML图如下：

![UML](https://cdn.nlark.com/yuque/0/2020/png/757806/1608687169228-1427b39c-c354-4472-afaa-52d88e318834.png?x-oss-process=image%2Fresize%2Cw_746)





## 解释器模式

一般用于脚本语言解释器


## 参考资料

- [Effective Java中文版（第3版）](https://book.douban.com/subject/30412517/)
- [Head First 设计模式](https://book.douban.com/subject/2243615/)
- [设计模式-可复用面向对象软件的基础](https://book.douban.com/subject/1052241/)
- [坦克大战-马士兵](https://ke.qq.com/course/398245)
- [菜鸟教程-设计模式](https://www.runoob.com/design-pattern/design-pattern-tutorial.html)
- [极客时间-设计模式之美-王争](https://time.geekbang.org/column/intro/250)
- [极客时间-小马哥讲Spring核心编程思想-小马哥](https://time.geekbang.org/course/intro/100042601)
