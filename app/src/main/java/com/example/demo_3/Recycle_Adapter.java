package com.example.demo_3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycle_Adapter extends RecyclerView.Adapter<Recycle_Adapter.ViewHolder>{

    public Recycle_Adapter(ArrayList<String> list) {
        this.list = list;
    }

    ArrayList<String> list=new ArrayList<>();


    @NonNull
    @Override
    public Recycle_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view1= LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_sheet,parent,false);
        return new ViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull Recycle_Adapter.ViewHolder holder, int position) {
   holder.button.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
button=itemView.findViewById(R.id.button);

        }
    }
}
