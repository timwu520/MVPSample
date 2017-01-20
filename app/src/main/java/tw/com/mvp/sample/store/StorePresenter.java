package tw.com.mvp.sample.store;

/**
 * Created by skywind on 2016/11/22.
 */

public class StorePresenter implements StoreContract.Presenter{

    private final StoreContract.View mStoreView;

    public StorePresenter(StoreContract.View storeView) {
        mStoreView = storeView;
    }

    @Override
    public void start() {
        callAPI();
    }

    public void callAPI(){
        mStoreView.showProgressDialog();
        mStoreView.dismissProgressDialog();
    }



}
