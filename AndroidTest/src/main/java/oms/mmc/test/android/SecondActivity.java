package oms.mmc.test.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.adsmogo.interstitial.AdsMogoInterstitialManager;

import oms.mmc.adview.AdsHelper;
import oms.mmc.app.BaseMMCActivity;
import oms.mmc.pay.MMCPayController;
import oms.mmc.test.application.TestApplication;
import oms.mmc.util.L;

/**
 * <b>Project</b> <i>mmcsdk</i><br>
 * <b>Create Date</b> <i>2014/8/25</i><br>
 * <b>Author</b> <i>Gordon</i><br>
 * <b>Email</b> <i>gaoyulong@mmclick.com</i><br>
 * <b>Update Date</b> <i>2014/8/25 11:20</i><br>
 * <b>Last Update</b> <i>Gordon</i><br>
 * <b>Description</b> <i>
 * <p/>
 * </i>
 */
public class SecondActivity extends BaseMMCActivity {

    TestApplication.TestMainUiVersionManager uiVersionManager ;

    private MMCPayController mPayController;
    public static final String[] consumableSkus = {
            "qiming_zixuanmingzi",
            "qiming_tuijianmingzi",
            "qiming_tianjiangjiming",
            "qiming_tuijianmingzi_tianjiangjiming",
            "qiming_zixuanmingzi_tianjiangjiming",
            "qiming_zixuanmingzi_tuijianmingzi",
            "qiming_zixuanmingzi_tuijianmingzi_tianjiangjiming"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ad_activity_test);
        AdsHelper.setFlowApp(this, true);
        com.adsmogo.util.L.debug=true;
        AdsMogoInterstitialManager.setInitActivity(this);
        uiVersionManager =(TestApplication.TestMainUiVersionManager)getVersionHelper().getMainUIVersionManager(this);
        if(uiVersionManager == null){
            L.i(" uiVersionManager is null ");
        }
        uiVersionManager.onCreate(savedInstanceState);

//        mPayController = new MMCPayController(this, null, this);
//        final GMPayManagerV3 mGmPay = mPayController.getGMPay(this, consumableSkus, null, null);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                uiVersionManager.getLingJiReturn().showMogoInterstitialAds();
//                startActivity(new Intent(SecondActivity.this,MainActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        uiVersionManager.getLingJiReturn().onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiVersionManager.getLingJiReturn().onActivityResult(requestCode,resultCode,data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        uiVersionManager.getLingJiReturn().onResume();
    }

    public String getStringApp(){
        return "ZGMxOWEyNjI5YzAwOTcz";
    }
}
