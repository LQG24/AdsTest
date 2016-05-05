package oms.mmc.test.ad;

import android.os.Bundle;
import android.app.Activity;
import android.widget.LinearLayout;

import oms.mmc.adview.ads.AdGdtNativeView;
import oms.mmc.app.BaseMMCActivity;
import oms.mmc.test.android.R;

public class GdtAdActivity extends BaseMMCActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gdt_ad);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.demo_gdt_ad);
        AdGdtNativeView nativeView = new AdGdtNativeView();
        nativeView.setAdView(this,linearLayout,true);
        nativeView.showAdView();//如果true的话 这句可以忽略
    }

}
