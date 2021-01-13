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

import io.gio.roulette.Model.RuleViewModel;
import io.gio.roulette.R;

public class RulesAdapter extends RecyclerView.Adapter<RulesAdapter.ViewHolder> {
    List<RuleViewModel> data;
    Context context;
    TextView name,desc;
    ImageView image;


    public RulesAdapter(Context context,List<RuleViewModel> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.ruleitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.cname.setText(data.get(position).getRname());
        holder.cdesc.setText(data.get(position).getRdesc());
      holder.imahe.setImageResource(data.get(position).getImage());
        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_rules_details);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        name = myDialog.findViewById(R.id.rulesname);
        desc = myDialog.findViewById(R.id.rulesdesc);
        for (int i = 0; i<data.size(); i++) {
            if(holder.cname.getText()==data.get(position).getRname()){
                name.setText(data.get(position).getRname());
                desc.setText(data.get(position).getRdesc());
            }
        }holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.show();
            }
        });

        holder.imahe.setOnClickListener(new View.OnClickListener(){
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

        public TextView cname,cdesc;
     public ImageView imahe;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cdesc = itemView.findViewById(R.id.ruledesc);
            cname = itemView.findViewById(R.id.rulename);
            imahe = itemView.findViewById(R.id.outimage);
        }
    }
}
