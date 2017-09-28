package cn.hx.mvp.view;

/**
 * Created by huangxiang on 2017/8/26.
 */

public interface SetDataView<SO> extends BaseMvpView {
    /**
     * 设置数据成功
     *
     * @param data
     */
    void onSetDataSuccess(SO data);

    /**
     * 设置数据失败
     *
     * @param errCode
     * @param errData
     */
    void onSetDataFail(String errCode, Object... errData);
}
