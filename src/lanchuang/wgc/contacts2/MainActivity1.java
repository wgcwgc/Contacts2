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
 *         ��������ʾ����ContentProvider����ȡ�ֻ�����ϵ����Ϣ�� ʹ��ContentProvide�Ĳ��裺
 *         1���ӵ�ǰActivity��ȡϵͳ��ContentResolver��
 *         2��ʹ��ContentProvider��insert��delete��update
 *         ��query������ContentProvider�����ݽ�����ɾ�Ĳ飻
 *         3�������ʹ��query�ǵĵ�һ��Cursor�Ľ������ͨ���ý�������Ի�����ǲ�ѯ�Ľ����
 * 
 */
public class MainActivity1 extends Activity
{
	private ListView contactsList;

	@SuppressLint("InlinedApi")
	protected void onCreate(Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); // ��ʹ��inflate
		// XML�ļ�����������ʹ�ö�̬���ɿؼ���
		contactsList = new ListView(MainActivity1.this);
		ContentResolver cr = getContentResolver(); // ��ȡContentResolver
		Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI ,null ,null ,null ,null); // ��ѯϵͳ����ϵ����Ϣ
		Log.i("cth" ,cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME) + "");
		@SuppressWarnings("deprecation")
		ListAdapter la = new SimpleCursorAdapter(MainActivity1.this , android.R.layout.simple_list_item_1 , cursor , new String []
		{ ContactsContract.Contacts.DISPLAY_NAME_PRIMARY } , new int []
		{ android.R.id.text1 }); // �����б�����������cursor��������
		contactsList.setAdapter(la); // ��ListVIew����������
		setContentView(contactsList); // ��̬����ListView
	}
}
