package io.viva.meowshow.utils;

import java.util.List;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class ApkUtils {

	/**
	 * 检查该apk是否已经安装
	 * 
	 * @param context
	 *            上下文环境
	 * @param packageName
	 *            包名
	 * @return 是否安装
	 */
	public static boolean checkApkExist(Context context, String packageName) {
		PackageManager pm = context.getPackageManager();
		List<PackageInfo> list = pm.getInstalledPackages(0);
		for (PackageInfo packageInfo : list) {
			if (packageInfo.packageName.equalsIgnoreCase(packageName)) {
				return true;
			}
		}
		return false;
	}
}
