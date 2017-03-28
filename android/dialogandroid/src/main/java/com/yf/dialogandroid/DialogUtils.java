package com.yf.dialogandroid;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.facebook.react.bridge.Callback;

/**
 * @version v1.0
 * @package com.yf.dialogandroid
 * @autho Kim
 * @date 2017-03-28
 * @time 15:33
 * @Email: hz_yuchen@sina.cn
 * @description:
 */

public class DialogUtils {
    public static void showDialog(Context context, String content, String negativeLabel, String positiveLabel, final Callback negative, final Callback positive) {

        final Dialog dialog = new Dialog(context);
        View contentView = LayoutInflater.from(context).inflate(R.layout.layout_dialog_normal, null);

        ((TextView) contentView.findViewById(R.id.tv_content)).setText(content);

        TextView tvCancel = (TextView) contentView.findViewById(R.id.tv_cancel);
        tvCancel.setText(negativeLabel);
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (null != negative) {
                    negative.invoke();
                }
            }
        });

        TextView tvConform = (TextView) contentView.findViewById(R.id.tv_conform);
        tvConform.setText(positiveLabel);
        tvConform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (null != positive) {
                    positive.invoke();
                }
            }
        });
        dialog.setTitle(null);
        dialog.setContentView(contentView);
        dialog.show();
    }
}
