package com.kenny.common.utils.converter;

/**
 * 类型转换器接口
 * @author kenny
 *
 * @param <T>
 * @param <E>
 */
public interface IConverter<T, E> {
	
	/**
	 * 将类型T转化为类型E
	 * @param t
	 * @return
	 */
	E convert(T t);
}
