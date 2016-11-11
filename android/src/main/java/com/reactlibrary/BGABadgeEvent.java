package com.reactlibrary;

import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/**
 * Created by poberwong on 2016/11/10.
 */
public class BGABadgeEvent extends Event<BGABadgeEvent> {
    public static final String EVENT_NAME = "topDismiss";

    protected BGABadgeEvent(int viewTag) {
        super(viewTag);
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), null);
    }

}