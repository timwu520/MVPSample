package tw.com.mvp.sample.store;

import tw.com.mvp.sample.baseinterface.BasePresenter;
import tw.com.mvp.sample.baseinterface.BaseView;

/**
 * Created by Tim on 2016/11/22.
 */

public interface StoreContract {

    interface View extends BaseView<Presenter>{
        void showProgressDialog();
        void dismissProgressDialog();
    }

    interface Presenter extends BasePresenter {

    }
}
