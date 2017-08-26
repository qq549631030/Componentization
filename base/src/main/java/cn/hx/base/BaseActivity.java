package cn.hx.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.hx.mvp.presenter.BaseMvpPresenter;
import cn.hx.mvp.view.BaseMvpView;
import cn.hx.mvp.view.BaseViewState;

/**
 * Created by huangxiang on 2017/8/25.
 */

public class BaseActivity<P extends BaseMvpPresenter<V>, V extends BaseMvpView> extends AppCompatActivity implements BaseMvpView {

    protected BaseMvpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = onCreatePresenter();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
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
    protected void onDestroy() {
        if (presenter != null) {
            presenter.detachView();
        }
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

    /**
     * 加载数据成功
     *
     * @param data
     */
    @Override
    public <T> void onLoadDataSuccess(T data) {

    }

    /**
     * 加载数据失败
     *
     * @param errCode
     * @param errData
     */
    @Override
    public void onLoadDataFail(String errCode, Object... errData) {

    }

    /**
     * 更新数据成功
     *
     * @param data
     */
    @Override
    public <T> void onUpdateDataSuccess(T data) {

    }

    /**
     * 更新数据失败
     *
     * @param errCode
     * @param errData
     */
    @Override
    public void onUpdateDataFail(String errCode, Object... errData) {

    }
}
