package oms.mmc.test.ad;

import android.os.Bundle;
import android.app.Activity;

import oms.mmc.adview.DaPingFactory;
import oms.mmc.adview.ImpDaPingAd;
import oms.mmc.test.android.R;
import oms.mmc.util.MMCConstants;

public class BaiDuDaPingAcitity extends Activity {
    ImpDaPingAd impDaPingAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_du_da_ping_acitity);
        impDaPingAd = DaPingFactory.getDaPingAd(this, MMCConstants.DaPing.BAIDU);
        impDaPingAd.initDapingAd();
        impDaPingAd.showDaPingAd(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        impDaPingAd.destoryDaPingAd();
    }
}
