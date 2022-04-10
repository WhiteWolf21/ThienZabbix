package com.facebook.react.modules.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

public class DatePickerDialogFragment extends DialogFragment {
    private static final long DEFAULT_MIN_DATE = -2208988800001L;
    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    private DialogInterface.OnDismissListener mOnDismissListener;

    public Dialog onCreateDialog(Bundle bundle) {
        return createDialog(getArguments(), getActivity(), this.mOnDateSetListener);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.app.Dialog createDialog(android.os.Bundle r10, android.content.Context r11, android.app.DatePickerDialog.OnDateSetListener r12) {
        /*
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            if (r10 == 0) goto L_0x0015
            java.lang.String r1 = "date"
            boolean r2 = r10.containsKey(r1)
            if (r2 == 0) goto L_0x0015
            long r1 = r10.getLong(r1)
            r0.setTimeInMillis(r1)
        L_0x0015:
            r1 = 1
            int r6 = r0.get(r1)
            r2 = 2
            int r7 = r0.get(r2)
            r3 = 5
            int r8 = r0.get(r3)
            com.facebook.react.modules.datepicker.DatePickerMode r3 = com.facebook.react.modules.datepicker.DatePickerMode.DEFAULT
            r4 = 0
            if (r10 == 0) goto L_0x003f
            java.lang.String r5 = "mode"
            java.lang.String r9 = r10.getString(r5, r4)
            if (r9 == 0) goto L_0x003f
            java.lang.String r3 = r10.getString(r5)
            java.util.Locale r5 = java.util.Locale.US
            java.lang.String r3 = r3.toUpperCase(r5)
            com.facebook.react.modules.datepicker.DatePickerMode r3 = com.facebook.react.modules.datepicker.DatePickerMode.valueOf(r3)
        L_0x003f:
            int[] r5 = com.facebook.react.modules.datepicker.DatePickerDialogFragment.C10611.$SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode
            int r3 = r3.ordinal()
            r3 = r5[r3]
            r9 = 0
            if (r3 == r1) goto L_0x0074
            if (r3 == r2) goto L_0x005c
            r1 = 3
            if (r3 == r1) goto L_0x0050
            goto L_0x008d
        L_0x0050:
            com.facebook.react.modules.datepicker.DismissableDatePickerDialog r1 = new com.facebook.react.modules.datepicker.DismissableDatePickerDialog
            r2 = r1
            r3 = r11
            r4 = r12
            r5 = r6
            r6 = r7
            r7 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x008c
        L_0x005c:
            com.facebook.react.modules.datepicker.DismissableDatePickerDialog r1 = new com.facebook.react.modules.datepicker.DismissableDatePickerDialog
            r4 = 16973939(0x1030073, float:2.4061222E-38)
            r2 = r1
            r3 = r11
            r5 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8)
            android.view.Window r11 = r1.getWindow()
            android.graphics.drawable.ColorDrawable r12 = new android.graphics.drawable.ColorDrawable
            r12.<init>(r9)
            r11.setBackgroundDrawable(r12)
            goto L_0x008c
        L_0x0074:
            com.facebook.react.modules.datepicker.DismissableDatePickerDialog r1 = new com.facebook.react.modules.datepicker.DismissableDatePickerDialog
            android.content.res.Resources r2 = r11.getResources()
            java.lang.String r3 = r11.getPackageName()
            java.lang.String r4 = "CalendarDatePickerDialog"
            java.lang.String r5 = "style"
            int r4 = r2.getIdentifier(r4, r5, r3)
            r2 = r1
            r3 = r11
            r5 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8)
        L_0x008c:
            r4 = r1
        L_0x008d:
            android.widget.DatePicker r11 = r4.getDatePicker()
            r12 = 14
            r1 = 13
            r2 = 12
            r3 = 11
            if (r10 == 0) goto L_0x00be
            java.lang.String r5 = "minDate"
            boolean r6 = r10.containsKey(r5)
            if (r6 == 0) goto L_0x00be
            long r5 = r10.getLong(r5)
            r0.setTimeInMillis(r5)
            r0.set(r3, r9)
            r0.set(r2, r9)
            r0.set(r1, r9)
            r0.set(r12, r9)
            long r5 = r0.getTimeInMillis()
            r11.setMinDate(r5)
            goto L_0x00c6
        L_0x00be:
            r5 = -2208988800001(0xfffffdfdae01dbff, double:NaN)
            r11.setMinDate(r5)
        L_0x00c6:
            if (r10 == 0) goto L_0x00f0
            java.lang.String r5 = "maxDate"
            boolean r6 = r10.containsKey(r5)
            if (r6 == 0) goto L_0x00f0
            long r5 = r10.getLong(r5)
            r0.setTimeInMillis(r5)
            r10 = 23
            r0.set(r3, r10)
            r10 = 59
            r0.set(r2, r10)
            r0.set(r1, r10)
            r10 = 999(0x3e7, float:1.4E-42)
            r0.set(r12, r10)
            long r0 = r0.getTimeInMillis()
            r11.setMaxDate(r0)
        L_0x00f0:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.datepicker.DatePickerDialogFragment.createDialog(android.os.Bundle, android.content.Context, android.app.DatePickerDialog$OnDateSetListener):android.app.Dialog");
    }

    /* renamed from: com.facebook.react.modules.datepicker.DatePickerDialogFragment$1 */
    static /* synthetic */ class C10611 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.react.modules.datepicker.DatePickerMode[] r0 = com.facebook.react.modules.datepicker.DatePickerMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode = r0
                com.facebook.react.modules.datepicker.DatePickerMode r1 = com.facebook.react.modules.datepicker.DatePickerMode.CALENDAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.modules.datepicker.DatePickerMode r1 = com.facebook.react.modules.datepicker.DatePickerMode.SPINNER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.modules.datepicker.DatePickerMode r1 = com.facebook.react.modules.datepicker.DatePickerMode.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.datepicker.DatePickerDialogFragment.C10611.<clinit>():void");
        }
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
}
