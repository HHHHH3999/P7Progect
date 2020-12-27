package com.example.p7project.contract;


import com.example.p7project.Base.BaseModle;
import com.example.p7project.Base.BaseView;
import com.example.p7project.Beans.BannerBean;
import com.example.p7project.Beans.ColumnBean;
import com.example.p7project.utils.INetCallBack;

public interface IContract {
    public interface IModle extends BaseModle {
        <T> void getData(String url, INetCallBack<ColumnBean> iNetCallBack);
    }

    public interface IPresenter {
        void getColumnbean();
    }

    interface IView extends BaseView {
        void getData(ColumnBean columnBean);
    }
}