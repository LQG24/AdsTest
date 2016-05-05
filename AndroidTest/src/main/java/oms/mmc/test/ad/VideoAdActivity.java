package oms.mmc.test.ad;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.baidu.mobad.feeds.NativeResponse;

import oms.mmc.adview.ads.AdBaiduVideoAdview;
import oms.mmc.test.android.R;

/**
 * 类名 ${PROJIECT_NAME} </br>
 * 创建时间:2016年04月06日 下午2:55 </br>
 * 作者:liufuchangxi</br>
 * 更新时间:16/4/6</br>
 * 类说明： </br>
 */
public class VideoAdActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_ad);

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.ad_native);

        AdBaiduVideoAdview videoAdview = new AdBaiduVideoAdview();
        videoAdview.setAdView(this, linearLayout, true);

    }
}
