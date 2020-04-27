/*https://www.youtube.com/watch?v=Vyqz_-sJGFk*/

package edu.gatech.seclass.words6300;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecycleWordAdapter extends RecyclerView.Adapter<RecycleWordAdapter.ViewHolder> {
    private static final String TAG = "RecycleWordAdapter";
    private ArrayList<String> mword=new ArrayList<>();
    private ArrayList<String> musedtime=new ArrayList<>();

    public RecycleWordAdapter(ArrayList<String> mword, ArrayList<String> musedtime) {
        this.mword = mword;
        this.musedtime = musedtime;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.relativelayout_word, parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.word.setText(mword.get(position));
        holder.usedtime.setText(musedtime.get(position));

    }

    @Override
    public int getItemCount() {
        return mword.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView word;
        TextView usedtime;
        RecyclerView wordbankstaview;

        public ViewHolder(View itemView) {
            super(itemView);
            word=itemView.findViewById(R.id.textView402);
            usedtime=itemView.findViewById(R.id.textView403);
            wordbankstaview=itemView.findViewById(R.id.wordbankstaview);

        }
    }
}
