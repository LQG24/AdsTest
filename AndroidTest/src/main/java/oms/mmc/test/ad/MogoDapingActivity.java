package oms.mmc.test.ad;

import android.os.Bundle;
import android.app.Activity;

import oms.mmc.adview.DaPingFactory;
import oms.mmc.adview.ImpDaPingAd;
import oms.mmc.adview.MogoInterstitialAds;
import oms.mmc.adview.utils.AdConstants;
import oms.mmc.test.android.R;
import oms.mmc.util.MMCConstants;

public class MogoDapingActivity extends Activity {

    ImpDaPingAd mogoInterstitialAds ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mogo_daping);
        mogoInterstitialAds = DaPingFactory.getDaPingAd(this, MMCConstants.DaPing.MOGO);
        mogoInterstitialAds.initDapingAd();
        mogoInterstitialAds.showDaPingAd(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mogoInterstitialAds.destoryDaPingAd();
    }
}
