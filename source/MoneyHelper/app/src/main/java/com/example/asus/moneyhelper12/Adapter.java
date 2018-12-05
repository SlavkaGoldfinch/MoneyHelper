package com.example.asus.moneyhelper12;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Item> {

    private SparseBooleanArray selectedItemsIds;
    private ArrayList<Item> itemList;
    private Context context;



    public Adapter(ArrayList<Item> itemList, Context context) {
        super(context, R.layout.item, itemList);
        this.itemList = itemList;
        this.context = context;
        selectedItemsIds = new SparseBooleanArray();
    }

    private class ViewHolder {
        TextView name;
        TextView place;
        TextView comment;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Adapter.ViewHolder holder;
        if(view == null) {
            holder = new Adapter.ViewHolder();
            view = View.inflate(context, R.layout.item, null);

            holder.name = view.findViewById(R.id.money);
            holder.place = view.findViewById(R.id.data);
            holder.comment = view.findViewById(R.id.comment);

            view.setTag(holder);
        }
        else holder = (Adapter.ViewHolder) view.getTag();

        holder.name.setText(String.valueOf(itemList.get(position).getMoney()));
        holder.place.setText(String.valueOf(itemList.get(position).getData()));
        holder.comment.setText(String.valueOf(itemList.get(position).getComment()));

        return view;
    }

    public ArrayList<Item> getProductList() {

        return itemList;
    }

    public void toggleSelection(int position) {
        selectView(position, !selectedItemsIds.get(position));
    }

    public void removeSelection() {
        selectedItemsIds = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void selectView(int position, boolean value) {
        if (value) selectedItemsIds.put(position, value);
        else selectedItemsIds.delete(position);
        notifyDataSetChanged();
    }

    public int getSelectedCount() {

        return selectedItemsIds.size();
    }

    public SparseBooleanArray getSelectedIds() {

        return selectedItemsIds;
    }

    @Override
    public void remove(Item object) {
        itemList.remove(object);
        notifyDataSetChanged();
    }

}