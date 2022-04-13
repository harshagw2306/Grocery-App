package com.example.groceryapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.groceryapp.R;

public class ListAdapter extends BaseAdapter {
    Context context;
    String broadListItemName[];
    int broadListItemImage[];

    LayoutInflater inflater;
    public ListAdapter(Context context, String[] broadListItemName,
                       int[] broadListItemImage) {
        this.context = context;
        this.broadListItemName = broadListItemName;
        this.broadListItemImage = broadListItemImage;
    }

    @Override
    public int getCount() {
        return broadListItemName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(inflater==null)
            inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view==null) {
            view=inflater.inflate(R.layout.broad_list_item,null);
        }

        ImageView listItemImage = view.findViewById(R.id.broadListItemImage);
        TextView listItemName= view.findViewById(R.id.itemName);
        listItemImage.setImageResource(broadListItemImage[position]);
        listItemName.setText(broadListItemName[position]);

        return view;
    }
}
