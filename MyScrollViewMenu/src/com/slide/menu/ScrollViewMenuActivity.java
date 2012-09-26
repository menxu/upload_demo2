package com.slide.menu;

import com.slide.util.SlideMenuUtil;
import com.test.menu.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Androidʵ�ֵ����˵����һ���Ч��
 * @Description: Androidʵ�ֵ����˵����һ���Ч��

 * @FileName: ScrollViewMenuActivity.java 

 * @Package com.test.menu 

 * @Author Hanyonglu

 * @Date 2012-4-21 ����5:41:29 

 * @Version V1.0
 */
public class ScrollViewMenuActivity extends Activity {
	private HorizontalScrollView horizontalScrollView = null;
	
    /** Called when the activity is first created. */
	private String[] menus = {SlideMenuUtil.ITEM_MOBILE,SlideMenuUtil.ITEM_WEB,
								SlideMenuUtil.ITEM_CLOUD,SlideMenuUtil.ITEM_DATABASE,
								SlideMenuUtil.ITEM_EMBED,SlideMenuUtil.ITEM_SERVER,
								SlideMenuUtil.ITEM_DOTNET,SlideMenuUtil.ITEM_JAVA,
								SlideMenuUtil.ITEM_SAFE,SlideMenuUtil.ITEM_DOMAIN,
								SlideMenuUtil.ITEM_RESEASRCH,SlideMenuUtil.ITEM_MANAGE};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // �����ޱ��ⴰ��
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.menu);
        
        horizontalScrollView = (HorizontalScrollView)findViewById(R.id.horizonMenu);
       
        setSlideMenu();
    }
    
    private void setSlideMenu(){
    	// ����TextView��LinearLayout
		LinearLayout menuLinerLayout = (LinearLayout) findViewById(R.id.linearLayoutMenu);
		menuLinerLayout.setOrientation(LinearLayout.HORIZONTAL);
		// ��������
		LinearLayout.LayoutParams menuLinerLayoutParames = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT, 
				LinearLayout.LayoutParams.WRAP_CONTENT,
				1);
		menuLinerLayoutParames.gravity = Gravity.CENTER_HORIZONTAL;
		
		// ���TextView�ؼ�
    	for(int i = 0;i < menus.length;i++){
    		TextView tvMenu = new TextView(this);
			tvMenu.setLayoutParams(new LayoutParams(30,30)); 
			tvMenu.setPadding(30, 14, 30, 10);
			tvMenu.setText(menus[i]);
			tvMenu.setTextColor(Color.WHITE);
			tvMenu.setGravity(Gravity.CENTER_HORIZONTAL);
			menuLinerLayout.addView(tvMenu,menuLinerLayoutParames);
        }
    }
}