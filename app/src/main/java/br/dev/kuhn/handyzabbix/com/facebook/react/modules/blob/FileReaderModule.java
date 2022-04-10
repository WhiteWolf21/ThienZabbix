package com.facebook.react.modules.blob;

import android.util.Base64;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.fbreact.specs.NativeFileReaderModuleSpec;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import expo.modules.notifications.service.NotificationsService;

@ReactModule(name = "FileReaderModule")
public class FileReaderModule extends NativeFileReaderModuleSpec {
    private static final String ERROR_INVALID_BLOB = "ERROR_INVALID_BLOB";
    public static final String NAME = "FileReaderModule";

    public String getName() {
        return NAME;
    }

    public FileReaderModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private BlobModule getBlobModule(String str) {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            return (BlobModule) reactApplicationContextIfActiveOrWarn.getNativeModule(BlobModule.class);
        }
        return null;
    }

    public void readAsText(ReadableMap readableMap, String str, Promise promise) {
        BlobModule blobModule = getBlobModule("readAsText");
        if (blobModule == null) {
            promise.reject((Throwable) new IllegalStateException("Could not get BlobModule from ReactApplicationContext"));
            return;
        }
        byte[] resolve = blobModule.resolve(readableMap.getString("blobId"), readableMap.getInt(TypedValues.Cycle.S_WAVE_OFFSET), readableMap.getInt("size"));
        if (resolve == null) {
            promise.reject(ERROR_INVALID_BLOB, "The specified blob is invalid");
            return;
        }
        try {
            promise.resolve(new String(resolve, str));
        } catch (Exception e) {
            promise.reject((Throwable) e);
        }
    }

    public void readAsDataURL(ReadableMap readableMap, Promise promise) {
        BlobModule blobModule = getBlobModule("readAsDataURL");
        if (blobModule == null) {
            promise.reject((Throwable) new IllegalStateException("Could not get BlobModule from ReactApplicationContext"));
            return;
        }
        byte[] resolve = blobModule.resolve(readableMap.getString("blobId"), readableMap.getInt(TypedValues.Cycle.S_WAVE_OFFSET), readableMap.getInt("size"));
        if (resolve == null) {
            promise.reject(ERROR_INVALID_BLOB, "The specified blob is invalid");
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("data:");
            if (!readableMap.hasKey(NotificationsService.EVENT_TYPE_KEY) || readableMap.getString(NotificationsService.EVENT_TYPE_KEY).isEmpty()) {
                sb.append("application/octet-stream");
            } else {
                sb.append(readableMap.getString(NotificationsService.EVENT_TYPE_KEY));
            }
            sb.append(";base64,");
            sb.append(Base64.encodeToString(resolve, 2));
            promise.resolve(sb.toString());
        } catch (Exception e) {
            promise.reject((Throwable) e);
        }
    }
}
