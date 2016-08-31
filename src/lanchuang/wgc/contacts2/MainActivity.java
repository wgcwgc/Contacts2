package lanchuang.wgc.contacts2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState )
	{
		ListView contactsList;
		super.onCreate(savedInstanceState);
		System.out.println("刷入成功！！！");
//		setContentView(R.layout.activity_main); // 不使用inflate
		// XML文件方法，而是使用动态生成控件。
		contactsList = new ListView(MainActivity.this);
		ContentResolver cr = getContentResolver(); // 获取ContentResolver
		Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI ,null ,null ,null ,null); // 查询系统的联系人信息
//		System.out.println("cursor:" + cursor);
		
		
		Log.i("cth" ,cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME) + "" + ContactsContract.Contacts.PHONETIC_NAME + "");
		@SuppressWarnings("deprecation")
		ListAdapter la = new SimpleCursorAdapter(MainActivity.this , android.R.layout.simple_list_item_1 , cursor , new String []
		{ ContactsContract.Contacts.DISPLAY_NAME_PRIMARY } , new int []
		{ android.R.id.text1 }); // 建立列表适配器，把cursor关联进来
//		System.out.println("la:" + la);
		
		contactsList.setAdapter(la); // 把ListVIew与适配器绑定
//		System.out.println("contactsList:" + contactsList);
		
		setContentView(contactsList); // 动态生成ListView
		// String contents = "";
		// super.onCreate(savedInstanceState); // 得到ContentResolver对象
		// ContentResolver contentResolver = getContentResolver();//
		// 取得电话本中开始一项的光标
		// Cursor cursor =
		// contentResolver.query(ContactsContract.Contacts.CONTENT_URI ,null
		// ,null ,null ,null);// 查询系统的联系人信息
		// // 向下移动光标
		// int first = 0;
		// while(cursor.moveToNext())
		// {
		// // 取得联系人名字
		// int contacts = cursor.getColumnIndex(PhoneLookup.DISPLAY_NAME);
		// String contact = cursor.getString(contacts);
		// // System.out.println(++ first + "~~~:" + contact);
		// // 取得电话号码
		// String contactsId =
		// cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
		// Cursor phoneNumbers =
		// contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI
		// ,null ,ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" +
		// contactsId ,null ,null);
		// while(phoneNumbers.moveToNext())
		// {
		// String phoneNumber =
		// phoneNumbers.getString(phoneNumbers.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
		// contents += (contact + ":" + phoneNumber + "\n");
		// System.out.println(++ first + contact + phoneNumber);
		// }
		// }
		// cursor.close();
		// TextView tv = new TextView(this);
		// // 设置TextView显示的内容
		// tv.setText(contents);
		// // 显示到屏幕
		// setContentView(tv);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu )
	{
		getMenuInflater().inflate(R.menu.main ,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item )
	{
		int id = item.getItemId();
		if(id == R.id.action_settings)
		{
			Toast.makeText(this ,"action_settings" ,Toast.LENGTH_LONG).show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
