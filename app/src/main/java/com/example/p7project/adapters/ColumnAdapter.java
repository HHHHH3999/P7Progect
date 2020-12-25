package com.example.p7project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.p7project.Beans.BannerBean;
import com.example.p7project.Beans.ColumnBean;
import com.example.p7project.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class ColumnAdapter extends DelegateAdapter.Adapter {
    private ColumnLayoutHelper columnLayoutHelper;
    private Context context;
//    private ArrayList<ColumnBean.DataBean.ChannelBean> list;


    public ColumnAdapter(ColumnLayoutHelper columnLayoutHelper, Context context) {
        this.columnLayoutHelper = columnLayoutHelper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {

        return columnLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_column, parent, false);
        return new ColumnAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_gohome;
        public ImageView iv_can;
        public ImageView iv_pei;
        public ImageView iv_close;
        public ImageView iv_zhiqu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_gohome = (ImageView) itemView.findViewById(R.id.iv_gohome);
            this.iv_can = (ImageView) itemView.findViewById(R.id.iv_can);
            this.iv_pei = (ImageView) itemView.findViewById(R.id.iv_pei);
            this.iv_close = (ImageView) itemView.findViewById(R.id.iv_close);
            this.iv_zhiqu = (ImageView) itemView.findViewById(R.id.iv_zhiqu);

        }
    }
}
