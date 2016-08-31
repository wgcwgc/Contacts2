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
		System.out.println("ˢ��ɹ�������");
//		setContentView(R.layout.activity_main); // ��ʹ��inflate
		// XML�ļ�����������ʹ�ö�̬���ɿؼ���
		contactsList = new ListView(MainActivity.this);
		ContentResolver cr = getContentResolver(); // ��ȡContentResolver
		Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI ,null ,null ,null ,null); // ��ѯϵͳ����ϵ����Ϣ
//		System.out.println("cursor:" + cursor);
		
		
		Log.i("cth" ,cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME) + "" + ContactsContract.Contacts.PHONETIC_NAME + "");
		@SuppressWarnings("deprecation")
		ListAdapter la = new SimpleCursorAdapter(MainActivity.this , android.R.layout.simple_list_item_1 , cursor , new String []
		{ ContactsContract.Contacts.DISPLAY_NAME_PRIMARY } , new int []
		{ android.R.id.text1 }); // �����б�����������cursor��������
//		System.out.println("la:" + la);
		
		contactsList.setAdapter(la); // ��ListVIew����������
//		System.out.println("contactsList:" + contactsList);
		
		setContentView(contactsList); // ��̬����ListView
		// String contents = "";
		// super.onCreate(savedInstanceState); // �õ�ContentResolver����
		// ContentResolver contentResolver = getContentResolver();//
		// ȡ�õ绰���п�ʼһ��Ĺ��
		// Cursor cursor =
		// contentResolver.query(ContactsContract.Contacts.CONTENT_URI ,null
		// ,null ,null ,null);// ��ѯϵͳ����ϵ����Ϣ
		// // �����ƶ����
		// int first = 0;
		// while(cursor.moveToNext())
		// {
		// // ȡ����ϵ������
		// int contacts = cursor.getColumnIndex(PhoneLookup.DISPLAY_NAME);
		// String contact = cursor.getString(contacts);
		// // System.out.println(++ first + "~~~:" + contact);
		// // ȡ�õ绰����
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
		// // ����TextView��ʾ������
		// tv.setText(contents);
		// // ��ʾ����Ļ
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
