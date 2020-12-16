# 设计模式

作者：[Grey](https://www.cnblogs.com/greyzeng)

原文地址：

[Github](https://github.com/GreyZeng/dp/blob/master/README.md)

[语雀](https://www.yuque.com/greyzeng/uzfhep/gzxzch)

[博客园](https://www.cnblogs.com/greyzeng/articles/14107751.html)

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

- 简单工厂
- 静态工厂--单例模式
- 抽象工厂
- 工厂方法
- Spring IOC DI
- Hibernate 换数据库只需换方言和驱动就可以

## 门面模式

[TODO] 可以有更好的例子

假设我们有一个需求，是在画板上画圆形和矩形，“暴力”写法就是：

```java
public static void main(String[]args){
        Circle circle=new Sharp();
        Rectangle rectangle=new Sharp();
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

应用

- Servlet filter[TODO]
- Structs interceptor
- SpringMVC interceptor

![UML](https://cdn.nlark.com/yuque/0/2020/png/757806/1607906942723-793f3c5d-d08a-4252-b961-01360438fa8e.png?x-oss-process=image%2Fresize%2Cw_582)

## 装饰器模式

- IO流， Read/InputStream ,Write/OutputStream
- Tail/RectDecrator

## 观察者模式

事件处理 往往和责任链模式搭配使用

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
<pre>
root
--branch1
----leaf1
--branch2
</pre>

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

String 连接池管理

## 代理模式

- 静态代理
- 动态代理
    - jdk自带
        - **ASM操作二进制码**
        - Java Instrumentation
    - cglib
        - final类不行，代理类的子类 底层也是ASM

- Spring AOP

## 迭代器模式

- 容器和容器遍历

## 访问者模式

在**结构不变**的情况下动态改变对于内部元素的动作 做编译器的时候，生成AST的时候，进行类型检查 根据抽象语法树，生成中间代码

XML文件解析

## 构建器模式

我们在对一个实体类进行属性的get/set的时候，可以通过封装一些常用的构造方法来简化实体类的构造

比如：

```java
public class Person {

    private String name;
    private int age;
    private String address;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    private Person() {
    }

    public static class PersonBuilder {
        private Person person = new Person();

        public PersonBuilder basicInfo(String name, int age) {
            person.name = name;
            person.age = age;
            return this;
        }

        public PersonBuilder name(String name) {
            person.name = name;
            return this;
        }

        public PersonBuilder age(int age) {
            person.age = age;
            return this;
        }

        public PersonBuilder address(String address) {
            person.address = address;
            return this;
        }

        public Person build() {
            return person;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }


}
```

其中PersonBuilder就是一个内部类，用于构造Person的必要信息，外部调用Person的构造方法时候，可以这样使用：

```java
Person person=new Person.PersonBuilder().basicInfo("zhangsan",10).address("xxx").build(); 
```

![UML](https://cdn.nlark.com/yuque/0/2020/png/757806/1608082733156-6725c22c-78d1-4c52-b661-e932a46ee43d.png)

还有一种关于set构造器的编写方式是每次返回this, 这样可以实现“链式构造”

```java
public class Person {
    private String name;
    private int age;
    // 省略get方法
    public Person name(String name) {
        this.name = name;
        return this;
    }

    public Person age(int age) {
        this.age = age;
        return this;
    }
}
```

主方法在调用的时候可以直接：

```java
Person p=new Person();
p.age(10).name("zhangsan");
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

java.io jdbc-odbc bridge ASM transformer

## 桥接模式

抽象和具体的发展单独分支，抽象中持有一个具体的引用 使用桥接模式： 分离抽象与具体实现，让他们可以独自发展 Gift -> WarmGift ColdGift WildGiftGiftImpl -> Flower Ring Car

## 命令模式

结合责任链模式实现多次undo 结合组合模式实现宏命令 结合记忆模式实现transaction回滚

## 原型模式

Object.clone()

## 备忘录模式

记录状态，记录快照，瞬时状态，存盘 Tank的GameModel的load/save方法（实现序列化接口） 便于回滚

## 模板方法

钩子函数 RestTemplate JDBCTemplate

## State模式

状态迁移

## 解释器模式

## UML和代码

[UML图](https://www.processon.com/view/link/5e93b9e1e0b34d6feaa65b19)

[代码](https://github.com/GreyZeng/dp)

## 参考资料

- [坦克大战-马士兵](https://ke.qq.com/course/398245)

- [菜鸟教程-设计模式](https://www.runoob.com/design-pattern/design-pattern-tutorial.html)

- [极客时间-设计模式之美-王争](https://time.geekbang.org/column/intro/250)

- [极客时间-小马哥讲Spring核心编程思想-小马哥](https://time.geekbang.org/course/intro/100042601)