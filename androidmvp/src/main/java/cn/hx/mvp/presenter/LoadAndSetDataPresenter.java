package cn.hx.mvp.presenter;

import cn.hx.mvp.view.LoadAndSetDataView;

/**
 * Created by huangxiang on 2017/8/27.
 */

public abstract class LoadAndSetDataPresenter<LI, SI, LO, SO> extends BaseMvpPresenter<LoadAndSetDataView<LO, SO>> {
    /**
     * 加载数据
     *
     * @param param
     */
    protected abstract void loadData(LI param);

    /**
     * 设置数据
     *
     * @param param
     */
    protected abstract void setData(SI param);
}
