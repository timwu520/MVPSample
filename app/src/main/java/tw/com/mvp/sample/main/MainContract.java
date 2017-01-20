package tw.com.mvp.sample.main;

import tw.com.mvp.sample.baseinterface.BasePresenter;
import tw.com.mvp.sample.baseinterface.BaseView;

/**
 * Created by Tim on 2016/11/22.
 */

public interface MainContract {

    interface View extends BaseView<Presenter>{
        void showProgressDialog();
        void dismissProgressDialog();
        void loadDefaultFragment();
        void loadMemberFragment();
        void loadPlayListFragment();
    }

    interface Presenter extends BasePresenter {
        void clickMemberFragment();
        void clickPlayListFragment();
        void clickMainFragment();
    }
}
