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

public class RecyclerLetterSta extends RecyclerView.Adapter<RecyclerLetterSta.ViewHolder>{
    private static final String TAG = "RecyclerLetterSta";
    private ArrayList<String> nsta_letterfixed=new ArrayList<>();
    private ArrayList<String> nsta_letterplayed=new ArrayList<>();
    private ArrayList<String> nsta_lettertraded=new ArrayList<>();
    private ArrayList<String> nsta_letterpercent=new ArrayList<>();

    public RecyclerLetterSta(ArrayList<String> nsta_letterfixed, ArrayList<String> nsta_letterplayed, ArrayList<String> nsta_lettertraded, ArrayList<String> nsta_letterpercent) {
        this.nsta_letterfixed = nsta_letterfixed;
        this.nsta_letterplayed = nsta_letterplayed;
        this.nsta_lettertraded = nsta_lettertraded;
        this.nsta_letterpercent = nsta_letterpercent;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.relativelayout_lettersta, parent,false);
        ViewHolder holder=new ViewHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder:called.");
        holder.sta_textView201.setText(nsta_letterfixed.get(position));
        holder.sta_textView202.setText(nsta_letterplayed.get(position));
        holder.sta_textView203.setText(nsta_lettertraded.get(position));
        holder.sta_textView204.setText(nsta_letterpercent.get(position));

    }

    @Override
    public int getItemCount() {
        return nsta_letterfixed.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView sta_textView201;
        TextView sta_textView202;
        TextView sta_textView203;
        TextView sta_textView204;
        RelativeLayout letterstaview;

        public ViewHolder(View itemView) {
            super(itemView);
            sta_textView201 = itemView.findViewById(R.id.textView201);
            sta_textView202 = itemView.findViewById(R.id.textView202);
            sta_textView203 = itemView.findViewById(R.id.textView203);
            sta_textView204=itemView.findViewById(R.id.textView204);
        }
    }
}
