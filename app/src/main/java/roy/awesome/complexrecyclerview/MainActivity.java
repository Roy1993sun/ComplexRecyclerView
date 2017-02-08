package roy.awesome.complexrecyclerview;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import roy.awesome.complexrecyclerview.controller.DemoAdapter;
import roy.awesome.complexrecyclerview.R;
import roy.awesome.complexrecyclerview.model.DataModel;

import static android.R.attr.data;
import static android.R.attr.type;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private DemoAdapter mAdapter;
    int colors[] = {android.R.color.holo_red_dark, android.R.color.holo_blue_dark, android.R.color.holo_green_dark};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);


        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mAdapter = new DemoAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                GridLayoutManager.LayoutParams params = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = params.getSpanSize();
                int spanIndex = params.getSpanIndex();
                outRect.top = 20;
                if (spanSize != gridLayoutManager.getSpanCount()) {
                    if (spanIndex == 1) {
                        outRect.left = 10;
                    } else {
                        outRect.right = 10;
                    }
                }
            }
        });

        initData();

    }

    /*假数据*/
    private void initData() {
        List<DataModel> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            //int type = (int) ((Math.random() * 3) + 1);
            int type;
            if (i < 5 || i > 15 && i < 20) {
                type = 1;
            } else if (i < 10 || i > 26) {
                type = 2;
            } else {
                type = 3;
            }

            DataModel data = new DataModel();

            data.avatarColor = colors[type - 1];
            data.type = type;
            data.name = "name: " + type;
            data.content = "content:" + i;
            data.contentColor = colors[i % 3];
            list.add(data);
        }
        mAdapter.addList(list);
        mAdapter.notifyDataSetChanged();

    }
}
