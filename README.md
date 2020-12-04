# 设计模式

https://www.yuque.com/docs/share/a20452c8-ab69-4ecb-ab13-b61c29e5cb58?#

# 单例模式
![image.png](https://cdn.nlark.com/yuque/0/2020/png/757806/1585815368299-cf029297-38cf-493d-9e91-7155d03af486.png#align=left&display=inline&height=339&margin=%5Bobject%20Object%5D&name=image.png&originHeight=339&originWidth=241&size=13840&status=done&style=none&width=241)<br />**DCL 需要加volatile，涉及Jvm的指令重排, 会生成一个半初始化的对象**<br />**![image.png](https://cdn.nlark.com/yuque/0/2020/png/757806/1585834535417-d0bc227e-2623-41ba-ac8c-1f6b71ae8dea.png#align=left&display=inline&height=153&margin=%5Bobject%20Object%5D&name=image.png&originHeight=153&originWidth=401&size=9665&status=done&style=none&width=401)**<br />**<br />

<a name="mwQn2"></a>
# 策略模式
应用：jdk中的Comparable接口和Comparator接口<br />![image.png](https://cdn.nlark.com/yuque/0/2020/png/757806/1585876508201-2a10502a-777e-48af-80e2-415d547be72a.png#align=left&display=inline&height=270&margin=%5Bobject%20Object%5D&name=image.png&originHeight=270&originWidth=482&size=21261&status=done&style=none&width=482)
<a name="JDlHT"></a>
# 工厂模式

1. 简单工厂
1. 静态工厂--单例模式
1. 抽象工厂
1. 工厂方法
1. Spring IOC DI
1. Hibernate 换数据库只需换方言和驱动就可以
<a name="NnvnT"></a>
# 门面模式
对外<br />消息中间件<br />GameModel
<a name="7LHgE"></a>
# 调停者模式
对内<br />消息中间件<br />GameModel<br />

<a name="Njinp"></a>
# 责任链模式
碰撞检测<br />Servlet filter<br />Structs interceptor<br />SpringMVC interceptor<br />

<a name="fXXqh"></a>
# 装饰器模式
IO流，<br />Read/InputStream<br />Write/OutputStream<br />Tail/RectDecrator<br />

<a name="ctWeQ"></a>
# 观察者模式
事件处理<br />往往和责任链模式搭配使用
<a name="ZlooJ"></a>
# 组合模式
树的遍历
<a name="O4fSI"></a>
# 享元模式
String<br />连接池管理
<a name="6Wx9N"></a>
# 代理模式
静态代理<br />[https://gitee.com/greyzeng/dp/tree/master/src/main/java/com/mashibing/dp/proxy/v07](https://gitee.com/greyzeng/dp/tree/master/src/main/java/com/mashibing/dp/proxy/v07)<br />
<br />动态代理<br />jdk自带<br />**ASM操作二进制码**<br />**Java Instrumentation **<br />**cglib--> final类不行，代理类的子类 底层也是ASM**<br />Spring AOP<br />

<a name="VBqp8"></a>
# 迭代器模式
容器和容器遍历<br />数组结构的物理结构只有：数组和链表<br />其他都是逻辑结构<br />

<a name="liJuk"></a>
# 访问者模式

<br />在**结构不变**的情况下动态改变对于内部元素的动作<br />做编译器的时候，生成AST的时候，进行类型检查<br />根据抽象语法树，生成中间代码<br />XML文件解析<br />

<a name="Hf6XH"></a>
# 构建器模式
链式编程<br />

<a name="saOgg"></a>
# 适配器模式
java.io<br />jdbc-odbc bridge<br />ASM transformer<br />

<a name="N68K4"></a>
# 桥接模式
抽象和具体的发展单独分支，抽象中持有一个具体的引用<br />使用桥接模式：<br />分离抽象与具体实现，让他们可以独自发展<br />Gift -> WarmGift ColdGift WildGiftGiftImpl -> Flower Ring Car<br />

<a name="rktNs"></a>
# 命令模式

<br />结合责任链模式实现多次undo <br />结合组合模式实现宏命令<br />结合记忆模式实现transaction回滚<br />

<a name="xgfUG"></a>
# 原型模式
Object.clone()<br />

<a name="XxVc9"></a>
# 备忘录模式

<br />记录状态，记录快照，瞬时状态，存盘<br />Tank的GameModel的load/save方法（实现序列化接口）<br />便于回滚<br />

<a name="OYjtF"></a>
# 模板方法
钩子函数<br />

<a name="7dEQG"></a>
# State模式
状态迁移
<a name="NYRf4"></a>
# 解释器模式
