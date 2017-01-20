package tw.com.mvp.sample.login;

import tw.com.mvp.sample.data.ApiLoginModel;
import tw.com.mvp.sample.http.ModelCallBack;
import tw.com.mvp.sample.object.LoginItem;

/**
 * Created by skywind on 2016/11/22.
 */

public class LoginPresenter implements LoginContract.Presenter{

    private final LoginContract.View mMainView;

    public LoginPresenter(LoginContract.View mainView) {
        mMainView = mainView;
    }

    @Override
    public void start() {
        callAPI();
    }

    public void callAPI(){
        mMainView.showProgressDialog();
        mMainView.dismissProgressDialog();
    }

    @Override
    public void callLoginAPI() {
        ModelCallBack<LoginItem> back = new ModelCallBack<LoginItem>() {
            @Override
            public void onSuccess(LoginItem loginItem) {

            }

            @Override
            public void onFail(String message) {

            }
        };

        ApiLoginModel apiLoginModel = new ApiLoginModel(back);
        apiLoginModel.call("");
    }
}
