package com.sony.task1;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class ClaimsAdapter extends RecyclerView.Adapter<ClaimsAdapter.MyViewHolder> {

    private List<Claim> claimsList;

    public ClaimsAdapter(List<Claim> claimsList) {
        this.claimsList = claimsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.claim_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Claim claim = claimsList.get(position);
        holder.created.setText((claim.getValue()));
        holder.titleCreated.setText(claim.getTitle());
    }

    @Override
    public int getItemCount() {
        return claimsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titleCreated, created;

        public MyViewHolder(View view) {
            super(view);
            titleCreated = (TextView) view.findViewById(R.id.title);
            created = (TextView) view.findViewById(R.id.created);
        }
    }
}
