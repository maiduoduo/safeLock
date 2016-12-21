package com.xh.lock;

import com.xh.lock.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 安全锁
 * @author xh
 */
public class Lock extends Activity {

	private TextView tip;
	private LinearLayout pfild;
	private EditText p1, p2, p3, p4;
	private ImageView point1,point2,point3,point4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		p1 = (EditText) findViewById(R.id.password1);
		p2 = (EditText) findViewById(R.id.password2);
		p3 = (EditText) findViewById(R.id.password3);
		p4 = (EditText) findViewById(R.id.password4);

		point1 = (ImageView) findViewById(R.id.point1);
		point2 = (ImageView) findViewById(R.id.point2);
		point3 = (ImageView) findViewById(R.id.point3);
		point4 = (ImageView) findViewById(R.id.point4);
		
		tip = (TextView) findViewById(R.id.tip);
		
		pfild = (LinearLayout) findViewById(R.id.passwordfild);

	}

	public void one(View v){
		setValue(1+"");
	}
	
	public void tow(View v){
		setValue(2+"");
	}
	
	public void three(View v){
		setValue(3+"");
	}
	
	public void four(View v){
		setValue(4+"");
	}
	
	public void five(View v){
		setValue(5+"");
	}
	
	public void six(View v){
		setValue(6+"");
	}
	
	public void seven(View v){
		setValue(7+"");
	}
	
	public void eight(View v){
		setValue(8+"");
	}
	
	public void nine(View v){
		setValue(9+"");
	}
	
	public void zero(View v){
		setValue(0+"");
	}
	
	public void ok(View v){
		
	}
	/**
	 * 删除
	 * @param v
	 */
	public void del(View v) {
		if (!TextUtils.isEmpty(p4.getText())) {
			p4.setText("");
			addPoint(3);
		}else if (!TextUtils.isEmpty(p3.getText())) {
			p3.setText("");
			addPoint(2);
		}else if (!TextUtils.isEmpty(p2.getText())) {
			p2.setText("");
			addPoint(1);
		}else if (!TextUtils.isEmpty(p1.getText())) {
			p1.setText("");
			addPoint(0);
		}
	}
	/**
	 * 设值
	 * @param 1、2、3、4、5、6、7、8、9、0
	 */
	private void setValue(String text){
		if (TextUtils.isEmpty(p1.getText())) {
			p1.setText(text);
			addPoint(1);
		}else if (TextUtils.isEmpty(p2.getText())) {
			p2.setText(text);
			addPoint(2);
		}else if (TextUtils.isEmpty(p3.getText())) {
			p3.setText(text);
			addPoint(3);
		}else if (TextUtils.isEmpty(p4.getText())) {
			p4.setText(text);
			addPoint(4);
			submit();
		}
	}

	public void submit() {
		String password = p1.getText().toString() + p2.getText().toString()
				+ p3.getText().toString() + p4.getText().toString();
		System.out.println(password + "");
		if (!TextUtils.isEmpty(password) && password.length() == 4) {
			DBSharedPreferences sharedPreferences = new DBSharedPreferences(
					this);
			if ("nothing".equals(sharedPreferences.getString("password"))) {
				sharedPreferences.putString("password", password);
				Toast.makeText(this, "密码设置成功！", Toast.LENGTH_SHORT).show();
				startActivity(new Intent(Lock.this, Lock.class));
				finish();
			} else {
				if (password.equals(sharedPreferences.getString("password"))) {
					 Toast.makeText(this, "密码正确！", Toast.LENGTH_SHORT).show();
					 //做页面跳转
					 startActivity(new Intent(Lock.this, Lock.class));
					 finish();
				} else {
					
					Animation anim = AnimationUtils.loadAnimation(Lock.this, R.anim.myanim);
					pfild.startAnimation(anim);
					tip.setText("密码不正确！");
					anim.setAnimationListener(new AnimationListener() {
						
						@Override
						public void onAnimationStart(Animation animation) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onAnimationRepeat(Animation animation) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onAnimationEnd(Animation animation) {
							// TODO Auto-generated method stub
							tip.setText("请输入安全锁密码");
							p4.setText("");
							p3.setText("");
							p2.setText("");
							p1.setText("");
							addPoint(0);
						}
					});
				}
			}
		}
	}
	
	private void addPoint(int position){
		switch (position) {
		case 0:
			point1.setVisibility(View.GONE);
			point2.setVisibility(View.GONE);
			point3.setVisibility(View.GONE);
			point4.setVisibility(View.GONE);
			break;
		case 1:
			point1.setVisibility(View.VISIBLE);
			point2.setVisibility(View.GONE);
			point3.setVisibility(View.GONE);
			point4.setVisibility(View.GONE);
			break;
		case 2:
			point2.setVisibility(View.VISIBLE);
			point1.setVisibility(View.VISIBLE);
			point3.setVisibility(View.GONE);
			point4.setVisibility(View.GONE);
			break;
		case 3:
			point3.setVisibility(View.VISIBLE);
			point1.setVisibility(View.VISIBLE);
			point2.setVisibility(View.VISIBLE);
			point4.setVisibility(View.GONE);
			break;
		case 4:
			point4.setVisibility(View.VISIBLE);
			point1.setVisibility(View.VISIBLE);
			point2.setVisibility(View.VISIBLE);
			point3.setVisibility(View.VISIBLE);
			break;

		default:
			break;
		}
	}
}