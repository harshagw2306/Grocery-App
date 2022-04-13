package com.example.groceryapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceryapp.R;
import com.example.groceryapp.Sub_Category_Item_Model;

import java.util.ArrayList;

public class GS_Recy_View_Adapter extends RecyclerView.Adapter<GS_Recy_View_Adapter.MyViewHolder> {
    Context context;
    static ArrayList<Sub_Category_Item_Model> sub_grocerymodels;
    private GS_Recy_View_Adapter.OnItemListener onItemListener;
    public GS_Recy_View_Adapter(Context context, ArrayList<Sub_Category_Item_Model> sub_grocerymodels, GS_Recy_View_Adapter.OnItemListener onItemListener){
        this.context = context;
        this.sub_grocerymodels = sub_grocerymodels;
        this.onItemListener = onItemListener;
    }
    @NonNull
    @Override
    public GS_Recy_View_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.child_recycler_view_item,parent,false);
        return new GS_Recy_View_Adapter.MyViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull GS_Recy_View_Adapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(sub_grocerymodels.get(position).getImage());
        holder.textName.setText(sub_grocerymodels.get(position).getSub_groceryitem());
    }

    @Override
    public int getItemCount() {
        return sub_grocerymodels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder  {
        ImageView imageView;
        TextView textName;
        GS_Recy_View_Adapter.OnItemListener onItemListener;
        public MyViewHolder(@NonNull View itemView, GS_Recy_View_Adapter.OnItemListener onItemListener) {
            super(itemView);
            imageView= itemView.findViewById(R.id.sub_recy_imageView);
            textName= itemView.findViewById(R.id.sub_recy_textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemListener.OnItemClick(sub_grocerymodels.get(getAdapterPosition()).getImage(), sub_grocerymodels.get(getAdapterPosition()).getSub_groceryitem());

                }
            });

        }


    }
    public interface OnItemListener
    {
        void OnItemClick(int image,String s);
    }
}