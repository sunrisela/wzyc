package org.wz.yc.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import org.wz.yc.R;
import org.wz.yc.model.Dealer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class DealerAdapter extends BaseAdapter {

	// 填充数据的list
	private ArrayList<String> list;
	// 用来控制CheckBox的选中状况
	private static HashMap<Integer, Boolean> isSelected;
	// 上下文
	private Context context;
	// 用来导入布局
	private LayoutInflater inflater = null;

	// 构造器
	public DealerAdapter(ArrayList<String> list, Context context) {
		this.context = context;
		this.list = list;
		inflater = LayoutInflater.from(context);
		isSelected = new HashMap<Integer, Boolean>();
		// 初始化数据
		initDate();
	}

	// 初始化isSelected的数据
	private void initDate() {
		for (int i = 0; i < list.size(); i++) {
			getIsSelected().put(i, false);
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Dealer dealer = null;
		if (convertView == null) {
			// 获得ViewDealer对象
			dealer = new Dealer();
			// 导入布局并赋值给convertview
			convertView = inflater.inflate(R.layout.dealer, null);
			dealer.tv = (TextView) convertView.findViewById(R.id.textView1);
			dealer.cb = (CheckBox) convertView.findViewById(R.id.checkBox1);
			// 为view设置标签
			convertView.setTag(new Object());
		} else {
			// 取出holder
			holder = (ViewHolder) convertView.getTag();
		}

		// 设置list中TextView的显示
		holder.tv.setText(list.get(position));
		// 根据isSelected来设置checkbox的选中状况
		holder.cb.setChecked(getIsSelected().get(position));
		
		return convertView;
	}

	public static HashMap<Integer, Boolean> getIsSelected() {
		return isSelected;
	}

	public static void setIsSelected(HashMap<Integer, Boolean> isSelected) {
		DealerAdapter.isSelected = isSelected;
	}

}
