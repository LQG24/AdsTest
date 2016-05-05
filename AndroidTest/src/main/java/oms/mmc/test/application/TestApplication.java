package oms.mmc.test.application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.view.KeyEvent;

import oms.mmc.app.MMCApplication;
import oms.mmc.tools.BaseLingJiReturn;
import oms.mmc.tools.CNLingJiReturn;
import oms.mmc.versionhelper.BaseMainUIVersionManager;
import oms.mmc.versionhelper.BasePayVersionManager;
import oms.mmc.versionhelper.MMCVersionHelper;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2015/6/5<br>
 * <b>Author:</b> Enter<br>
 * <b>Description:</b> <br>
 */
public class TestApplication extends MMCApplication {

    static {
        System.loadLibrary("uninstall");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        registerUninstall();
        MMCVersionHelper mmcVersionHelper = getMMCVersionHelper();
        mmcVersionHelper.setMainUIVersionManager(TestMainUiVersionManager.class);
        mmcVersionHelper.setPayVersionManager(TestPayVersionManager.class);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    protected void setupVersionHelper() {
        super.setupVersionHelper();

    }

    public static class  TestMainUiVersionManager extends BaseMainUIVersionManager{

        LingJiReturn mLingji ;
        public TestMainUiVersionManager(){

        }
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mLingji= new LingJiReturn(getActivity());
        }
        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            return super.onKeyDown(keyCode, event);
        }
        @Override
        public BaseLingJiReturn getLingJiReturn() {
            return mLingji;
        }
    }

    static class  LingJiReturn extends CNLingJiReturn{

        public LingJiReturn(Activity activity) {
            super(activity);
        }

        @Override
        protected void onConfig() {
            super.onConfig();
        }
    }
    public class TestPayVersionManager extends BasePayVersionManager{

        public TestPayVersionManager(){

        }
        @Override
        public void onDestroy() {

        }


        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {

        }
    }


}
