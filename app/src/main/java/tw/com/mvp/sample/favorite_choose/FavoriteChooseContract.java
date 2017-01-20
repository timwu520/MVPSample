package tw.com.mvp.sample.favorite_choose;

import tw.com.mvp.sample.baseinterface.BasePresenter;
import tw.com.mvp.sample.baseinterface.BaseView;

/**
 * Created by Tim on 2016/11/22.
 */

public interface FavoriteChooseContract {

    interface View extends BaseView<Presenter>{
        void showProgressDialog();
        void dismissProgressDialog();
    }

    interface Presenter extends BasePresenter {
        void callLoginAPI();
    }
}
