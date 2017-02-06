package roy.awesome.complexrecyclerview.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import roy.awesome.complexrecyclerview.AbsTypeViewHolder;
import roy.awesome.complexrecyclerview.R;
import roy.awesome.complexrecyclerview.controller.TypeOneViewHolder;
import roy.awesome.complexrecyclerview.controller.TypeThreeViewHolder;
import roy.awesome.complexrecyclerview.controller.TypeTwoViewHolder;
import roy.awesome.complexrecyclerview.model.DataModel;

/**
 * Created by Roy Sun on 2017/2/4.
 */

public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<DataModel> mData = new ArrayList<>();

    public DemoAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void addList(List<DataModel> list) {
        mData.addAll(list);

    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case DataModel.TYPE_ONE:
                return new TypeOneViewHolder(mLayoutInflater.inflate(R.layout.item_type_one, parent, false));
            case DataModel.TYPE_TWO:
                return new TypeTwoViewHolder(mLayoutInflater.inflate(R.layout.item_type_two, parent, false));
            case DataModel.TYPE_THREE:
                return new TypeThreeViewHolder(mLayoutInflater.inflate(R.layout.item_type_three, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // 优先对holder进行处理
        ((AbsTypeViewHolder)holder).bindHolder(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
