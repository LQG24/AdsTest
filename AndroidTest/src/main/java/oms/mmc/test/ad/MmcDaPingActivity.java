package oms.mmc.test.ad;

import android.os.Bundle;
import android.app.Activity;

import oms.mmc.adview.DaPingFactory;
import oms.mmc.adview.ImpDaPingAd;
import oms.mmc.adview.MMCInterstitialAd;
import oms.mmc.test.android.R;
import oms.mmc.util.MMCConstants;

public class MmcDaPingActivity extends Activity {
    ImpDaPingAd mmcInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmc_da_ping);

        mmcInterstitialAd = DaPingFactory.getDaPingAd(this, MMCConstants.DaPing.MMC);
        mmcInterstitialAd.initDapingAd();
        mmcInterstitialAd.showDaPingAd(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mmcInterstitialAd.destoryDaPingAd();
    }
}
