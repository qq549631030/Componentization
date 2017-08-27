package cn.hx.mvp.presenter;

import java.lang.ref.WeakReference;

import cn.hx.mvp.Cancelable;
import cn.hx.mvp.view.BaseMvpView;
import cn.hx.mvp.view.BaseViewState;

/**
 * Created by huangxiang on 2017/8/26.
 */

public class BaseMvpPresenter<V extends BaseMvpView> implements Cancelable {
    private WeakReference<V> viewRef;

    private BaseViewState viewState;

    /**
     * View 附着到窗口
     *
     * @param mvpView
     */
    public void attachView(V mvpView) {
        viewRef = new WeakReference<V>(mvpView);
        if (viewState != null) {
            viewState.apply(mvpView);
        }
    }

    /**
     * View 从窗口脱离
     */
    public void detachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    public BaseViewState getViewState() {
        return viewState;
    }

    public void setViewState(BaseViewState viewState) {
        this.viewState = viewState;
    }

    /**
     * @return
     */
    public boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    public V getMvpView() {
        return viewRef == null ? null : viewRef.get();
    }

    /**
     * 取消操作
     *
     * @param args 参数
     */
    @Override
    public boolean cancel(Object... args) {
        return false;
    }
}
