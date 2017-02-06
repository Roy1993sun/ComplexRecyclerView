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

public class TypeThreeViewHolder extends AbsTypeViewHolder {

    public ImageView mAvatar;
    public TextView  mName;
    public TextView  mContent;
    public ImageView mContentImage;

    public TypeThreeViewHolder(View itemView) {
        super(itemView);
        mAvatar = (ImageView) itemView.findViewById(R.id.avatar);
        mName = (TextView) itemView.findViewById(R.id.item_name);
        mContent = (TextView) itemView.findViewById(R.id.item_content);
        mContentImage = (ImageView) itemView.findViewById(R.id.contentImage);
    }
    @Override
    public void bindHolder(DataModel model) {
        mAvatar.setBackgroundResource(model.avatarColor);
        mName.setText(model.name);
        mContent.setText(model.content);
        mContentImage.setBackgroundResource(model.contentColor);
    }
}
