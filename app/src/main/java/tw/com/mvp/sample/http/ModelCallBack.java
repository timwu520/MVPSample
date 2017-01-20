package tw.com.mvp.sample.http;

/**
 * Created by skywind on 2016/4/29.
 */
public interface ModelCallBack<T> {
    void onSuccess(T t);

    void onFail(String message);
}