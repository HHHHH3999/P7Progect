package com.example.p7project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.p7project.R;

public class PingpaiAdapter extends DelegateAdapter.Adapter {
    private SingleLayoutHelper singleLayoutHelper;
    private Context context;

    public PingpaiAdapter(SingleLayoutHelper singleLayoutHelper, Context context) {
        this.singleLayoutHelper = singleLayoutHelper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pinpai, parent, false);

        return new PingpaiAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_pinpai;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_pinpai = (TextView) itemView.findViewById(R.id.tv_pinpai);


        }
    }
}
