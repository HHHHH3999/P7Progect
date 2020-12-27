package com.example.p7project.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.p7project.Base.BaseFragment;
import com.example.p7project.Beans.ColumnBean;
import com.example.p7project.R;
import com.example.p7project.adapters.BannerAdapter;
import com.example.p7project.adapters.ColumnAdapter;
import com.example.p7project.adapters.PingpaiAdapter;
import com.example.p7project.adapters.SingleAdapter;
import com.example.p7project.contract.IContract;
import com.example.p7project.p.PersenterImpl;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseFragment<PersenterImpl> implements IContract.IView {

    private RecyclerView rv;
    private View view;
    private VirtualLayoutManager virtualLayoutManager;
    private ColumnAdapter columnAdapter;
    private PingpaiAdapter pingpaiAdapter;
    private GridLayoutHelper gridLayoutHelper;
    private BannerAdapter bannerAdapter;
    private SingleAdapter singleAdapter;
    private DelegateAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initView();
        return view;
//        <>
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
presenter.getColumnbean();
    }

    @Override
    protected void initView() {
        RecyclerView rv = view.findViewById(R.id.rv);
        virtualLayoutManager = new VirtualLayoutManager(getActivity());
        rv.setLayoutManager(virtualLayoutManager);

        // 设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rv.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);


        //总的行数用完放进这里
        adapter = new DelegateAdapter(virtualLayoutManager, true);

        rv.setAdapter(adapter);
    }

    @Override
    protected PersenterImpl getPresenter() {
        return new PersenterImpl();
    }





    @Override
    public <T> void getData(T t) {
ColumnBean columnBean= (ColumnBean) t;
        List<ColumnBean.DataBean.BannerBean> banner = columnBean.getData().getBanner();






        //搜索
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();

        ArrayList<ColumnBean.DataBean.BannerBean> list = new ArrayList<>();
        list.addAll(banner);
        singleAdapter = new SingleAdapter(singleLayoutHelper, getActivity(),list);
        singleAdapter.setOnClick(new SingleAdapter.onClick() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), "搜索好物", Toast.LENGTH_SHORT).show();
            }
        });

        //banner
        SingleLayoutHelper singleLayoutHelper1 = new SingleLayoutHelper();


        ArrayList<ColumnBean.DataBean.BannerBean> bannerBeans = new ArrayList<>();

        bannerAdapter = new BannerAdapter(singleLayoutHelper1, getActivity(), bannerBeans);

        //带三行
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        columnLayoutHelper.setItemCount(5);
        columnLayoutHelper.setPadding(20, 20, 20, 20);


        columnAdapter = new ColumnAdapter(columnLayoutHelper, getActivity());


        SingleLayoutHelper singleLayoutHelper2 = new SingleLayoutHelper();
        pingpaiAdapter = new PingpaiAdapter(singleLayoutHelper2, getActivity());


        gridLayoutHelper = new GridLayoutHelper(2);

        adapter.addAdapter(singleAdapter);
        adapter.addAdapter(bannerAdapter);
        adapter.addAdapter(columnAdapter);
        adapter.addAdapter(pingpaiAdapter);




    }
}