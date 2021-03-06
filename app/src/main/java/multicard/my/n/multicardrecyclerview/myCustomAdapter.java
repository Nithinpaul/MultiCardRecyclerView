package multicard.my.n.multicardrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by nithin
 */

public class myCustomAdapter extends RecyclerView.Adapter<myCustomAdapter.ViewHolder> {
    private static final String TAG = "myCustomAdapter";

    private String[] mDataSet;
    private int[] mDataSetTypes;

    public static final int card1 = 0;
    public static final int card2 = 1;
    public static final int card3 = 2;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }
    }

    public class WeatherViewHolder extends ViewHolder {
        TextView temp;

        public WeatherViewHolder(View v) {
            super(v);
            this.temp = (TextView) v.findViewById(R.id.temp);
        }
    }

    public class ScoreViewHolder extends ViewHolder {
        TextView score;

        public ScoreViewHolder(View v) {
            super(v);
            this.score = (TextView) v.findViewById(R.id.score);
        }
    }

    public class NewsViewHolder extends ViewHolder {
        TextView headline;
        Button read_more;

        public NewsViewHolder(View v) {
            super(v);
            this.headline = (TextView) v.findViewById(R.id.headline);
            this.read_more = (Button) v.findViewById(R.id.read_more);
        }
    }


    public myCustomAdapter(String[] dataSet, int[] dataSetTypes) {
        mDataSet = dataSet;
        mDataSetTypes = dataSetTypes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;
        if (viewType == card1) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.card1, viewGroup, false);

            return new WeatherViewHolder(v);
        } else if (viewType == card2) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.card2, viewGroup, false);
            return new NewsViewHolder(v);
        } else {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.card3, viewGroup, false);
            return new ScoreViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        if (viewHolder.getItemViewType() == card1) {
            WeatherViewHolder holder = (WeatherViewHolder) viewHolder;
            holder.temp.setText(mDataSet[position]);
        }
        else if (viewHolder.getItemViewType() == card2) {
            NewsViewHolder holder = (NewsViewHolder) viewHolder;
            holder.headline.setText(mDataSet[position]);
        }
        else {
            ScoreViewHolder holder = (ScoreViewHolder) viewHolder;
            holder.score.setText(mDataSet[position]);
        }
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    @Override
    public int getItemViewType(int position) {
        return mDataSetTypes[position];
    }
}

