package io.viva.meowshow.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import android.util.Log;

/**
 * 反射操作
 */
public class BeanUtils {

	/**
	 * 通过反射方式给某个对象某个字段重新赋值
	 * 
	 * @param object
	 *            反射对象
	 * @param field
	 *            对象内部的变量
	 * @param value
	 *            赋值
	 */
	public static void setFieldValue(Object object, String field, Object value) {
		Field localField = getDeclaredField(object, field);
		if (localField == null) {
			throw new IllegalArgumentException("Could not find field [" + field
					+ "] on target [" + object + "]");
		}
		makeAccessible(localField);
		try {
			localField.set(object, value);
		} catch (IllegalAccessException e) {
			Log.e("", "", e);
		}
	}

	/**
	 * 获取某个对象某个字段
	 * 
	 * @param object
	 *            反射对象
	 * @param field
	 *            反射内部成员名称
	 * @return 发射类内部成员
	 */
	protected static Field getDeclaredField(Object object, String field) {
		return getDeclaredField(object.getClass(), field);
	}

	/**
	 * 获取某个类对象某个字段
	 * 
	 * @param clazz
	 *            对象类名
	 * @param field
	 *            反射内部成员名称
	 * @return 发射类内部成员
	 */
	protected static Field getDeclaredField(Class<?> clazz, String field) {
		Class<?> c = clazz;
		while (c != Object.class)
			try {
				return c.getDeclaredField(field);
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
		return null;
	}

	/**
	 * 设置某个对象的某个字段可修改
	 * 
	 * @param field
	 *            发射类
	 */
	protected static void makeAccessible(Field field) {
		if ((!Modifier.isPublic(field.getModifiers()))
				|| (!Modifier
						.isPublic(field.getDeclaringClass().getModifiers()))) {
			field.setAccessible(true);
		}
	}
}
