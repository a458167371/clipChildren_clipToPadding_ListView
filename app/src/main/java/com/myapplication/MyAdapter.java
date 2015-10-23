package com.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lilyxiao on 15/10/22.
 */
public class MyAdapter extends BaseAdapter{
    private ArrayList<Person> datas;
    private Context mContext;

    public MyAdapter(Context context){
        mContext = context;

        datas = new ArrayList<>();
        for (int i=0;i<30;i++) {
            datas.add(new Person("zhangsan", 2*i, R.mipmap.ic_launcher));
        }
    }


    @Override
    public int getCount() {
        return datas != null && datas.size() >0 ?datas.size():0;
    }

    @Override
    public Person getItem(int position) {
        return datas != null && datas.size() >0 ?datas.get(position):null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_item,parent,false);
            holder = new ViewHolder();

            holder.icon = (ImageView) convertView.findViewById(R.id.item_img);
            holder.item_name = (TextView) convertView.findViewById(R.id.item_name);
            holder.item_age = (TextView) convertView.findViewById(R.id.item_age);
            holder.item_icon = (ImageView) convertView.findViewById(R.id.icon);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Person person = getItem(position);
        holder.item_name.setText(person.getName());
        holder.item_age.setText(person.getAge() + "");
        holder.icon.setImageResource(person.getIcon());

        if (position == 3)
            holder.item_icon.setVisibility(View.VISIBLE);
        else
            holder.item_icon.setVisibility(View.GONE );

        return convertView;
    }

    private class ViewHolder{
        private ImageView icon;
        private TextView item_name;
        private TextView item_age;
        private ImageView item_icon;
    }
}
