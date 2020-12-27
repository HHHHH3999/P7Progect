package com.example.p7project.p;


import com.example.p7project.Base.BasePresenter;
import com.example.p7project.Beans.ColumnBean;
import com.example.p7project.contract.IContract;
import com.example.p7project.m.ModleImpl;
import com.example.p7project.utils.INetCallBack;
import com.example.p7project.utils.URLConstant;

public class PersenterImpl extends BasePresenter<IContract.IView, IContract.IModle> implements IContract.IPresenter {


    public void getColumnbean() {
        imodel.getData(URLConstant.BANNER, new INetCallBack<ColumnBean>() {
            @Override
            public void onSuccess(ColumnBean columnBean) {
                ivew.getData(columnBean);
            }

            @Override
            public void onFile(String string) {

            }
        });
    }

    @Override
    protected IContract.IModle getModel() {
        return new ModleImpl();
    }


}
