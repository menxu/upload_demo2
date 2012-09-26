package com.mylist;

public class DataItem{
	  public int id;	 
	  public String title;
	  public String content;
	  public String url;
	  public String kind;
	  public int data_list_id;
	  public int position;	 
	  public int server_data_item_id;
	  public static DataItem NIL_DATA_ITEM = new DataItem();
	  
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getData_list_id() {
		return data_list_id;
	}
	public void setData_list_id(int data_list_id) {
		this.data_list_id = data_list_id;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getServer_data_item_id() {
		return server_data_item_id;
	}
	public void setServer_data_item_id(int server_data_item_id) {
		this.server_data_item_id = server_data_item_id;
	}
	public static DataItem getNIL_DATA_ITEM() {
		return NIL_DATA_ITEM;
	}
	public static void setNIL_DATA_ITEM(DataItem nIL_DATA_ITEM) {
		NIL_DATA_ITEM = nIL_DATA_ITEM;
	}
	public DataItem() {
		super();
	}
	public DataItem(int id, String title, String content, String url,
			String kind, int data_list_id, int position, int server_data_item_id) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.url = url;
		this.kind = kind;
		this.data_list_id = data_list_id;
		this.position = position;
		this.server_data_item_id = server_data_item_id;
	}

	@Override
	public String toString() {
		String to = id + " : " +  title + " : " 
	+  content + " : " +  url + " : " +  kind 
	+ " : " +  data_list_id + " : " +  position 
	+ " : " +  server_data_item_id;
		
		return to;
	}
}