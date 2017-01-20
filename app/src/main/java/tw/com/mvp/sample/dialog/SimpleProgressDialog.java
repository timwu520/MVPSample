package tw.com.mvp.sample.dialog;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Peterson on 2016/8/26.
 */
public class SimpleProgressDialog {

    private ProgressDialog mProgressDialog;

    private Context mContext;

    public SimpleProgressDialog(Context ctx) {
        mContext = ctx;
        initProgressDialog();
    }

    private void initProgressDialog(){
        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setMessage("Loading");
        mProgressDialog.setCancelable(false);
    }

    public void show(){
        if(mProgressDialog != null) {
            mProgressDialog.show();
        }
    }

    public void dismiss(){
        if(mProgressDialog != null && mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }

    public boolean isShowing(){

        if(mProgressDialog.isShowing()){
            return true;
        }else{
            return false;
        }
    }
}

