package cn.hx.mvp.view;

/**
 * Created by huangxiang on 2017/8/26.
 */

public interface BaseViewState <V extends BaseMvpView> {
    void apply(V view);

    void save(V view);
}
