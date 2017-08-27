package cn.hx.mvp.presenter;

import cn.hx.mvp.view.LoadDataView;

/**
 * Created by huangxiang on 2017/8/27.
 */

public abstract class LoadDataPresenter<I, O> extends BaseMvpPresenter<LoadDataView<O>> {
    /**
     * 加载数据
     *
     * @param param
     */
    protected abstract void loadData(I param);
}
