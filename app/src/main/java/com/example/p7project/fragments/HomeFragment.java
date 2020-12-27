package com.example.p7project.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.p7project.Beans.BannerBean;
import com.example.p7project.Beans.GridBean;
import com.example.p7project.Beans.SouBean;
import com.example.p7project.R;
import com.example.p7project.adapters.BannerAdapter;
import com.example.p7project.adapters.ColumnAdapter;
import com.example.p7project.adapters.PingpaiAdapter;
import com.example.p7project.adapters.SingleAdapter;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
//        <>
    }

    private void initView(View view) {

        RecyclerView rv = view.findViewById(R.id.rv);

        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());
        rv.setLayoutManager(virtualLayoutManager);

        // 设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rv.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);

        //搜索
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();

        ArrayList<SouBean> list = new ArrayList<>();
        list.add(new SouBean(R.drawable.wang,"商品搜索，共239款好物"));
        SingleAdapter singleAdapter = new SingleAdapter(singleLayoutHelper,getActivity(),list);
        singleAdapter.setOnClick(new SingleAdapter.onClick() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), "搜索好物", Toast.LENGTH_SHORT).show();
            }
        });

            //banner
        SingleLayoutHelper singleLayoutHelper1 = new SingleLayoutHelper();


        ArrayList<BannerBean> bannerBeans = new ArrayList<>();
        bannerBeans.add(new BannerBean(R.drawable.g));
        bannerBeans.add(new BannerBean(R.drawable.i));
        bannerBeans.add(new BannerBean(R.drawable.o));
        BannerAdapter bannerAdapter = new BannerAdapter(singleLayoutHelper1, getActivity(), bannerBeans);

        //带三行
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        columnLayoutHelper.setItemCount(5);
        columnLayoutHelper.setPadding(20, 20, 20, 20);


        ColumnAdapter columnAdapter = new ColumnAdapter(columnLayoutHelper, getActivity());


        SingleLayoutHelper singleLayoutHelper2 = new SingleLayoutHelper();
        PingpaiAdapter pingpaiAdapter = new PingpaiAdapter(singleLayoutHelper2, getActivity());





        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        ArrayList<GridBean> gridBeans = new ArrayList<>();
       


        //总的行数用完放进这里
        DelegateAdapter adapter = new DelegateAdapter(virtualLayoutManager, true);
        adapter.addAdapter(singleAdapter);
        adapter.addAdapter(bannerAdapter);
        adapter.addAdapter(columnAdapter);
        adapter.addAdapter(pingpaiAdapter);
        rv.setAdapter(adapter);


    }


}