package com.example.solsticeprogrammingchallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class InfoAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<Info> userInfo;

    public InfoAdapter(Context context, ArrayList<Info> userInfo) {
        this.context = context;
        this.userInfo = userInfo;
    }

    @Override
    public int getCount() {
        return userInfo.size();
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

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

        Info info = userInfo.get(position);

        final View infoView = inflater.inflate(R.layout.infoview, null);

        TextView tag = infoView.findViewById(R.id.tagNametv);
        TextView infotag = infoView.findViewById(R.id.infoTagtv);
        TextView type = infoView.findViewById(R.id.typetv);
        tag.setText(info.getTag());
        infotag.setText(info.getInfoTag());
        type.setText(info.getType());

        return infoView;
    }
}
