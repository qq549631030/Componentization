package cn.hx.mvp;

/**
 * Created by huangxiang on 2017/8/26.
 */

public interface Cancelable {

    /**
     * 取消操作
     *
     * @param args 参数
     */
    boolean cancel(Object... args);
}
