package org.ysh.java.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Retention定义了该Annotation被保留的时间长短：
 * 某些Annotation仅出现在源代码中，而被编译器丢弃；
 * 而另一些却被编译在class文件中；
 * 编译在class文件中的Annotation可能会被虚拟机忽略，而另一些在class被装载时将被读取（请注意并不影响class的执行，因为Annotation与class在使用上是被分离的）。
 * 使用这个meta-Annotation可以对 Annotation的“生命周期”限制。
 * 
 * 取值（RetentionPoicy）有：

　　　　1.SOURCE:在源文件中有效（即源文件保留）
　　　　2.CLASS:在class文件中有效（即class保留）
　　　　3.RUNTIME:在运行时有效（即运行时保留）

	
 * @Documented用于描述其它类型的annotation应该被作为被标注的程序成员的公共API，
 * 因此可以被例如javadoc此类的工具文档化。Documented是一个标记注解，没有成员。
 * @author yshin1992
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column {

	public String name() default "fieldName";
	
	public String setFuncName() default "setField";
	
	public String getFuncName() default "getField";
	
	public boolean defaultDBValue() default false;
	
}
