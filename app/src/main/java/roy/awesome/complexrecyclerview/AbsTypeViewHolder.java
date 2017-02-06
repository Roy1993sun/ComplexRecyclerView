package roy.awesome.complexrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import roy.awesome.complexrecyclerview.model.DataModel;

/**
 * Created by Roy Sun on 2017/2/4.
 */

public abstract class AbsTypeViewHolder extends RecyclerView.ViewHolder {


    public AbsTypeViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(DataModel model);
}
