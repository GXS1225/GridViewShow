package cn.bzu.ui;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	private GridView smallImageGrid;
	private ImageView showImage;

	// 1.׼��������Դ
	private int[] pics = { R.drawable.a, R.drawable.b, R.drawable.c,
			R.drawable.d, R.drawable.e, R.drawable.f };// ���ͼƬid������
	private String [] tvInformation={"��һ��ͷ��","�ڶ���ͷ��","������ͷ��","���ĸ�ͷ��","�����ͷ��","������ͷ��"};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// �������
		smallImageGrid = (GridView) this.findViewById(R.id.imagelist);
		showImage = (ImageView) this.findViewById(R.id.imageshow);
	    
		//2.����һ��List<Map>���ϣ����ڽ�ͼƬIDת��ΪList����
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < pics.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("pic", pics[i]);
			item.put("tvInformation", tvInformation[i]);
			data.add(item);
		}
		//3.����������
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, data,
				R.layout.grid, new String[] { "pic","tvInformation" }, new int[]{R.id.smallImage,R.id.tvInformation});
		
        //4.��GridView��Adapter֮��Ĺ���
		smallImageGrid.setAdapter(simpleAdapter);
	
		//  ΪshowImage�������Ĭ��ͼƬ
		showImage.setImageResource(pics[0]);
		// 5.ע���¼�����
		smallImageGrid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position,
					long id) {
				showImage.setImageResource(pics[position]);
			}
		});
	}

	public class GridViewHandler implements OnItemClickListener {

		/**
		 * AdapterView adpaterview����������¼���AdapterView�� View
		 * view��AdapterView�б��û������Item��GridView�е�Item���� int
		 * positon���������Item��Adapter�е�λ�� long id���������Item��Id
		 */

		@Override
		public void onItemClick(AdapterView<?> adapter, View view,
				int position, long id) {
			showImage.setImageResource(pics[position]);
		}

	}

}
