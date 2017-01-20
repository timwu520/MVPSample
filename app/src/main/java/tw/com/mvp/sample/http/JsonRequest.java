package tw.com.mvp.sample.http;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import tw.com.mvp.sample.util.TLog;

/**
 * Created by skywind on 2016/4/25.
 */
public class JsonRequest {

    public static String TAG = "debug-okhttp";
    public static boolean isDebug = true;
    public boolean isRunning = true;

    private Handler handler = new Handler(Looper.getMainLooper());

    public interface Response {
        void onSuccess(String responseObject);

        void onFail(String error);
    }

    public void doHttpPost(final String url, HashMap<String, String> requestMap, final ApiCallback callback) {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();

        if (null != requestMap) {
            for (Map.Entry<String, String> entry : requestMap.entrySet()) {

                System.out.println("Key = " + entry.getKey() + ", Value = "
                        + entry.getValue());
                builder.add(entry.getKey(), entry.getValue().toString());

            }
        }

        RequestBody body = builder.build();

        Request request = new Request.Builder().url(url).post(body).build();

        onStart(callback);

        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                onError(callback, e.getMessage());
                Log.i(TAG, "JJJ ____onFailure____ = " + url + " : " +  e.getMessage());
                call.cancel();
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                if (response.isSuccessful()) {

                    onSuccess(callback, response.body().string());

                } else {
                    onError(callback, response.message());
                }
            }
        });
    }

    public void doHttpGet(String url, HashMap<String, String> requestMap, Response response) {
//        OkHttpClient client = new OkHttpClient();
//
//
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//
//        okhttp3.Response response = null;
//        try {
//            response = client.newCall(request).execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return response.body().string();
    }

    /**
     * log信息打印
     *
     * @param params
     */
    public void debug(String params) {
        if (false == isDebug) {
            return;
        }

        if (null == params) {
            Log.d(TAG, "params is null");
        } else {
            Log.d(TAG, params);
        }
    }

    private void onStart(ApiCallback callback) {
        if (null != callback) {
            callback.onStart();
        }
    }

    private void onSuccess(final ApiCallback callback, final String data) {

        debug(data);
        TLog.d("ooxx", this.getClass().getSimpleName() + " " + "callback : " + callback);
        TLog.d("ooxx", this.getClass().getSimpleName() + " " + "isRunning : " + isRunning);
        if (null != callback && isRunning) {
            handler.post(new Runnable() {
                public void run() {
                    // 需要在主线程的操作。
                    callback.onSuccess(data);
                }
            });
        }
    }

    private void onSuccess(final ApiCallback callback, final byte[] data) {
        TLog.d("ooxx", this.getClass().getSimpleName() + " " + "callback : " + callback);
        TLog.d("ooxx", this.getClass().getSimpleName() + " " + "isRunning : " + isRunning);
        if (null != callback && isRunning) {
            handler.post(new Runnable() {
                public void run() {
                    // 需要在主线程的操作。
                    callback.onSuccess(data);
                }
            });
        }
    }

    private void onError(final ApiCallback callback, final String msg) {
        TLog.d("ooxx", this.getClass().getSimpleName() + " " + "callback : " + callback);
        TLog.d("ooxx", this.getClass().getSimpleName() + " " + "isRunning : " + isRunning);
        if (null != callback && isRunning) {
            handler.post(new Runnable() {
                public void run() {
                    // 需要在主线程的操作。
                    callback.onError(msg);
                }
            });
        }
    }

    /**
     * http请求回调
     *
     * @author Flyjun
     */
    public static abstract class ApiCallback {
        // 开始
        public void onStart() {

        }

        // 成功回调
        public abstract void onSuccess(String data);

        // 成功回調圖片檔
        public void onSuccess(byte[] data){}

        // 失败回调
        public abstract void onError(String msg);
    }
}
