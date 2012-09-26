package com.mylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */

	private DataItemListAdapter adapter = null;
	private ArrayList<DataItem> list;
	Map<String, Object> map = new HashMap<String, Object>();
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		list = getData();
		adapter = new DataItemListAdapter(MainActivity.this, R.layout.mylist, list);
		ListViewInterceptor tlv = (ListViewInterceptor) findViewById(R.id.list);
		tlv.setAdapter(adapter);
		tlv.setDropListener(onDrop);

		tlv.getAdapter();
	}
	
	private ListViewInterceptor.DropListener onDrop = new ListViewInterceptor.DropListener() {
		@Override
		public void drop(int from, int to) {
			
//			DataItem item = adapter.getItem(from);
			DataItem item = list.get(from);
			adapter.remove(item);
			adapter.insert(item, to);
			
		}
	};

	private ArrayList<DataItem> getData() {
		 ArrayList<DataItem> list = new  ArrayList<DataItem>();

		
		for(int i = 0 ;i < 20 ;i++){
			DataItem dataItem = new DataItem(i, "title " + i ,
					"content " + i, null, "text", 1, i, 0);
			list.add(dataItem);
		}
		return list;
	}
}