package com.yehiakh96.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;


public class fragment_news extends Fragment {

    int[] news = {R.drawable.news1, R.drawable.news2, R.drawable.news3};

    public fragment_news() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ListView listView = (ListView) view.findViewById(R.id.listview);
        final String[] desArray = getResources().getStringArray(R.array.Title);
        String[] texttime = getResources().getStringArray(R.array.timetext);
        ArrayList<listitem> listnews = new ArrayList<listitem>();


        for (int i = 0; i < desArray.length; i++) {
            listnews.add(new listitem(texttime[i], news[i], desArray[i]));

        }

        fragment_news.ListAdapter ad = new fragment_news.ListAdapter(listnews);
        listView.setAdapter(ad);
        listView.setDivider(null);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Data_Layout.class);
                intent.putExtra("name", desArray[position]);
                intent.putExtra("image", news[position]);
                startActivity(intent);

            }

        });
        return view;
    }
    class ListAdapter extends BaseAdapter {
        ArrayList<listitem> listitem;
        ListAdapter(ArrayList<listitem> listitem){
            this.listitem = listitem;
        }

        @Override
        public int getCount() {
            return listitem.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public View getView(int i, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.custom_image,null);
            TextView name = (TextView)view.findViewById(R.id.description);
            TextView time = (TextView)view.findViewById(R.id.textTime);
            ImageView image = (ImageView)view.findViewById(R.id.imagenewslist);

            name.setText(listitem.get(i).name);
            image.setImageResource(listitem.get(i).img);
            time.setText(listitem.get(i).time);
            return view;
        }
    }
}


