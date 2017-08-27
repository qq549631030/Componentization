package cn.hx.mvp.presenter;

import cn.hx.mvp.view.SetDataView;

/**
 * Created by huangxiang on 2017/8/27.
 */

public abstract class SetDataPresenter<I, O> extends BaseMvpPresenter<SetDataView<O>> {
    /**
     * 设置数据
     *
     * @param param
     */
    protected abstract void setData(I param);
}
