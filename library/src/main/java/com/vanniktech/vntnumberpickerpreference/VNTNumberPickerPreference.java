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

    private int                  selectedValue;
    private final int            minValue;
    private final int            maxValue;
    private final boolean        wrapSelectorWheel;
    private NumberPicker         numberPicker;

    public VNTNumberPickerPreference(final Context context, final AttributeSet attrs) {
        super(context, attrs);

        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.vnt_NumberPickerPreference);

        minValue = a.getInt(R.styleable.vnt_NumberPickerPreference_vnt_minValue, MIN_VALUE);
        maxValue = a.getInt(R.styleable.vnt_NumberPickerPreference_vnt_maxValue, MAX_VALUE);
        wrapSelectorWheel = a.getBoolean(R.styleable.vnt_NumberPickerPreference_vnt_setWrapSelectorWheel, WRAP_SELECTOR_WHEEL);

        a.recycle();
    }

    @Override
    protected void onSetInitialValue(final boolean restoreValue, final Object defaultValue) {
        final int intDefaultValue = defaultValue instanceof Integer ? (int) defaultValue : minValue;
        selectedValue = restoreValue ? this.getPersistedInt(intDefaultValue) : intDefaultValue;
        this.updateSummary();
    }

    @Override
    protected Object onGetDefaultValue(final TypedArray a, final int index) {
        return a.getInteger(index, 0);
    }

    @Override
    protected void onPrepareDialogBuilder(final Builder builder) {
        super.onPrepareDialogBuilder(builder);

        numberPicker = new NumberPicker(this.getContext());
        numberPicker.setMinValue(minValue);
        numberPicker.setMaxValue(maxValue);
        numberPicker.setValue(selectedValue);
        numberPicker.setWrapSelectorWheel(wrapSelectorWheel);
        numberPicker.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        final LinearLayout linearLayout = new LinearLayout(this.getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.addView(numberPicker);

        builder.setView(linearLayout);
    }

    @Override
    protected void onDialogClosed(final boolean positiveResult) {
        super.onDialogClosed(positiveResult);

        if (positiveResult && numberPicker != null) {
            final int newValue = numberPicker.getValue();

            if (this.callChangeListener(newValue)) {
                this.selectedValue = newValue;

                this.updateSummary();
                this.persistInt(this.selectedValue);
            }
        }
    }

    private void updateSummary() {
        this.setSummary(String.valueOf(selectedValue));
    }
}
