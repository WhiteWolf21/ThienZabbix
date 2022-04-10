package com.reactcommunity.rndatetimepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class RNDatePickerDialogFragment extends DialogFragment {
    private static DialogInterface.OnClickListener mOnNeutralButtonActionListener;
    private DatePickerDialog instance;
    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    private DialogInterface.OnDismissListener mOnDismissListener;

    public Dialog onCreateDialog(Bundle bundle) {
        DatePickerDialog createDialog = createDialog(getArguments(), getActivity(), this.mOnDateSetListener);
        this.instance = createDialog;
        return createDialog;
    }

    public void update(Bundle bundle) {
        RNDate rNDate = new RNDate(bundle);
        this.instance.updateDate(rNDate.year(), rNDate.month(), rNDate.day());
    }

    static DatePickerDialog getDialog(Bundle bundle, Context context, DatePickerDialog.OnDateSetListener onDateSetListener) {
        int i;
        RNDate rNDate = new RNDate(bundle);
        int year = rNDate.year();
        int month = rNDate.month();
        int day = rNDate.day();
        RNDatePickerDisplay valueOf = (bundle == null || bundle.getString("display", (String) null) == null) ? RNDatePickerDisplay.DEFAULT : RNDatePickerDisplay.valueOf(bundle.getString("display").toUpperCase(Locale.US));
        int i2 = C15741.f246x8ff92e2[valueOf.ordinal()];
        if (i2 != 1 && i2 != 2) {
            return new RNDismissableDatePickerDialog(context, onDateSetListener, year, month, day, valueOf);
        }
        if (valueOf == RNDatePickerDisplay.CALENDAR) {
            i = C1570R.style.CalendarDatePickerDialog;
        } else {
            i = C1570R.style.SpinnerDatePickerDialog;
        }
        return new RNDismissableDatePickerDialog(context, i, onDateSetListener, year, month, day, valueOf);
    }

    /* renamed from: com.reactcommunity.rndatetimepicker.RNDatePickerDialogFragment$1 */
    static /* synthetic */ class C15741 {

        /* renamed from: $SwitchMap$com$reactcommunity$rndatetimepicker$RNDatePickerDisplay */
        static final /* synthetic */ int[] f246x8ff92e2;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.reactcommunity.rndatetimepicker.RNDatePickerDisplay[] r0 = com.reactcommunity.rndatetimepicker.RNDatePickerDisplay.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f246x8ff92e2 = r0
                com.reactcommunity.rndatetimepicker.RNDatePickerDisplay r1 = com.reactcommunity.rndatetimepicker.RNDatePickerDisplay.CALENDAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f246x8ff92e2     // Catch:{ NoSuchFieldError -> 0x001d }
                com.reactcommunity.rndatetimepicker.RNDatePickerDisplay r1 = com.reactcommunity.rndatetimepicker.RNDatePickerDisplay.SPINNER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.reactcommunity.rndatetimepicker.RNDatePickerDialogFragment.C15741.<clinit>():void");
        }
    }

    static DatePickerDialog createDialog(Bundle bundle, Context context, DatePickerDialog.OnDateSetListener onDateSetListener) {
        Calendar instance2 = Calendar.getInstance();
        DatePickerDialog dialog = getDialog(bundle, context, onDateSetListener);
        if (bundle != null && bundle.containsKey(RNConstants.ARG_NEUTRAL_BUTTON_LABEL)) {
            dialog.setButton(-3, bundle.getString(RNConstants.ARG_NEUTRAL_BUTTON_LABEL), mOnNeutralButtonActionListener);
        }
        DatePicker datePicker = dialog.getDatePicker();
        Integer timeZoneOffset = getTimeZoneOffset(bundle);
        if (timeZoneOffset != null) {
            instance2.setTimeZone(TimeZone.getTimeZone("GMT"));
        }
        if (bundle == null || !bundle.containsKey(RNConstants.ARG_MINDATE)) {
            datePicker.setMinDate(RNConstants.DEFAULT_MIN_DATE);
        } else {
            instance2.setTimeInMillis(bundle.getLong(RNConstants.ARG_MINDATE));
            instance2.set(11, 0);
            instance2.set(12, 0);
            instance2.set(13, 0);
            instance2.set(14, 0);
            datePicker.setMinDate(instance2.getTimeInMillis() - ((long) getOffset(instance2, timeZoneOffset)));
        }
        if (bundle != null && bundle.containsKey(RNConstants.ARG_MAXDATE)) {
            instance2.setTimeInMillis(bundle.getLong(RNConstants.ARG_MAXDATE));
            instance2.set(11, 23);
            instance2.set(12, 59);
            instance2.set(13, 59);
            instance2.set(14, 999);
            datePicker.setMaxDate(instance2.getTimeInMillis() - ((long) getOffset(instance2, timeZoneOffset)));
        }
        return dialog;
    }

    private static Integer getTimeZoneOffset(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(RNConstants.ARG_TZOFFSET_MINS)) {
            return null;
        }
        return Integer.valueOf(bundle.getInt(RNConstants.ARG_TZOFFSET_MINS, (int) bundle.getLong(RNConstants.ARG_TZOFFSET_MINS)) * 60000);
    }

    private static int getOffset(Calendar calendar, Integer num) {
        if (num != null) {
            return TimeZone.getDefault().getOffset(calendar.getTimeInMillis()) - num.intValue();
        }
        return 0;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnDateSetListener(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.mOnDateSetListener = onDateSetListener;
    }

    /* access modifiers changed from: package-private */
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    /* access modifiers changed from: package-private */
    public void setOnNeutralButtonActionListener(DialogInterface.OnClickListener onClickListener) {
        mOnNeutralButtonActionListener = onClickListener;
    }
}
