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

import io.gio.roulette.Model.MahjongViewModel;
import io.gio.roulette.R;

public class MahjongAdapter extends RecyclerView.Adapter<MahjongAdapter.ViewHolder> {
    List<MahjongViewModel> data;
    Context context;
    TextView name,desc;
    ImageView image;


    public MahjongAdapter(Context context,List<MahjongViewModel> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MahjongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.mahjongitem, parent, false);
        MahjongAdapter.ViewHolder viewHolder = new MahjongAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MahjongAdapter.ViewHolder holder, final int position) {
        holder.mname.setText(data.get(position).getMahjongname());
      holder.mdesc.setText(data.get(position).getMahjongdesc());
        holder.mimage.setImageResource(data.get(position).getMahjongimg());

        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_roulette_details);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        name = myDialog.findViewById(R.id.roulettename);
        desc = myDialog.findViewById(R.id.roulettedesc);
//        image = myDialog.findViewById(R.id.mahjongimage);
        for (int i = 0; i<data.size(); i++) {
            if(holder.mname.getText()==data.get(position).getMahjongname()){
                name.setText(data.get(position).getMahjongname());
               desc.setText(data.get(position).getMahjongdesc());
//                Picasso.get().load(data.get(position).getMahjongimg()).into(image);
            }
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
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

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mname;
        public TextView mdesc;
        public ImageView mimage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mimage = itemView.findViewById(R.id.mahimg);
            mname = itemView.findViewById(R.id.mahname);
            mdesc = itemView.findViewById(R.id.mahdesc);
        }
    }
}