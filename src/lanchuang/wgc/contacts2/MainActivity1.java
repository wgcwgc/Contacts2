package lanchuang.wgc.contacts2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * @author CTH
 * 
 *         该类是演示利用ContentProvider，获取手机的联系人信息。 使用ContentProvide的步骤：
 *         1、从当前Activity获取系统的ContentResolver；
 *         2、使用ContentProvider的insert、delete、update
 *         、query方法对ContentProvider的内容进行增删改查；
 *         3、如果是使用query是的到一个Cursor的结果集，通过该结果集可以获得我们查询的结果。
 * 
 */
public class MainActivity1 extends Activity
{
	private ListView contactsList;

	@SuppressLint("InlinedApi")
	protected void onCreate(Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); // 不使用inflate
		// XML文件方法，而是使用动态生成控件。
		contactsList = new ListView(MainActivity1.this);
		ContentResolver cr = getContentResolver(); // 获取ContentResolver
		Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI ,null ,null ,null ,null); // 查询系统的联系人信息
		Log.i("cth" ,cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME) + "");
		@SuppressWarnings("deprecation")
		ListAdapter la = new SimpleCursorAdapter(MainActivity1.this , android.R.layout.simple_list_item_1 , cursor , new String []
		{ ContactsContract.Contacts.DISPLAY_NAME_PRIMARY } , new int []
		{ android.R.id.text1 }); // 建立列表适配器，把cursor关联进来
		contactsList.setAdapter(la); // 把ListVIew与适配器绑定
		setContentView(contactsList); // 动态生成ListView
	}
}
