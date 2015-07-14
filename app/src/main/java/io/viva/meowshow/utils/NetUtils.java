package io.viva.meowshow.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

/**
 * 网络应用类
 */
public class NetUtils {
	private static final String tag = NetUtils.class.getName();

	/**
	 * 当前网络是否已连接
	 * 
	 * @return true标示已连接，false标示没有
	 */
	public static boolean isNetConnected(Context context) {
		try {
			ConnectivityManager connectivity = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (connectivity != null) {
				// 获取网络连接管理的对象
				NetworkInfo[] infos = connectivity.getAllNetworkInfo();
				if (infos != null) {
					for (NetworkInfo info : infos) {
						if (info != null && info.isConnected()) {
							// 判断当前网络是否已经连接
							if (info.getState() == NetworkInfo.State.CONNECTED) {
								return true;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 当前3是否连接
	 * 
	 * @return true标示已连接，false标示没有
	 */
	public static boolean isIn3GConnect(Context context) {
		try {
			ConnectivityManager connectivity = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (connectivity != null) {
				// 获取网络连接管理的对象
				NetworkInfo info = connectivity.getActiveNetworkInfo();
				if (info != null
						&& info.isConnected() // 是否连接
						&& info.getType() != ConnectivityManager.TYPE_WIFI
						&& info.getType() != 9 /* TYPE_ETHERNET */) {
					return true;
				}
			}
		} catch (Exception e) {
		}
		return false;
	}
	
	public static String getMacAddress(Context context) {
		String result = "";     
	     String Mac = "";
	     result = callCmd("busybox ifconfig","HWaddr");
	      
	     if(result!=null){
	    	 //对该行数据进行解析
		     //例如：eth0      Link encap:Ethernet  HWaddr 00:16:E8:3E:DF:67
		     if(result.length()>0 && result.contains("HWaddr")==true){
		         Mac = result.substring(result.indexOf("HWaddr")+6, result.length()-1);
		         Log.i("test","Mac:"+Mac+" Mac.length: "+Mac.length());
		          
		         if(Mac.length()>1){
		             Mac = Mac.replaceAll(" ", "");
		             result = "";
		             String[] tmp = Mac.split(":");
		             for(int i = 0;i<tmp.length;++i){
		                 result +=tmp[i];
		             }
		         }
		         return result;
		     }
	     } else {
	    	 WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
	    	 
	    	 WifiInfo info = wifi.getConnectionInfo();
	    	  
	    	 return info.getMacAddress();
	     }
	     
	     return "";
	}
	
	private static String callCmd(String cmd,String filter) {   
	     String result = "";   
	     String line = "";   
	     try {
	         Process proc = Runtime.getRuntime().exec(cmd);
	         InputStreamReader is = new InputStreamReader(proc.getInputStream());   
	         BufferedReader br = new BufferedReader (is);   
	          
	         //执行命令cmd，只取结果中含有filter的这一行
	         while ((line = br.readLine ()) != null && line.contains(filter)== false) {   
	             //result += line;
	             Log.i("test","line: "+line);
	         }
	          
	         result = line;
	         Log.i("test","result: "+result);
	     }   
	     catch(Exception e) {   
	         e.printStackTrace();   
	     }   
	     return result;   
	 }
}
