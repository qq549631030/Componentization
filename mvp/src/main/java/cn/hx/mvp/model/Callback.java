package cn.hx.mvp.model;

/**
 * Created by huangxiang on 2017/8/26.
 */

public interface Callback {
    /**
     * 成功回调
     *
     * @param data 成功返回数据
     */
    void onSuccess(Object... data);

    /**
     * 失败回调
     *
     * @param errorCode 错误码
     * @param errorData 错误数据
     */
    void onFailure(String errorCode, Object... errorData);
}
