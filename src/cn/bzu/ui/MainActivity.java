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

	// 1.准备好数据源
	private int[] pics = { R.drawable.a, R.drawable.b, R.drawable.c,
			R.drawable.d, R.drawable.e, R.drawable.f };// 存放图片id的数组
	private String [] tvInformation={"第一个头像","第二个头像","第三个头像","第四个头像","第五个头像","第六个头像"};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 查找组件
		smallImageGrid = (GridView) this.findViewById(R.id.imagelist);
		showImage = (ImageView) this.findViewById(R.id.imageshow);
	    
		//2.创建一个List<Map>集合，用于将图片ID转换为List集合
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < pics.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("pic", pics[i]);
			item.put("tvInformation", tvInformation[i]);
			data.add(item);
		}
		//3.创建适配器
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, data,
				R.layout.grid, new String[] { "pic","tvInformation" }, new int[]{R.id.smallImage,R.id.tvInformation});
		
        //4.绑定GridView和Adapter之间的关联
		smallImageGrid.setAdapter(simpleAdapter);
	
		//  为showImage组件设置默认图片
		showImage.setImageResource(pics[0]);
		// 5.注册事件监听
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
		 * AdapterView adpaterview：发生点击事件的AdapterView； View
		 * view：AdapterView中被用户点击的Item（GridView中的Item）； int
		 * positon：被点击的Item在Adapter中的位置 long id：被点击的Item的Id
		 */

		@Override
		public void onItemClick(AdapterView<?> adapter, View view,
				int position, long id) {
			showImage.setImageResource(pics[position]);
		}

	}

}
