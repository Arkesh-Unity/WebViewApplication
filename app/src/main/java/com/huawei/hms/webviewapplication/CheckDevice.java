package com.huawei.hms.webviewapplication;

import android.app.Activity;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.android.gms.common.GoogleApiAvailability;
import com.huawei.hms.api.HuaweiApiAvailability;

public class CheckDevice {

    private Activity activity;
    private WebView web;

    public CheckDevice(Activity activity, WebView web) {
        this.activity = activity;
        this.web = web;
    }

    @JavascriptInterface
    public void isGMS() {
        final boolean flag = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(activity) == com.google.android.gms.common.ConnectionResult.SUCCESS;
        Toast.makeText(activity, "" + flag, Toast.LENGTH_SHORT).show();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                web.loadUrl("javascript:showResult('"+ "isGMS:" + flag + "')");
            }
        });
    }

    @JavascriptInterface
    public void isHMS() {
        final boolean flag = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(activity) == com.huawei.hms.api.ConnectionResult.SUCCESS;
        Toast.makeText(activity, "" + flag, Toast.LENGTH_SHORT).show();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                web.loadUrl("javascript:showResult('"+ "isHMS:" + flag + "')");
            }
        });
    }
}
