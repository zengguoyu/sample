package com.kenny.common.utils.converter;

import java.util.ArrayList;
import java.util.List;

public final class Converters {

	public static <T, E> List<E> convertList(List<T> list, IConverter<T, E> converter) {
		List<E> result = new ArrayList<>(list.size());
		for (T t : list) {
			E e = converter.convert(t);
			if (e != null) {
				result.add(e);
			}
		}
		return result;

	}
}
