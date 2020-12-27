package com.example.p7project.m;


import com.example.p7project.Beans.ColumnBean;
import com.example.p7project.contract.IContract;
import com.example.p7project.utils.INetCallBack;
import com.example.p7project.utils.RetrofitUtils;

public class ModleImpl implements IContract.IModle {

    @Override
    public <T> void getData(String url, INetCallBack<ColumnBean> iNetCallBack) {
        RetrofitUtils.getRetrofitUtils().getColumnbean(url, iNetCallBack);
    }
}
