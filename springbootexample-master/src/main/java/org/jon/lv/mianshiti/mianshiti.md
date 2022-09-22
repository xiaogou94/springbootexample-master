1#.

2#.类加载机制

3#.深拷贝和浅拷贝的区别?
深拷贝和浅拷贝是针对于对象属性为对象的，因为基本数据类型在进行赋值操作的时候是直接将赋值给了新变量，也就是该变量
是原变量的一个副本，这个时候你修改两者中其中一个不会影响另外一个，而对于对象或者引用数据来说进行浅拷贝的时候，只是将
对象的引用复制了一份，也就是内存地址，也就是两个不同的变量指向了同一个地址，那么改变任一个变化的值都是该这个内存所存储
的值，所以两个变量的值都会被改变

4#.垃圾回收原理和标记清除法原理
可达性分析法思路是：将一系列的跟对象作为起始点,从这些节点开始向下搜索，搜索所走过的路径称为引用链，如果一个对象到跟对象
没有任何引用链相连，那么这个对象就是不可达的，也称为不可达对象。
标记清除法为了解决引用计数法的问题而提出的，首先标记出所需要收回的对象，在标记完成后统一回收所有标记的对象，它的标记过程
其实就是前面的可达性分析法中判定垃圾对象的标记过程。
优点：不需要进行对象的移动，并且对不存活的对象进行处理，在存活对象比较多的情况下极为高效
缺点：标记和清除的效率不高，需要一个空闲列表，标记清除后会产生大量不连续的内存碎片。

5#.sychorized底层原理和作用
在Java虚拟机执行到monitorenter指令的时候，1、首先它会尝试获取对象的锁，如果该对象没有锁，或者当前线程已经拥有
这个对象的锁时候，它会把计数器+1，然后执行到monitorexit指令时就会将计数器-1，然后计数器为0时候，锁就释放掉。2、
如果获取锁失败，那么当前线程就要阻塞等待，直到对象锁被另一个线程释放为止。

6#.线程池用过没，自定义过策略没
查看threadpool包下的类

7#.Springioc和aop,关于aop和两种实现详细说说
jdk动态代理利用反射机制生成一个实现代理接口的匿名类，在调用方法前用InvokeHandler来处理
cglib动态代理利用asm开源包，吧代理对象类的class文件加载进来，通过修改其字节码生成子类来处理
1.如果目标对象实现了接口，默认情况下采用jdk代理
2.如果目标对象实现了接口，可以强制转换
3.如果目标对象没有实现了接口，必须采用CGlib库

如何强制使用CGLIB实现AOP？
（1）添加CGLIB库，SPRING_HOME/cglib/*.jar
（2）在spring配置文件中加入<aop:aspectj-autoproxy proxy-target-class=“true”/>

JDK动态代理和CGLIB字节码生成的区别？
（1）JDK动态代理只能对实现了接口的类生成代理，而不能针对类
（2）CGLIB是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法
因为是继承,所以该类或方法最好不要声明成final


8#.mysql b+树
https://blog.csdn.net/lcczpp/article/details/123100710

9#.String和StringBuffer和StringBuiler区别，String为什么不可变
（1） 如果要操作少量的数据，建议用String；

（2） 如果在多线程操作字符串缓冲区下操作大量的数据，建议使用SreingBuffer；

（3） 如果在单线程操作字符串缓冲区下操作大量数据，建议使用StringBuilder。

String不可变的原因：
1.保存字符串的数组被final修饰并且为私有的，并且String类里面没有提供修改这个字符串的方法
2.String类被final修饰导致其不能被继承，进而避免了子类破坏String类

10#.hashtable和hashMap区别，currentHashMap和hashTable区别
1.继承的父类不同，hashMap继承自AbstractMap类，hashTable继承于Dictionary类
2.hashMap不安全，hashTable安全
https://blog.csdn.net/xuhuaabc/article/details/91475761


11#.synchronized机制和Lock对比
特性：synchronized是Java的关键字，Lock是J.U.C包中的接口
获取：A获取锁，B等待，A阻塞，B一直等待，Lock可尝试获取锁，线程可以一直不用在等待
释放：执行完同步代码或者发送异常，被动释放，Lock在finally释放锁，避免死锁
状态：无法判断，Lock可以判断
类型：可以重入,不可中断,非公平,Lock可重入,可判断,可公平,可非公平,
性能：少量同步,Lock大量同步,
首先synchronized是Java内置关键字，在JVM层面，Lock是个Java类；
synchronized 可以给类、方法、代码块加锁；而 lock 只能给代码块加锁。
synchronized 不需要手动获取锁和释放锁，使用简单，发生异常会自动释放锁，不会造成死锁；而 lock 需要自己加锁和释放锁，如果使用不当没有 unLock()去释放锁就会造成死锁。
通过 Lock 可以知道有没有成功获取锁，而 synchronized 却无法办到。


12#. 多线程的优劣势？
多线程：多线程是指程序中包含多个执行流，既在一个程序中可以同时运行多个不同的线程执行不同的任务
多线程好处：可以提高cpu的使用率，在多个线程程序中，一个线程必须等待的时候，CPU可以运行其他线程而不是等待，这样就大大
提高了程序的效率，也就是说允许单个程序创建并执行线程来完成任务
多线程劣势：多线程也是程序，所以线程需要占用内存，线程越多占用内存也越多；多线程需要协调和管理，所以需要CPU时间跟踪线程；
线程之间对共享的访问会互相影响，必须解决竞用共享资源的问题。

13#. runnable和callable?
相同：都是接口；都可以编写多线程；都采用Thread.start()启动线程
区别：Runnable接口run没有返回值，只能抛出异常，且无法捕捉处理；Callable接口call有个返回值，是个泛型，和Future、FutureTask
配合可以用来获取异步执行的结果，Call方法允许抛出异常。

14#. sleep和wait的区别？
类的不同：sleep()是Thread线程类的静态方法，wait()是Object类的方法
是否释放锁：sleep()不释放，wait()释放锁
用途不同：wait通常被用于线程间交互/通信，sleep通常被用于暂停执行
用法不同：wait()方法被调用后，线程不会自动苏醒，需要别的线程调用同一对象上的notify()或者notifyAll()方法
sleep()执行完成，线程会自动苏醒，或者可以使用wait(long timeout)超时后线程自动苏醒。

15#. 为什么 wait(), notify()和 notifyAll()必须在同步方法或者同步块中被调用?
由于所有的这些方法都需要线程持有对象的锁，这样就只能通过同步来实现，所以他们只能实现同步方法或者同步代码块中被调用

16#. 线程sleep()方法和yield()方法有什么区别？
1.sleep方法给其他线程运行机会不考虑线程的优先级，因此会给低优先级运行的机会，yield方法只会给优先级或者更高优先级线程机会
2.线程执行sleep方法进入阻塞blocked状态，而yield方法后转入就绪ready状态。
3.sleep方法声明抛出interruptedException,而yield方法没有声明任何异常
4.sleep比yield方法，具有更好的可移植性，通常不建议使用yield()方法控制并发线程

17#.多线程之间的通信？
1.使用volatile关键字
2.使用Object类的wait()/notify()
3.使用JUC工具类CountDownLatch
4.使用ReentrankLock结合Condition
5.LockSupport实现线程间的阻塞和唤醒

18#.如果你提交任务时候，线程池队列已满，这时候会发生什么？
如果是无界队列LinkedBlockingQueue,也就是无界队列，没关系，继续添加任务到阻塞队列中等待执行，因为LinkedBlockingQueue
可以近乎一个无穷大的队列，可以无限存放任务
如果是有界队列比如是ArrayBlockingQueue,任务首先会被添加到ArrayBlockingQueue中，ArrayBlockingQueue满了，
会根据maximunPoolSize的值增加线程数量，如果增加了线程数量还是处理不过来，ArrayBlockingQueue继续满，那么就会
使用拒绝策略RejectedExecutionHandler处理满了的任务，默认是AbortPolicy

19#.多线程中synchronized锁升级的原理？
在锁对象的对象头里面一个threadid字段，在第一次访问的时间threadid为空，JVM让其持有偏向锁，并将threadid设置为其线程id,
再次进入的时候会先判断threadid是否与其id一致，如果一致则可以直接使用此对象，如果不一致，则升级偏向锁为轻量级锁，通过自旋
一定的次数获取锁，执行一定次数后，如果还没有正常获取到要使用的对象，此时会把锁从轻量锁升级为重量级锁，此过程就构成了锁升级。

20#. synchronized 和 ReentrantLock区别是什么？
相同点：两个都是可重入锁，可重入锁概念是：自己可以再次获取自己的内部锁，比如一个线程获取了某个对象的锁，此时这个对象
锁还没有释放，与其再次想获取这个对象的锁还是可以获取的，如果不可锁重入的话，就会造成死锁，同一个线程每次获取锁，锁的
计数器都增1，所以要等到锁的计数器下降为0才能释放锁。
主要区别如下：

ReentrantLock 使用起来比较灵活，但是必须有释放锁的配合动作；
ReentrantLock 必须手动获取与释放锁，而 synchronized 不需要手动释放和开启锁；
ReentrantLock 只适用于代码块锁，而 synchronized 可以修饰类、方法、变量等。
二者的锁机制其实也是不一样的。ReentrantLock 底层调用的是 Unsafe 的park 方法加锁，synchronized 操作的应该是对象头中 mark word


21#. synchronized 和 volatile 的区别是什么？
synchronized表示只有一个线程可以获取作用于对象的锁，执行代码，阻塞其他线程。
volatile表示变量在CPU的寄存区是不确定的，必须从主存中读取，保证多线程环境下变量的可见性，禁止指令重排序。
volatile 是变量修饰符；synchronized 可以修饰类、方法、变量。
volatile 仅能实现变量的修改可见性，不能保证原子性；而 synchronized 则可以保证变量的修改可见性和原子性。
volatile 不会造成线程的阻塞；synchronized 可能会造成线程的阻塞。
volatile标记的变量不会被编译器优化；synchronized标记的变量可以被编译器优化。
volatile关键字是线程同步的轻量级实现，所以volatile性能肯定比synchronized关键字要好。但是volatile关键字只能用于变量而synchronized关键字可以修饰方法以及代码块。synchronized关键字在JavaSE1.6之后进行了主要包括为了减少获得锁和释放锁带来的性能消耗而引入的偏向锁和轻量级锁以及其它各种优化之后执行效率有了显著提升，实际开发中使用 synchronized 关键字的场景还是更多一些。

22#. cas？
CAS是compare and swap的缩写，即我们所说的比较交换，cas是一种基于锁的操作，而且是乐观锁，在Java中锁分为乐观锁和悲观锁
悲观锁是将资源锁住，等之前获得锁的线程释放锁之后，下一个线程才可以访问，而乐观锁采用了一种宽泛的态度，通过某种不加锁的处理，
比如通过给记录加version来获取数据，性能较悲观锁有很大的提高。
cas操作包含三个数，内存位置(V),预期原值（A）,和新值（B）,如果内存地址里面的值和A的值一样的，那么就将内存里面的值换成B,
CAS是通过无限循环来获取数据的，若果在第一轮循环中，a线程获取地址里面的值被b线程修改了，那么a线程需要自旋，到下次循环才有
可能机会执行，java.util.concurrent.atomic包下的类大多是使用CAS操作来实现的(AtomicInteger,AtomicBoolean,AtomicLong)

23#. 锁升级
在Java中，锁共有4中状态，级别从低到高依次为：无状态锁，偏向锁，轻量级锁和重量级锁状态，这几个状态会随着竞争情况逐渐升锁，
锁可以升级但不能降级。

24#. ThreadLocal 是什么？有哪些使用场景?
ThreadLocal是一个本地线程副本变量工具类，在每个线程中都创建一个ThreadLocalMap对象，简单来说ThreadLocal就是一种
以空间换时间的做法，每个线程可以访问自己内部ThreadLocal对象的value,通过这种方式，避免资源在多线程间共享。

25#.ThreadLocal造成内存泄漏的原因？和方案？
threadLocalMap中使用的key为ThreadLocal的弱引用，而value是强引用，所以threadLocal没有在外部强引用的情况下，而垃圾
回收的时候，key就被清理掉，而value不会被清理， 这样一来，ThreadLocalaMap就会出现key为null的Entry,假如我们不做任何
措施的话，value永远无法为GC回收，这个时候就可能产生内存泄漏，ThreadLocalMap实现中已经考虑了这种情况，在调用set(),get()
,remove()方法的时候，会清理掉key为null的记录，使用完ThreadLocal方法后，最好手动调用remove()方法

26#.线程池有哪些状态？
running：这是最正常的状态，接受新的任务，处理等待队列的任务
shutdown: 不再接受新的任务，但是会继续处理等待队列的任务
stop:不再接受新的任务，不再处理等待任务队列，中断正在执行的任务
tidying: 所有的任务都销毁了，workCount为0，线程池的状态在转换为tidying状态时，会执行钩子方法terminated()
terminated: terminated()方法结束后，线程池状态就会变成这个了。

27#.线程中submit()和execute()方法有什么区别
接受参数：execute()只能执行runnable类型的任务，submit()可以执行runnable和Callable类型的任务
返回值：submit()方法可以返回持有计算结果的Future对象，而execute()没有
异常处理：submit()方便Exception处理

28#.mysql的innodb如何解决幻读的？
Innodb引入间隙锁和next-key lock取解决幻读问题
select * from user where id > 4 and id < 7 for update
当对范围查询id>4 and id<7 这个范围加锁的时候，会对针对B+数中（4,7） 这个开区间的范围加间隙锁，意味着在这种情况下其他事务
对这个区间进行插入更新删除都会被锁住，但是还有另一外情况
select * from user where id > 4
这条查询语句针对id>4的这个条件加锁，那么它需要锁定多的索引区间，所以这种情况下Innodb引入一个叫next-key lcok机制，
next-key lock锁，锁定的区间范围是(4,7] (7,10],(10,+~),间隙锁和next-key lock的区别就在加锁的范围，间隙锁锁定的
是两个索引之间的间隙，而next-key lock会锁定多个索引区间，它是包含了记录锁和间隙锁当我们使用范围查询不仅仅命中record记录
还包含Gap间隙的时候，在这种情况下使用的是临锁键，也就是next-key lock它是Mysql里面的默认的行锁算法。
总结：虽然InnoDB里面通过间隙锁方式解决了幻读的问题但是加锁之后一定会影响到并发性能，因此对与性能较高的一些业务场景，我们可以把隔离级别设置不可重复，
那么这个级别不存在间隙锁也不存在这样的一个性能的影响

29#. Springboot启动流程？
1.首先进入run()方法，run方法中new创建了一个SpringApplication实例
2.在SpringApplication的构造方法为SpringApplication对象赋一些初值
3.构造方法执行完成，回到run方法
该方法实现了如下关键步骤：
1.创建了应用监听器SpringApplicationRunListeners并开始监听
2.加载SpringBoot配置环境（ConfigurableEnvironment）,如果是通过Web容器发布，会加载StandardEnvironment
其最终也是继承了ConfigurableEnvironment
3.配置环境（Environment）加入到监听器对象(SpringApplicationRunListeners)
4.创建run方法的返回对象，ConfigurableApplication(应用配置上下文)
5.回到run方法内，prepareContext方法将listener、environment、applicationArguments、banner等重要组件与上下文
对象关联
6.接下来的refreshContext方法，实现将spring-boot-starter-*(mybatis、redis等)自动化配置的关键，包括spring.factories的加载，bean的实例化等核心工作。
7.配置结束后，Springboot做了一些基本的收尾工作，返回了应用环境上下文。回顾整体流程，Springboot的启动，主要创建了配置环境(environment)、事件监听(listeners)、应用上下文(applicationContext)，并基于以上条件，在容器中开始实例化我们需要的Bean，至此，通过SpringBoot启动的程序已经构造完成。

