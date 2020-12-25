package com.example.p7project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.p7project.Beans.SouBean;
import com.example.p7project.R;

import java.util.ArrayList;

public class SingleAdapter extends DelegateAdapter.Adapter {
private SingleLayoutHelper singleLayoutHelper;
private Context context;
private ArrayList<SouBean> list;
private onClick onClick;

    public void setOnClick(SingleAdapter.onClick onClick) {
        this.onClick = onClick;
    }

    public SingleAdapter(SingleLayoutHelper singleLayoutHelper, Context context, ArrayList<SouBean> list) {
        this.singleLayoutHelper = singleLayoutHelper;
        this.context = context;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sousuo, parent, false);
        return new SingleAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                ViewHolder viewHolder= (ViewHolder) holder;
        SouBean souBean = list.get(position);
        Glide.with(context).load(souBean.getImg()).into(viewHolder.iv_sou);
        viewHolder.tv_sou.setText(souBean.getName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_sou;
        public TextView tv_sou;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_sou = (ImageView) itemView.findViewById(R.id.iv_sou);
            this.tv_sou = (TextView) itemView.findViewById(R.id.tv_sou);
        }
    }
    public interface onClick{
        void onClick(int position);
    }
}

