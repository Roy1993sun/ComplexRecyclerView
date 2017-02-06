package roy.awesome.complexrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import roy.awesome.complexrecyclerview.controller.DemoAdapter;
import roy.awesome.complexrecyclerview.R;
import roy.awesome.complexrecyclerview.model.DataModel;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private DemoAdapter mAdapter;
    int colors[] = {android.R.color.holo_red_dark, android.R.color.holo_blue_dark, android.R.color.holo_green_dark};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mAdapter = new DemoAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        initData();

    }

    /*假数据*/
    private void initData() {
        List<DataModel> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int type = (int) ((Math.random() * 3) + 1);
            DataModel data = new DataModel();

            data.avatarColor = colors[type - 1];
            data.type = type;
            data.name = "name: " + i;
            data.content = "content:" + i;
            data.contentColor = colors[i % 3] ;
            list.add(data);
        }
        mAdapter.addList(list);
        mAdapter.notifyDataSetChanged();

    }
}
