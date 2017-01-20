package tw.com.mvp.sample.http;

/**
 * Created by skywind on 2016/6/6.
 */
public interface JsonResponse {
    void onSuccess(String response);
    void onError(String message);
}
