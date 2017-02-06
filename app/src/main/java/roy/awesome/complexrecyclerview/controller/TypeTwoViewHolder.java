package roy.awesome.complexrecyclerview.controller;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import roy.awesome.complexrecyclerview.AbsTypeViewHolder;
import roy.awesome.complexrecyclerview.R;
import roy.awesome.complexrecyclerview.model.DataModel;

/**
 * Created by Roy Sun on 2017/2/4.
 */

public class TypeTwoViewHolder extends AbsTypeViewHolder {

    public ImageView mAvatar;
    public TextView  mName;
    public TextView  mContent;


    public TypeTwoViewHolder(View itemView) {
        super(itemView);
        mAvatar = (ImageView) itemView.findViewById(R.id.avatar);
        mContent = (TextView) itemView.findViewById(R.id.item_content);
        mName = (TextView) itemView.findViewById(R.id.item_name);
    }
    @Override
    public void bindHolder(DataModel model) {
        mAvatar.setBackgroundResource(model.avatarColor);
        mName.setText(model.name);
        mContent.setText(model.content);
    }
}
