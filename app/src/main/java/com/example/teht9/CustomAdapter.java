package com.example.teht9;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    private ArrayList<MyEntity2> rowItems;

    public CustomAdapter(@NonNull Context context, ArrayList<MyEntity2> myEntities2) {
        super(context, 0, myEntities2);
        this.rowItems = myEntities2;
    }

    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
        // Get the item to be displayed
        final MyEntity2 rowItem = rowItems.get(position);

        // IF null then inflate the layout. Otherwise just update layout contents.
        if (convertView == null) {
            // Get the custom layout and inflate it
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the customLayout components
        TextView textUser = convertView.findViewById(R.id.textViewUser);
        TextView textLoginAttempt = convertView.findViewById(R.id.textViewLoginAttempt);
        TextView textTimestamp = convertView.findViewById(R.id.textViewTimestamp);

        // Set content
        textUser.setText(rowItem.user);
        textLoginAttempt.setText(rowItem.loginAttempt);
        textTimestamp.setText(rowItem.timestamp.toString());
        return convertView;
    }

    public void setListItems(ArrayList<MyEntity2> listItems) {
        rowItems.clear();
        rowItems.addAll(listItems);
        notifyDataSetChanged();
    }

    public void addItem(ArrayList<MyEntity2> listItems) {
        rowItems.addAll(listItems);
        notifyDataSetChanged();
    }
}
