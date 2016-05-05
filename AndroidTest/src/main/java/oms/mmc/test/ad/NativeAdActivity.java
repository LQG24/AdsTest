package oms.mmc.test.ad;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import oms.mmc.adview.ads.AdBaiduNativeView;
import oms.mmc.test.android.R;

public class NativeAdActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_ad);
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.ad_native);
        //百度原生广告
        AdBaiduNativeView adBaiduNativeView = new AdBaiduNativeView();
        adBaiduNativeView.setAdView(this,linearLayout,true);
    }

}
