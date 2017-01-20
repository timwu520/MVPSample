package tw.com.mvp.sample.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import tw.com.mvp.sample.R;
import tw.com.mvp.sample.dialog.SimpleProgressDialog;

public class LoginActivity extends AppCompatActivity implements LoginContract.View{

    LoginContract.Presenter mPresenter;

    private EditText mEtAccount;
    private EditText mEtPassword;

    private SimpleProgressDialog mSimpleProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mPresenter = new LoginPresenter(this);
        initUI();
    }

    private void initUI(){
        mSimpleProgressDialog = new SimpleProgressDialog(this);
        //TODO findViewById
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void showProgressDialog() {
        mSimpleProgressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        mSimpleProgressDialog.dismiss();
    }
}
