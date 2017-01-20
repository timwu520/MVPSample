package tw.com.mvp.sample.favorite_choose;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import tw.com.mvp.sample.R;
import tw.com.mvp.sample.dialog.SimpleProgressDialog;

public class FavoriteChooseActivity extends AppCompatActivity implements FavoriteChooseContract.View{

    FavoriteChooseContract.Presenter mPresenter;

    private SimpleProgressDialog mSimpleProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_choosse);
        mPresenter = new FavoriteChoosePresenter(this);
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
        Intent intent = new Intent(context, FavoriteChooseActivity.class);
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
