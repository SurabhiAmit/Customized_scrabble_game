/*https://www.youtube.com/watch?v=Vyqz_-sJGFk*/

package edu.gatech.seclass.words6300;

import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerSingleLetterAdapter extends RecyclerView.Adapter<RecyclerSingleLetterAdapter.ViewHolder>{
    private static final String TAG = "RecyclerSingleLetterAda";
    private ArrayList<String> msta_letterfixed=new ArrayList<>();
    private ArrayList<String> msta_lettercount=new ArrayList<>();
    private ArrayList<String> msta_letterpoint=new ArrayList<>();
    private Context mContext;

    public RecyclerSingleLetterAdapter( ArrayList<String> msta_letterfixed, ArrayList<String> msta_lettercount, ArrayList<String> msta_letterpoint) {

        this.msta_letterfixed = msta_letterfixed;
        this.msta_lettercount = msta_lettercount;
        this.msta_letterpoint = msta_letterpoint;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.relativelayout_singleletter, parent,false);
        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder:called.");
        holder.sta_lettercount.setText(msta_lettercount.get(position));
        holder.sta_letterfixed.setText(msta_letterfixed.get(position));
        holder.sta_letterpoint.setText(msta_letterpoint.get(position));

    }

    @Override
    public int getItemCount() {
        return msta_letterfixed.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sta_letterfixed;
        TextView sta_lettercount;
        TextView sta_letterpoint;
        RelativeLayout letterscoreview;

        public ViewHolder(View itemView) {
            super(itemView);
            sta_letterfixed = itemView.findViewById(R.id.sta_letterfixed);
            sta_lettercount = itemView.findViewById(R.id.sta_lettercount);
            sta_letterpoint = itemView.findViewById(R.id.sta_letterpoint);
            letterscoreview=itemView.findViewById(R.id.letterscoreview);
        }
    }

}
