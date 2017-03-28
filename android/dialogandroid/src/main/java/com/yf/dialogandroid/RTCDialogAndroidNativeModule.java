package com.yf.dialogandroid;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * @version v1.0
 * @package com.yf.dialogandroid
 * @autho Kim
 * @date 2017-03-28
 * @time 15:36
 * @Email: hz_yuchen@sina.cn
 * @description:
 */

public class RTCDialogAndroidNativeModule extends ReactContextBaseJavaModule {

    private ReactApplicationContext mReactContext;

    public RTCDialogAndroidNativeModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.mReactContext = reactContext;
    }

    @Override
    public String getName() {
        return "DialogAndroid";
    }

    /**
     * 显示普通对话框
     *
     * @param content
     * @param negativeLabel
     * @param positiveLabel
     * @param negative
     * @param positive
     */
    @ReactMethod
    public void show(String content, String negativeLabel, String positiveLabel,
                     Callback negative, Callback positive) {
        DialogUtils.showDialog(mReactContext.getCurrentActivity(),
                content, negativeLabel, positiveLabel, negative, positive);
    }
}
