package io.viva.meowshow.utils;

import java.util.Iterator;

import android.os.Bundle;
import android.util.Log;

/**
 * 用于bundle处理
 */
public class BundleUtils {

	/**
	 * 以某一个tag打印bundle数据
	 * @param bundle
	 * @param tag
	 */
	public static void print(Bundle bundle, String tag) {
		if (bundle == null) {
			return;
		}
		Iterator<String> it = bundle.keySet().iterator();
		while (it.hasNext()) {
			String str = it.next();
			if (str != null) {
				Log.i(tag, "BundleUtils -- print -- key:" + str + ",value:" + bundle.get(str).toString());
			}
		}
	}
}
