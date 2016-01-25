package com.vanniktech.vntnumberpickerpreference;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.TypedArray;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

public class VNTNumberPickerPreference extends DialogPreference {
    private static final int     MIN_VALUE           = 0;
    private static final int     MAX_VALUE           = 100;
    private static final boolean WRAP_SELECTOR_WHEEL = false;

    private int           mSelectedValue;
    private final int     mMinValue;
    private final int     mMaxValue;
    private final boolean mWrapSelectorWheel;
    private NumberPicker  mNumberPicker;

    public VNTNumberPickerPreference(final Context context, final AttributeSet attrs) {
        super(context, attrs);

        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.vnt_NumberPickerPreference);

        mMinValue = a.getInt(R.styleable.vnt_NumberPickerPreference_vnt_minValue, VNTNumberPickerPreference.MIN_VALUE);
        mMaxValue = a.getInt(R.styleable.vnt_NumberPickerPreference_vnt_maxValue, VNTNumberPickerPreference.MAX_VALUE);
        mWrapSelectorWheel = a.getBoolean(R.styleable.vnt_NumberPickerPreference_vnt_setWrapSelectorWheel, VNTNumberPickerPreference.WRAP_SELECTOR_WHEEL);

        a.recycle();
    }

    @Override
    protected void onSetInitialValue(final boolean restoreValue, final Object defaultValue) {
        final int intDefaultValue = defaultValue instanceof Integer ? (int) defaultValue : mMinValue;
        mSelectedValue = restoreValue ? this.getPersistedInt(intDefaultValue) : intDefaultValue;
        this.updateSummary();
    }

    @Override
    protected Object onGetDefaultValue(final TypedArray a, final int index) {
        return a.getInteger(index, 0);
    }

    @Override
    protected void onPrepareDialogBuilder(final Builder builder) {
        super.onPrepareDialogBuilder(builder);

        mNumberPicker = new NumberPicker(this.getContext());
        mNumberPicker.setMinValue(mMinValue);
        mNumberPicker.setMaxValue(mMaxValue);
        mNumberPicker.setValue(mSelectedValue);
        mNumberPicker.setWrapSelectorWheel(mWrapSelectorWheel);
        mNumberPicker.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        final LinearLayout linearLayout = new LinearLayout(this.getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.addView(mNumberPicker);

        builder.setView(linearLayout);
    }

    @Override
    protected void onDialogClosed(final boolean positiveResult) {
        super.onDialogClosed(positiveResult);

        if (positiveResult && mNumberPicker != null) {
            final int selectedValue = mNumberPicker.getValue();

            if (this.callChangeListener(selectedValue)) {
                mSelectedValue = selectedValue;

                this.updateSummary();
                this.persistInt(mSelectedValue);
            }
        }
    }

    private void updateSummary() {
        this.setSummary(String.valueOf(mSelectedValue));
    }
}
