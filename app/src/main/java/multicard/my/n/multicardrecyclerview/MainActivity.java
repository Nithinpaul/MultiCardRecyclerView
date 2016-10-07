package multicard.my.n.multicardrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import static multicard.my.n.multicardrecyclerview.myCustomAdapter.card1;
import static multicard.my.n.multicardrecyclerview.myCustomAdapter.card2;
import static multicard.my.n.multicardrecyclerview.myCustomAdapter.card3;

/**
 * Created by nithin
 */
public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    private myCustomAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] mDataset = {
            "Card 1",
            "Card 2",
            "Card 3",
            "Card 1"
    };
    int[] mDataSetTypes = {
            card1,
            card2,
            card3,
            card1
    }; //view types

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);


        mAdapter = new myCustomAdapter(mDataset, mDataSetTypes);
        mRecyclerView.setAdapter(mAdapter);
    }
}
