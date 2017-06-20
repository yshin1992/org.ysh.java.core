package org.ysh.java.core.annotation.sample;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface FruitName {
	String value() default "";
}
