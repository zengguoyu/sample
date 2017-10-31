package com.kenny.common.utils.converter;

/**
 * 类型转换器接口，该接口与{@link IConverter}相对，是 {@link IConverter}的逆向
 * 
 * @author kenny
 *
 * @param <E>
 * @param <T>
 */
public interface IConverterReverse<E, T>  extends IConverter<T, E>{
	/**
	 * 将
	 * @param t
	 * @return
	 */
	E reverseConvert(T t);

}
