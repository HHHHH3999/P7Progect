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
    private ArrayList<ColumnBean.DataBean.ChannelBean> list;

    public ColumnAdapter(ColumnLayoutHelper columnLayoutHelper, Context context, ArrayList<ColumnBean.DataBean.ChannelBean> list) {
        this.columnLayoutHelper = columnLayoutHelper;
        this.context = context;
        this.list = list;
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
       ViewHolder viewHolder= (ViewHolder) holder;

        viewHolder.banner.setImages(list)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        BannerBean bannerBean= (BannerBean) path;
                        Glide.with(context).load(bannerBean.getImg()).into(imageView);
                    }
                }).start();

    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public Banner banner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.banner = (Banner) itemView.findViewById(R.id.banner);

        }
    }
}
