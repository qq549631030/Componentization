package cn.hx.mvp.view;

/**
 * Created by huangxiang on 2017/8/26.
 */

public interface LoadDataView<LO> extends BaseMvpView {
    /**
     * 加载数据成功
     *
     * @param data
     */
    void onLoadDataSuccess(LO data);

    /**
     * 加载数据失败
     *
     * @param errCode
     * @param errData
     */
    void onLoadDataFail(String errCode, Object... errData);

}
