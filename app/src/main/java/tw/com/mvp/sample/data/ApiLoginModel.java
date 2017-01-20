package tw.com.mvp.sample.data;

import java.util.HashMap;

import tw.com.mvp.sample.http.JsonResponse;
import tw.com.mvp.sample.http.ModelCallBack;
import tw.com.mvp.sample.object.LoginItem;
import tw.com.mvp.sample.util.Pub;
import tw.com.mvp.sample.util.TLog;

/**
 * Created by skywind on 2016/4/29.
 */
public class ApiLoginModel extends BaseApiModel {
//
    private ModelCallBack<LoginItem> loginCallBack;

    public ApiLoginModel(ModelCallBack<LoginItem> back) {
        this.loginCallBack = back;
    }

    public void call(String userToken) {
        HashMap<String, String> requestMap = new HashMap<>();
        requestMap.put("token", Pub.API_TOKEN);
        requestMap.put("user_token", userToken);
        callApiAndLoad(requestMap);
    }

    private void callApiAndLoad(HashMap<String, String> requestMap) {
        this.postRequest("http://www.yahoo.com.tw", requestMap, new JsonResponse() {
            @Override
            public void onSuccess(String response) {
                //TODO Gson
                TLog.i(this.getClass().getName(),"Ernest response : " + response);
            }

            @Override
            public void onError(String message) {

            }
        });
    }
}
