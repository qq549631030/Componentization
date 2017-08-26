package cn.hx.mvp.view;

/**
 * Created by huangxiang on 2017/8/26.
 */

public interface BaseMvpView {
    /**
     * 显示/隐藏加载中动画
     *
     * @param show true 显示 false 隐藏
     * @param args 额外参数
     */
    void showLoadingProgress(boolean show, Object... args);

    /**
     * 通用错误
     *
     * @param errorData 错误数据(建议[errorCode,errorMsg,other])
     */
    void showError(Object... errorData);

    /**
     * 加载数据成功
     *
     * @param data
     * @param <T>
     */
    <T> void onLoadDataSuccess(T data);

    /**
     * 加载数据失败
     *
     * @param errCode
     * @param errData
     */
    void onLoadDataFail(String errCode, Object... errData);

    /**
     * 更新数据成功
     *
     * @param data
     * @param <T>
     */
    <T> void onUpdateDataSuccess(T data);

    /**
     * 更新数据失败
     *
     * @param errCode
     * @param errData
     */
    void onUpdateDataFail(String errCode, Object... errData);
}
