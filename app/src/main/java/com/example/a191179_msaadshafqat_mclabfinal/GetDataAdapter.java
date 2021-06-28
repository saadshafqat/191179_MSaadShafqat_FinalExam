package com.example.a191179_msaadshafqat_mclabfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GetDataAdapter  extends RecyclerView.Adapter<GetDataAdapter.ViewHolder> {
Context context;
    ArrayList<HobbeyData> dataholder;

    public GetDataAdapter(Context context, ArrayList<HobbeyData> dataholder) {
        this.context = context;
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public GetDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull GetDataAdapter.ViewHolder holder, int position) {
        holder.txt.setText(dataholder.get(position).getName());
        holder.txt1.setText(dataholder.get(position).getTime());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataholder.remove(position);
                notifyDataSetChanged();
            }
        });



    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        TextView txt,txt1;
        Button btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.txtname);
            txt1=itemView.findViewById(R.id.txttime);
            btn=itemView.findViewById(R.id.removebtn);

        }
    }
}
