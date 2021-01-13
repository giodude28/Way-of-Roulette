package io.gio.roulette.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.gio.roulette.Model.ScoreViewModel;
import io.gio.roulette.R;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ViewHolder> {
    List<ScoreViewModel> data;
    Context context;
    TextView name,desc,place;
    ImageView image;


    public ScoreAdapter(Context context, List<ScoreViewModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ScoreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.scoreitem, parent, false);
        ScoreAdapter.ViewHolder viewHolder = new ScoreAdapter.ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull final ScoreAdapter.ViewHolder holder, final int position) {
        holder.name.setText(data.get(position).getScoretitle());
//        holder.desc.setText(data.get(position).getScoredesc());
        holder.mimage.setImageResource(data.get(position).getImahe());
        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_scoring_details);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        name = myDialog.findViewById(R.id.scoretitle);
        desc = myDialog.findViewById(R.id.scoredesc);
        place = myDialog.findViewById(R.id.place);
        for (int i = 0; i<data.size(); i++) {
            if(holder.name.getText()==data.get(position).getScoretitle()){
                name.setText(data.get(position).getScoretitle());
                desc.setText(data.get(position).getScoredesc());
                place.setText(data.get(position).getPlace());
            }
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.show();

            }
        });
        holder.mimage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast toast = Toast.makeText(context,"Expand the image to Zoom In",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
//        holder.mimage.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Toast toast = Toast.makeText(context,"Expand the image to Zoom In",Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name,desc;
        public ImageView mimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.scoretitle);
//            desc = itemView.findViewById(R.id.scoredesc);
            mimage = itemView.findViewById(R.id.inimage);
        }
    }
}