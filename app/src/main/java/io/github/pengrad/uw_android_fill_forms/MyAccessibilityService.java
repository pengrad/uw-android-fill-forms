package io.github.pengrad.uw_android_fill_forms;

import android.accessibilityservice.AccessibilityService;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/**
 * stas
 * 8/10/15
 */
public class MyAccessibilityService extends AccessibilityService {

    public static final String TAG = "MyAccessibilityService";

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();

//        AccessibilityServiceInfo config = new AccessibilityServiceInfo();
//        config.packageNames = new String[]{};
//        config.eventTypes = TYPE_WINDOW_STATE_CHANGED;
//        config.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
//        config.flags = AccessibilityServiceInfo.CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT
//
//        if (Build.VERSION.SDK_INT >= 16) {
//            config.flags = AccessibilityServiceInfo.FLAG_INCLUDE_NOT_IMPORTANT_VIEWS;
//        }
//
//        setServiceInfo(config);
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.d(TAG, event.getPackageName() + "  " + event.toString());

        if (event.getClassName().toString().endsWith("TestActivity")) {

            AccessibilityNodeInfo nodeInfo = event.getSource();
            for (AccessibilityNodeInfo node : nodeInfo.findAccessibilityNodeInfosByViewId("io.github.pengrad.uw_android_fill_forms:id/editComment")) {
                Log.d(TAG, node.toString());
                Bundle b = new Bundle();
                b.putCharSequence(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, "set comment");
                node.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, b);
            }

            SystemClock.sleep(500);

            for (AccessibilityNodeInfo node : nodeInfo.findAccessibilityNodeInfosByViewId("io.github.pengrad.uw_android_fill_forms:id/editUser")) {
                Log.d(TAG, node.toString());
                Bundle b = new Bundle();
                b.putCharSequence(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, "set user");
                node.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, b);
            }

            SystemClock.sleep(500);

            for (AccessibilityNodeInfo node : nodeInfo.findAccessibilityNodeInfosByViewId("io.github.pengrad.uw_android_fill_forms:id/buttonTap")) {
                Log.d(TAG, node.toString());
                node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }
        }


//        for (AccessibilityNodeInfo node : nodeInfo.findAccessibilityNodeInfosByViewId("editComment")) {
//            Log.d(TAG, node.toString());
//        }

//        nodeInfo.getChild(i)

    }

    @Override
    public void onInterrupt() {
        Log.d(TAG, "onInterrupt");
    }
}

