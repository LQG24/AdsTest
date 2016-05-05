package oms.mmc.test.ad;

import android.os.Bundle;
import android.app.Activity;

import oms.mmc.adview.AdmobInterstitial;
import oms.mmc.adview.DaPingFactory;
import oms.mmc.adview.ImpDaPingAd;
import oms.mmc.test.android.R;
import oms.mmc.util.MMCConstants;

public class AdmobDaPingActivity extends Activity {
    ImpDaPingAd impDaPingAd ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admob_da_ping);
        impDaPingAd = DaPingFactory.getDaPingAd(this, MMCConstants.DaPing.ADMOB);
        impDaPingAd.initDapingAd();
        impDaPingAd.showDaPingAd(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        impDaPingAd.destoryDaPingAd();
    }
}
