package tw.com.mvp.sample.main;

/**
 * Created by skywind on 2016/11/22.
 */

public class MainPresenter implements MainContract.Presenter{

    private final MainContract.View mMainView;

    public MainPresenter(MainContract.View mainView) {
        mMainView = mainView;
    }

    @Override
    public void start() {
        callAPI();
    }

    public void callAPI(){
        //TODO loadStoreFragment API
        clickMainFragment();
    }

    @Override
    public void clickMemberFragment() {
        mMainView.loadMemberFragment();
    }

    @Override
    public void clickPlayListFragment() {
        mMainView.loadPlayListFragment();
    }

    @Override
    public void clickMainFragment() {
        mMainView.loadDefaultFragment();
    }
}
