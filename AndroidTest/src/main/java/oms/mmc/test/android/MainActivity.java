package oms.mmc.test.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import oms.mmc.app.BaseMMCActivity;
import oms.mmc.app.fragment.BaseMMCFragmentActivity;
import oms.mmc.app.fragment.WebBrowserFragment;
import oms.mmc.pay.MMCPayController;
import oms.mmc.pay.OrderAsync;
import oms.mmc.pay.alipay.AliPay;
import oms.mmc.pay.gmpay.GMPayManagerV3;
import oms.mmc.pay.service.SaveOrderService;
import oms.mmc.test.ad.TestApi;
import oms.mmc.tools.OnPayBackListener;
import oms.mmc.tools.Umeng;
import oms.mmc.util.L;
import oms.mmc.util.Util;

//import com.taobao.example.xp.config.Configuration;
//import com.taobao.newxp.common.AlimmContext;
//import com.taobao.newxp.common.ExchangeConstants;
//import com.taobao.newxp.controller.ExchangeDataService;
//import com.taobao.newxp.view.ExchangeViewManager;

/**
 * <b>Project</b> <i>MMCSDKV2</i><br>
 * <b>Create Date</b> <i>2014/8/20</i><br>
 * <b>Author</b> <i>Gordon</i><br>
 * <b>Email</b> <i>gaoyulong@mmclick.com</i><br>
 * <b>Update Date</b> <i>2014/8/20 16:46</i><br>
 * <b>Last Update</b> <i>Gordon</i><br>
 * <b>Description</b> <i>
 * <p/>
 * </i>
 */
public class MainActivity extends BaseMMCActivity implements MMCPayController.OnOrderResult {
    WebBrowserFragment fragment;

    private MMCPayController mPayController;
    static final String PRODUCT_ID = "2000";
    static final String SERVER_ID = "bzpp_shiyefenxi_jiankangfenxi_hunpeijianyi_2015yuncheng";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        requestAdsSize(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_activity_alipay);
        findViewById(R.id.ad_mmc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), TestApi.class));
            }
        });
        L.Debug = true;
        final String devicesn = Util.getUUID(this);
        final String channel = Umeng.getUmengChannel(this);
//        final String shopName = MMCUtil.getAliPayShopName(
//                MainActivity.this, null, "选择择日");
//        final String shopContent = "一次性支付5元即可以解锁全部宜忌择日项目，让你更方便找到用事好日子！";
//
        mPayController = new MMCPayController(this, null, this);
        final AliPay mAliPay = mPayController.getAliPay(this);
//        final GMPayManagerV3 mGmPay = mPayController.getGMPay(this, consumableSkus, null, null);
////        final Unionpay mUnionpay= mPayController.getUnionPay(this);
//
////        final InlandPay inlandPay = new InlandPay(this, "300002811422", "95897DA1C298D5EB", this);
        final Activity activity = MainActivity.this;
//        final TextView textView = (TextView) findViewById(R.id.pay_info);
        findViewById(R.id.pay_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MMCPayController.ServiceContent sc = getPayServiceContent();
                mPayController.alipay(activity,
                                      mAliPay,
                                      PRODUCT_ID,
                                      SERVER_ID,
                                      sc,
                                      0.01f,
                                      "test",
                                      "test","281");

//                GMPayManagerV3 mGmPay = mPayController.getGMPay(MainActivity.this,
//                                                                consumableSkus,
//                                                                null,
//                                                                null);
//                MMCPayController.ServiceContent sc = getGmServiceContent();
//                mPayController.gmpay(activity,
//                                     mGmPay,
//                                     PRODUCT_ID,
//                                     SERVER_ID,
//                                     sc,
//                                     "qiming_tuijianmingzi");
            }
        });

        findViewById(R.id.save_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context = MainActivity.this;
                SaveOrderService.start(context);
            }
        });

        findViewById(R.id.recover_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        final Context context = MainActivity.this;
                        OrderAsync.OrderRecoverData data = OrderAsync.getInstance(context)
                                .getOrderRecoverData(null, null, devicesn, PRODUCT_ID, channel);
                        if (null != data && data.getOrderContentDatas().size() != 0) {
                            for (OrderAsync.OrderContentData d : data.getOrderContentDatas()) {
                                L.d("[test] [order] orderdata=" + d.toString());
                            }
                        }
                    }
                }.start();
            }
        });
    }

    static MMCPayController.ServiceContent getPayServiceContent() {
        MMCPayController.ServiceContent sc = new MMCPayController.ServiceContent(1, "{这是测试银联支付}");
        return sc;
    }

    public static MMCPayController.ServiceContent getGmServiceContent() {
        MMCPayController.ServiceContent sc = new MMCPayController.ServiceContent(1,
                                                                                 "{\"familyname\":\"于\",\"birthday\":1438143360,\"gender\":1,\"datetype\":0}");
        return sc;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        String purchaseData = data.getStringExtra(IabHelper.RESPONSE_INAPP_PURCHASE_DATA);
//        L.d("[order] [gmpay] purchaseData1 = " + purchaseData);
//
//        JSONObject o = JsonUtils.toJson(purchaseData);
//        String developerPayload = o.optString("developerPayload");
//        if (developerPayload.contains(mPayController.OFFLINE_GMPAY_FLAG)) {
//            developerPayload = developerPayload.replace(mPayController.OFFLINE_GMPAY_FLAG, "");
//            JsonUtils.optPut(o, "developerPayload", developerPayload);
//
//            data.putExtra(IabHelper.RESPONSE_INAPP_PURCHASE_DATA, o.toString());
//        }
//        purchaseData = data.getStringExtra(IabHelper.RESPONSE_INAPP_PURCHASE_DATA);
//        L.d("[order] [gmpay] purchaseData2 = " + purchaseData);

        mPayController.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (null != fragment && fragment.onKeyDown(keyCode, event)) {
//            return true;
//        }
        return super.onKeyDown(keyCode, event);
    }

    private void testPayButton(OnPayBackListener listener) {
        listener.onPayBack(true);
    }

    private void postDelay(final Runnable r, final long delay) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (!isFinishing()) {
                    runOnUiThread(r);
                }
            }
        }, delay);
    }

    @Override
    public void onPaySuccessed(String productid,
                               String serverid,
                               MMCPayController.ServiceContent serviceContent) {
        Toast.makeText(this,"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPayFailture(String productid,
                              String serverid,
                              MMCPayController.ServiceContent serviceContent) {

    }

    @Override
    public void onPayCancel(String productid,
                            String serverid,
                            MMCPayController.ServiceContent serviceContent) {
    }

}
