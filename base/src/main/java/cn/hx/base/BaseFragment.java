package cn.hx.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import cn.hx.mvp.presenter.BaseMvpPresenter;
import cn.hx.mvp.view.BaseMvpView;
import cn.hx.mvp.view.BaseViewState;

/**
 * Created by huangxiang on 2017/8/25.
 */

public class BaseFragment<P extends BaseMvpPresenter<V>, V extends BaseMvpView> extends Fragment implements BaseMvpView {

    protected BaseMvpPresenter presenter;

    protected boolean isActivityAttached;

    protected boolean isViewCreated;

    protected boolean isVisible;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = onCreatePresenter();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        isActivityAttached = true;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        if (presenter != null) {
            presenter.attachView((V) this);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = isVisibleToUser;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        isVisible = !hidden;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (presenter != null) {
            BaseViewState viewState = presenter.getViewState();
            if (viewState == null) {
                viewState = onCreateViewState();
                presenter.setViewState(viewState);
            }
            if (viewState != null) {
                viewState.save(this);
            }

        }
    }

    @Override
    public void onDestroyView() {
        if (presenter != null) {
            presenter.detachView();
        }
        super.onDestroyView();
        isViewCreated = false;
    }

    @Override
    public void onDetach() {
        isActivityAttached = false;
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    protected P onCreatePresenter() {
        return null;
    }

    protected BaseViewState<V> onCreateViewState() {
        return null;
    }

    /**
     * 显示/隐藏加载中动画
     *
     * @param show true 显示 false 隐藏
     * @param args 额外参数
     */
    @Override
    public void showLoadingProgress(boolean show, Object... args) {

    }

    /**
     * 通用错误
     *
     * @param errorData 错误数据(建议[errorCode,errorMsg,other])
     */
    @Override
    public void showError(Object... errorData) {

    }
}
