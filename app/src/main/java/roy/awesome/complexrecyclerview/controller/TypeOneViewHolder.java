package roy.awesome.complexrecyclerview.controller;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import roy.awesome.complexrecyclerview.AbsTypeViewHolder;
import roy.awesome.complexrecyclerview.R;
import roy.awesome.complexrecyclerview.model.DataModel;

/**
 * Created by Roy Sun on 2017/2/4.
 */

public class TypeOneViewHolder extends AbsTypeViewHolder {

    public ImageView mAvatar;
    public TextView  mName;


    public TypeOneViewHolder(View itemView) {
        super(itemView);
        mAvatar = (ImageView) itemView.findViewById(R.id.avatar);
        mName = (TextView) itemView.findViewById(R.id.item_name);
        itemView.setBackgroundColor(Color.GREEN);
    }

    @Override
    public void bindHolder(DataModel model) {
        mAvatar.setBackgroundResource(model.avatarColor);
        mName.setText(model.name);
    }
}
