package io.gio.roulette.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import io.gio.roulette.Model.DesignViewModel;
import io.gio.roulette.R;

public class DesignAdapter extends RecyclerView.Adapter<DesignAdapter.ViewHolder> {
    List<DesignViewModel> data;
    Context context;
    TextView name,desc;
    ImageView image;


    public DesignAdapter(Context context, List<DesignViewModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public DesignAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.designitem, parent, false);
        DesignAdapter.ViewHolder viewHolder = new DesignAdapter.ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull final DesignAdapter.ViewHolder holder, final int position) {
        holder.mname.setText(data.get(position).getName());
        holder.desc.setText(data.get(position).getDesc());
        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_design_detail);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        name = myDialog.findViewById(R.id.designname);
        desc = myDialog.findViewById(R.id.designdesc);
//        image = myDialog.findViewById(R.id.designimage);
        for (int i = 0; i<data.size(); i++) {
            if(holder.mname.getText()==data.get(position).getName()){
                name.setText(data.get(position).getName());
                desc.setText(data.get(position).getDesc());
//                Picasso.get().load(data.get(position).getImage()).into(image);
            }
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.show();

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

        public TextView mname,desc;
//        public ImageView mimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            desc = itemView.findViewById(R.id.ddesc);
            mname = itemView.findViewById(R.id.dename);
        }
    }
}