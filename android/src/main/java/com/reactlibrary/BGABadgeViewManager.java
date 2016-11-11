package com.reactlibrary;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.TextUtils;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;
import cn.bingoogolapple.badgeview.BGABadgeView;
import cn.bingoogolapple.badgeview.BGABadgeable;
import cn.bingoogolapple.badgeview.BGADragDismissDelegate;

/**
 * Created by poberwong on 2016/11/10.
 */
public class BGABadgeViewManager extends SimpleViewManager<BGABadgeView>{
    public static final String REACT_CLASS = "AndroidBGABadgeView";
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected BGABadgeView createViewInstance(ThemedReactContext reactContext) {
        BGABadgeView mBGABadgeView = new BGABadgeView(reactContext);
        mBGABadgeView.getBadgeViewHelper().setDragable(true);
        return mBGABadgeView;
    }

    @ReactProp(name = "circlePointBadge")
    public void setCirclePointBadge(BGABadgeView view, boolean isShowCircleBadge) {
        if (isShowCircleBadge) {
            view.showCirclePointBadge();
        } else {
            view.hiddenBadge();
        }
    }

    @ReactProp(name = "textBadge")
    public void setTextBadge(BGABadgeView view, String text) {
        if (!TextUtils.isEmpty(text)) {
            view.showTextBadge(text);
        } else {
            view.hiddenBadge();
        }
    }

    @ReactProp(name = "drawableBadge")
    public void setDrawableBadge(BGABadgeView view, String drawableBadge) {
        if (TextUtils.isEmpty(drawableBadge)) {
            view.hiddenBadge();
        } else {
            int resId = getMipmap(view.getContext(), drawableBadge);
            if (resId == 0) {
                view.hiddenBadge();
            } else {
                Bitmap badgeBitmap = BitmapFactory.decodeResource(view.getResources(), resId);
                view.showDrawableBadge(badgeBitmap);
            }
        }
    }

    @ReactProp(name = "badgeTextColor")
    public void setBadgeTextColor(BGABadgeView view, String color) {
        if (!TextUtils.isEmpty(color)) {
            view.getBadgeViewHelper().setBadgeTextColorInt(Color.parseColor(color));
        }
    }

    @ReactProp(name = "badgeBgColor")
    public void setBadgeBgColor(BGABadgeView view, String color) {
        if (!TextUtils.isEmpty(color)) {
            view.getBadgeViewHelper().setBadgeBgColorInt(Color.parseColor(color));
        }
    }

    @ReactProp(name = "dragable")
    public void setDragable(BGABadgeView view, boolean dragable) {
        view.getBadgeViewHelper().setDragable(dragable);
    }

    @ReactProp(name = "badgeTextSizeSp")
    public void setBadgeTextSize(BGABadgeView view, int badgetextSize) {
        view.getBadgeViewHelper().setBadgeTextSizeSp(badgetextSize);
    }

    @ReactProp(name = "badgePaddingDp")
    public void setBadgePadding(BGABadgeView view, int badgePadding) {
        view.getBadgeViewHelper().setBadgePaddingDp(badgePadding);
    }

    @ReactProp(name = "badgeBorderWidthDp")
    public void setBadgeBorderWidthDp(BGABadgeView view, int badgeBorderWidth) {
        view.getBadgeViewHelper().setBadgeBorderWidthDp(badgeBorderWidth);
    }

    @ReactProp(name = "badgeBorderColor")
    public void setBadgeBorderColor(BGABadgeView view, String color) {
        if (!TextUtils.isEmpty(color)) {
            view.getBadgeViewHelper().setBadgeBorderColorInt(Color.parseColor(color));
        }
    }

    @Override
    protected void addEventEmitters(final ThemedReactContext reactContext, final BGABadgeView view) {
        super.addEventEmitters(reactContext, view);
        view.setDragDismissDelegage(new BGADragDismissDelegate() {
            @Override
            public void onDismiss(BGABadgeable badgeable) {
                reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher()
                        .dispatchEvent(new BGABadgeEvent(view.getId()));
            }
        });
    }

    @Override // 正式暴露回调事件
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.<String, Object>builder()
                .put(BGABadgeEvent.EVENT_NAME, MapBuilder.of("registrationName", "onDismiss"))
                .build();
    }

    public static int getMipmap(Context context, String name) {
        return context.getResources().getIdentifier(name, "mipmap", context.getPackageName());
    }
}
