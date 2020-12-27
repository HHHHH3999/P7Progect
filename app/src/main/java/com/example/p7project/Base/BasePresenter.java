package com.example.p7project.Base;

public abstract class BasePresenter<T extends BaseView, I extends BaseModle> {
    public T ivew;

    public I imodel;

    public void attachView(T t) {
        ivew = t;
        imodel = getModel();
    }

    public void deleteView() {
        ivew = null;
        imodel = null;
    }

    protected abstract I getModel();


}
