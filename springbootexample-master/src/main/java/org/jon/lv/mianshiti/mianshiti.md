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