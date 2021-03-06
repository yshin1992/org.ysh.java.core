示例代码顺序
1.ExtendSample,Manager(详解继承和类型转换)
2.PreventExtendSample(阻止继承)
3.AbstractClassSample(抽象类)
4.ProtectedSample(Protected修饰符)
5.ObjectSample(所有类的超类Object)
6.EqualsSample(equals方法书写建议)
7.HashCodeSample
8.ToStringSample
9.ListSample(泛型数组)
10.AutoBoxSample(自动拆箱和自动装箱)
11.EnumSample(枚举常量实例)
12.ClassSample(java.lang.reflect.Class)
13.ReflectSample(反射类的构造函数，域，和方法名)
14.ObjectAnalyzerSample(反射类的属性域，完成通用toString方法)
15.ArrayGrowSample(数组扩展)
16.MethodPointSample(Java中的方法指针)

继承设计的技巧
1.将公共操作和域放在超类
2.不要使用受保护的域
3.使用继承实现“is-a”关系
4.除非所有继承的方法都有意义，否则不要使用继承
5.在覆盖方法时，不要改变预期的行为
6.使用多态，而非类型信息
7.不要过多的使用反射