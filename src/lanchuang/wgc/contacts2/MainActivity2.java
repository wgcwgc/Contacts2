package lanchuang.wgc.contacts2;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.widget.ArrayAdapter;

public class MainActivity2 extends ListActivity
{
	List < String > list = new ArrayList < String >(null);

	@Override
	protected void onCreate(Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);
		// �õ�ContentResolver����
		ContentResolver contentResolver = getContentResolver();
		// ȡ�õ绰���п�ʼһ��Ĺ��
		Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI ,null ,null ,null ,null);// ��ѯϵͳ����ϵ����Ϣ
		// �����ƶ����
		// int first = 0;
		while(cursor.moveToNext())
		{
			// ȡ����ϵ������
			int contacts = cursor.getColumnIndex(PhoneLookup.DISPLAY_NAME);
			String contact = cursor.getString(contacts);
			// ȡ�õ绰����
			String contactsId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
			Cursor phoneNumbers = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI ,null ,ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactsId ,null ,null);
			while(phoneNumbers.moveToNext())
			{
				String phoneNumber = phoneNumbers.getString(phoneNumbers.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
				list.add(contact + ":" + phoneNumber + "\n");
			}
		}
		cursor.close();
		// TextView tv = new TextView(this);
		// ����TextView��ʾ������
		// tv.setText(contents);
		// ��ʾ����Ļ
		// setContentView(tv);

		System.out.println(list);
		ArrayAdapter < String > adapter = new ArrayAdapter < String >(this , android.R.layout.simple_list_item_1 , list);
		setListAdapter(adapter);
		setVisible(true);
	}

}


