package tw.com.mvp.sample.member;

/**
 * Created by skywind on 2016/11/22.
 */

public class MemberCenterPresenter implements MemberCenterContract.Presenter{

    private final MemberCenterContract.View mMainView;

    public MemberCenterPresenter(MemberCenterContract.View mainView) {
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
    public void callLoadMemberList() {

    }
}
