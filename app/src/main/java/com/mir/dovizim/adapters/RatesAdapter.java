package com.mir.dovizim.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mir.dovizim.R;
import java.util.Map;

public class RatesAdapter extends RecyclerView.Adapter<RatesAdapter.RatesViewHolder> {

    private Map<String, String> rates;
    private int rowLayout;
    private Context context;

    public static class RatesViewHolder extends RecyclerView.ViewHolder {
        LinearLayout ratesLayout;
        TextView tryRate;
        TextView usdRate;
        TextView gbpRate;

        public RatesViewHolder(View v) {
            super(v);
            ratesLayout = (LinearLayout) v.findViewById(R.id.ratesLayout);
            tryRate = (TextView) v.findViewById(R.id.tryValue);
            usdRate = (TextView) v.findViewById(R.id.usdValue);
            gbpRate = (TextView) v.findViewById(R.id.gbpValue);
        }
    }

    public RatesAdapter(Map<String ,String> rates, int rowLayout, Context context) {
        this.rates = rates;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public RatesAdapter.RatesViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new RatesViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RatesViewHolder holder, final int position) {
        holder.tryRate.setText(rates.get("TRY"));
        holder.usdRate.setText(rates.get("USD"));
        holder.gbpRate.setText(rates.get("GBP"));
    }

    @Override
    public int getItemCount() {
        return this.rates.size();
    }

}
