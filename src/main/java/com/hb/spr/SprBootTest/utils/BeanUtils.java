package com.hb.spr.SprBootTest.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * bean相关工具
 * 
 * @author Admin
 *
 */
public class BeanUtils {
	public static <T extends Object> List<Field> getFields(T bean) {
		if (bean == null)
			return null;
		Class<? extends Object> clazz = bean.getClass();
		List<Field> fs = new ArrayList<Field>();
		do {
			Field[] fArray = clazz.getDeclaredFields();
			if (fArray != null)
				fs.addAll(Arrays.asList(clazz.getDeclaredFields()));
			clazz = clazz.getSuperclass();
		} while (Object.class.equals(clazz));
		return fs;
	}

	public static <T extends Object> String toString(T bean) {
		if (bean == null)
			return "";
		List<Field> fs = getFields(bean);
		StringBuffer buffer = new StringBuffer(bean.getClass().getName() + " [");
		for (Field f : fs) {
			buffer.append(f.getName() + ":");
			buffer.append(StringUtils.ifNull(fieldValue(bean, f), "null"));
			buffer.append(",");
		}
		if (buffer.length() > 1)
			buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("]");
		return buffer.toString();
	}

	public static <T extends Object> Object fieldValue(T bean, Field f) {
		try {
			f.setAccessible(true);
			return f.get(bean);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
