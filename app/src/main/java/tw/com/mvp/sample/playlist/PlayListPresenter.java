package tw.com.mvp.sample.playlist;

/**
 * Created by skywind on 2016/11/22.
 */

public class PlayListPresenter implements PlayListContract.Presenter{

    private final PlayListContract.View mMainView;

    public PlayListPresenter(PlayListContract.View mainView) {
        mMainView = mainView;
//        mMainView.setPresenter(this);
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
