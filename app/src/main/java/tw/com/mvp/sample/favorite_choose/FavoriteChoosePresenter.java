package tw.com.mvp.sample.favorite_choose;

/**
 * Created by skywind on 2016/11/22.
 */

public class FavoriteChoosePresenter implements FavoriteChooseContract.Presenter{

    private final FavoriteChooseContract.View mMainView;

    public FavoriteChoosePresenter(FavoriteChooseContract.View mainView) {
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

    }
}
