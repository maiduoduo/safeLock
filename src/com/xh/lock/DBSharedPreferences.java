package com.xh.lock;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
/**
 * SharedPreferences工具类
 * 
 * @author xh
 *
 */
public class DBSharedPreferences {
	
	private Context context;
	public static final String _NAME = "DIARY_DB";
	public static final String _USERD = "_USERD";

	public DBSharedPreferences(Context context) {
		this.context = context;
	}

	// ///////////////////////////////////////////String///////////////////////////////////////////////////
	public void putString(String key, String value) {
		SharedPreferences sp = context.getSharedPreferences(_NAME, 1);
		Editor editor = sp.edit();
		editor.putString(key, value);
		editor.commit();
	}

	public String getString(String key) {
		SharedPreferences sp = context.getSharedPreferences(_NAME, 1);
		return sp.getString(key, "nothing");
	}

	// ///////////////////////////////////////////Integer///////////////////////////////////////////////////
	public void putInteger(String key, int value) {
		SharedPreferences sp = context.getSharedPreferences(_NAME, 1);
		Editor editor = sp.edit();
		editor.putInt(key, value);
		editor.commit();
	}

	public Integer getInteger(String key) {
		SharedPreferences sp = context.getSharedPreferences(_NAME, 1);
		return sp.getInt(key, -1);
	}

	// ///////////////////////////////////////////Boolean///////////////////////////////////////////////////
	public void putBoolean(String key, boolean value) {
		SharedPreferences sp = context.getSharedPreferences(_NAME, 1);
		Editor editor = sp.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	public boolean getBoolean(String key) {
		SharedPreferences sp = context.getSharedPreferences(_NAME, 1);
		return sp.getBoolean(key, false);
	}

	// ///////////////////////////////////////////Long///////////////////////////////////////////////////
	public void putLong(String key, long value) {
		SharedPreferences sp = context.getSharedPreferences(_NAME, 1);
		Editor editor = sp.edit();
		editor.putLong(key, value);
		editor.commit();
	}

	public long getLong(String key) {
		SharedPreferences sp = context.getSharedPreferences(_NAME, 1);
		return sp.getLong(key, -1);
	}

	// ///////////////////////////////////////////Float///////////////////////////////////////////////////
	public void putFloat(String key, float value) {
		SharedPreferences sp = context.getSharedPreferences(_NAME, 1);
		Editor editor = sp.edit();
		editor.putFloat(key, value);
		editor.commit();
	}

	public float getFloat(String key) {
		SharedPreferences sp = context.getSharedPreferences(_NAME, 1);
		return sp.getFloat(key, 0.0F);
	}
	
//	/**
//	 * 瀛樺偍Agent瀵硅薄
//	 * 
//	 * 閲囩敤Base64鍔犲瘑鏂瑰紡瀛樺叆SharedPreferences
//	 * @param agent
//	 */
//	public void saveUser(Agent agent){
//		SharedPreferences sp = context.getSharedPreferences(_NAME, 1);
//		Editor editor = sp.edit();
//		ByteArrayOutputStream bos = new ByteArrayOutputStream();  
//		ObjectOutputStream oos;
//		try {
//			oos = new ObjectOutputStream(bos);
//			oos.writeObject(agent);  
//			//瀵筨yte[]杩涜Base64缂栫爜   
//			String base64String = new String(Base64.encode(bos.toByteArray(),2045));  
//			editor.putString("USER", base64String);  
//			editor.commit();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
//	}
//	/**
//	 * 鑾峰彇Agent瀵硅薄
//	 * @return
//	 */
//	public Agent getUser(){
//		SharedPreferences sp = context.getSharedPreferences(_NAME, 1);
//		String str = sp.getString("USER", null);
//		if (!CheckUtil.isEmpty(str)) {
//			
//			try {
//				byte[] bytes = Base64.decode(str,2045);  
//				ByteArrayInputStream bis = new ByteArrayInputStream(bytes);  
//				ObjectInputStream ois = new ObjectInputStream(bis);
//				Agent agent = (Agent) ois.readObject(); 
//				return agent;
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}  
//			
//		}
//		return null;
//	}
}