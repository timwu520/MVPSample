package tw.com.mvp.sample.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import tw.com.mvp.sample.R;
import tw.com.mvp.sample.dialog.SimpleProgressDialog;
import tw.com.mvp.sample.member.MemberFragment;
import tw.com.mvp.sample.playlist.PlayListFragment;
import tw.com.mvp.sample.store.StoreFragment;
import tw.com.mvp.sample.util.FragmentCallback;
import tw.com.mvp.sample.util.TLog;

public class MainActivity extends AppCompatActivity implements MainContract.View, FragmentCallback {

    MainContract.Presenter mPresenter;
    private SimpleProgressDialog mSimpleProgressDialog;
    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the navigation drawer.
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);

        // Create the presenter
        mPresenter = new MainPresenter(this);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_member:
                        mPresenter.clickMemberFragment();
                        break;
                    case R.id.action_main:
                        mPresenter.clickMainFragment();
                        break;
                    case R.id.action_play:
                        mPresenter.clickPlayListFragment();
                        break;
                }
                return true;
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void loadMemberFragment() {
        String tag = "MemberFragment";
        Fragment fragment = MemberFragment.newInstance("");

        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //過場動畫
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        fragmentTransaction.replace(R.id.contentFrame, fragment);
        TLog.i(this.getClass().getName(), "Ernest loadMemberFragment");
        if (tag != null) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void loadPlayListFragment() {
        String tag = "PlayListFragment";
        Fragment fragment = PlayListFragment.newInstance("");

        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //過場動畫
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        fragmentTransaction.replace(R.id.contentFrame, fragment);
        TLog.i(this.getClass().getName(), "Ernest loadPlayListFragment");
        if (tag != null) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void loadStoreFragment() {
        String tag = "StoreFragment";
        Fragment fragment = StoreFragment.newInstance("");

        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //過場動畫
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        fragmentTransaction.replace(R.id.contentFrame, fragment);
        TLog.i(this.getClass().getName(), "Ernest loadStoreFragment");
        if (tag != null) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissProgressDialog() {

    }

    @Override
    public void loadDefaultFragment() {
        loadStoreFragment();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
