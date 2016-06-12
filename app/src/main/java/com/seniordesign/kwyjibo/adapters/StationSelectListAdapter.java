package com.seniordesign.kwyjibo.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.seniordesign.kwyjibo.kwyjibo.R;

import java.util.List;

public class StationSelectListAdapter<T> extends ArrayAdapter<T> {

    private Context context;
    private int id;
    private List<T> items;

    public StationSelectListAdapter(Context context, int id, List<T> items) {
        super(context, id, items);
        this.context = context;
        this.id = id;
        this.items = items;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        View mView = v ;
        if(mView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(id, parent, false);
        }

        TextView text = (TextView)mView.findViewById(R.id.radio_mode_list_item_textview);

        if(items.get(position) != null ) {
            Typeface proximaNova = Typeface.createFromAsset(context.getAssets(),"fonts/ProximaNova-Semibold.otf");
            if (items.get(position) instanceof String){
                text.setTypeface(proximaNova);
                text.setText((String)items.get(position));
            }
        }

        return mView;
    }
}