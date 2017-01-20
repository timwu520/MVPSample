package tw.com.mvp.sample.data;

import java.util.HashMap;

import tw.com.mvp.sample.http.JsonRequest;
import tw.com.mvp.sample.http.JsonResponse;

/**
 * Created by skywind on 2016/6/6.
 */
abstract class BaseApiModel {

    public void postRequest(String url, HashMap<String, String> requestMap, final JsonResponse jsonResponse) {

        JsonRequest jsonRequest = new JsonRequest();
        jsonRequest.doHttpPost(url, requestMap, new JsonRequest.ApiCallback() {
            @Override
            public void onSuccess(String data) {
                jsonResponse.onSuccess(data);
            }

            @Override
            public void onError(String msg) {
                jsonResponse.onError(msg);
            }
        });
    }


    public void getRequest(String url, HashMap<String, String> requestMap, final JsonResponse jsonResponse) {

    }
}
