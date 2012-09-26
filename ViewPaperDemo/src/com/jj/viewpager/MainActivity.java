package com.jj.viewpager;

import java.util.ArrayList;

import com.jj.viewpager.R.color;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/***
 * ViewPager
 * 
 * @author zhangjia
 * 
 */
public class MainActivity extends ActivityGroup implements OnClickListener {
	private LinearLayout layout;// title
	private ViewPager pager;
	private ArrayList<View> pageViews;
	private LinearLayout layout2;
	private ArrayList<ImageView> imageViews;
	private LinearLayout linearLayout;
	private String title[] = { "one", "two", "three" };
	private TextView textView;
	private ArrayList<View> arrayList;// ����װ��view
	private final int linerlayout_height = 80;

	/***
	 * init title and pageview
	 */
	void Init() {
		arrayList = new ArrayList<View>();
		// ��ȡ��Ļ���
		int width = getWindowManager().getDefaultDisplay().getWidth()
				/ title.length;
		for (int i = 0; i < title.length; i++) {
			textView = new TextView(this);
			textView.setText(title[i]);
			textView.setWidth(width);
			textView.setHeight(linerlayout_height - 10);
			textView.setTextSize(20);
			textView.setTextColor(color.black);
			textView.setGravity(Gravity.CENTER);
			textView.setId(i);
			textView.setPadding(5, 5, 5, 5);
			textView.setOnClickListener(this);
			linearLayout.addView(textView);
			arrayList.add(textView);
		}

		pageViews = new ArrayList<View>();
		View view00 = getLocalActivityManager().startActivity("activity01",
				new Intent(this, NullActivity.class)).getDecorView();
		View view01 = getLocalActivityManager().startActivity("activity01",
				new Intent(this, MainActivity1.class)).getDecorView();
		View view02 = getLocalActivityManager().startActivity("activity02",
				new Intent(this, MainActivity2.class)).getDecorView();
		View view03 = getLocalActivityManager().startActivity("activity02",
				new Intent(this, MainActivity3.class)).getDecorView();
		View view04 = getLocalActivityManager().startActivity("activity01",
				new Intent(this, NullActivity.class)).getDecorView();
		pageViews.add(view00);
		pageViews.add(view01);
		pageViews.add(view02);
		pageViews.add(view03);
		pageViews.add(view04);
	}

	void Init_Point() {
		imageViews = new ArrayList<ImageView>();
		ImageView imageView;
		for (int i = 0; i < pageViews.size(); i++) {
			imageView = new ImageView(this);
			imageView.setLayoutParams(new LayoutParams(5, 5));
			imageView.setBackgroundResource(R.drawable.d1);
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
					new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT));
			layoutParams.leftMargin = 20;
			layoutParams.rightMargin = 20;
			layout2.addView(imageView, layoutParams);
			// ��һ�������һ��������ʧ
			if (i == 0 || i == pageViews.size() - 1) {
				imageView.setVisibility(View.GONE);
			}
			if (i == 1) {
				imageView.setBackgroundResource(R.drawable.d2);
			}
			imageViews.add(imageView);

		}
	}

	public void draw_Point(int index) {
		for (int i = 1; i < imageViews.size(); i++) {

			if (index == i) {
				imageViews.get(i).setBackgroundResource(R.drawable.d2);
			} else
				imageViews.get(i).setBackgroundResource(R.drawable.d1);

		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("jjhappyforever...");
		setContentView(R.layout.main);
		pager = (ViewPager) findViewById(R.id.vp_contains);
		layout2 = (LinearLayout) findViewById(R.id.iv_image);
		linearLayout = (LinearLayout) findViewById(R.id.mian);
		// ����linerlayout�Ĵ�С
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,
						LayoutParams.FILL_PARENT));
		layoutParams.height = linerlayout_height;
		linearLayout.setLayoutParams(layoutParams);

		Init();
		Init_Point();
		pager.setAdapter(new myPagerView());

		arrayList.get(0).setBackgroundResource(
				R.drawable.renren_sdk_pay_repair_btn_down);
		pager.setCurrentItem(1);

		pager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int arg0) {
				draw_Point(arg0);// ����ҳ�㣬һ��Ҫд������.

				// Toast.makeText(MainActivity.this, ""+arg0, 1000).show();
				// ����ǵ�һ�����������һ����ֹ��������ʵ����ʵ�ֵ�������������ǵ�һ������ת���ڶ�������������һ������ת�������ڶ���.
				if (arg0 == imageViews.size() - 1 || arg0 == 0) {
					if (arg0 == 0) {
						pager.setCurrentItem(arg0 + 1);// �ڶ��� ���ٴ�ʵ�ָûص�����ʵ����ת.
						imageViews.get(1).setBackgroundResource(R.drawable.d2);
					} else {
						pager.setCurrentItem(arg0 - 1);// �����ڶ���
						imageViews.get(arg0 - 1).setBackgroundResource(
								R.drawable.d2);
					}
				} else {
					setBackgroud(arg0 - 1);
					Toast.makeText(MainActivity.this, "" + arg0, 1000).show();
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}
    /***
     * ��title ѡ�����
     * @param index
     */
	public void setBackgroud(int index) {
		for (int i = 0; i < arrayList.size(); i++) {
			
			arrayList.get(i).setBackgroundDrawable(new BitmapDrawable());

			if (i == index)
				arrayList.get(index).setBackgroundResource(
						R.drawable.renren_sdk_pay_repair_btn_down);
		}

	}
    /***
     * viewpager ������Դ
     * @author zhangjia
     *
     */
	class myPagerView extends PagerAdapter {
		// ��ʾ��Ŀ
		@Override
		public int getCount() {
			return pageViews.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public int getItemPosition(Object object) {
			// TODO Auto-generated method stub
			return super.getItemPosition(object);
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			// TODO Auto-generated method stub
			((ViewPager) arg0).removeView(pageViews.get(arg1));
		}

		/***
		 * ��ȡÿһ��item�� ����listview�е�getview
		 */
		@Override
		public Object instantiateItem(View arg0, int arg1) {
			((ViewPager) arg0).addView(pageViews.get(arg1));
			return pageViews.get(arg1);
		}

	}
    /***
     * ����¼�
     */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case 0:
			setBackgroud(0);
			pager.setCurrentItem(1);
			break;
		case 1:
			setBackgroud(1);
			pager.setCurrentItem(2);
			break;
		case 2:
			setBackgroud(2);
			pager.setCurrentItem(3);
			break;

		default:
			break;
		}
	}
}
