package com.example.p7project.utils;

public interface INetCallBack<T> {
    void onSuccess(T t);

    void onFile(String string);

}
