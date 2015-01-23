VNTNumberPickerPreference
=========================

[![Build Status](https://travis-ci.org/vanniktech/VNTNumberPickerPreference.svg)](https://travis-ci.org/vanniktech/VNTNumberPickerPreference)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-VNTNumberPickerPreference-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/799)

This is an easy to use custom preference, which opens a dialog with a number picker. The value gets automatically saved and you can set the default-, min- and maxValue conveniently in the XML.

```xml
<com.vanniktech.vntnumberpickerpreference.VNTNumberPickerPreference
    xmlns:vntnumberpickerpreference="http://schemas.android.com/apk/res-auto"
    android:defaultValue="@integer/font_size_default_value"
    android:key="preference_font_size"
    android:title="@string/font_size"
    vntnumberpickerpreference:maxValue="@integer/font_size_max_value"
    vntnumberpickerpreference:minValue="@integer/font_size_min_value"
	vntnumberpickerpreference:setWrapSelectorWheel="true"/>
```

# Setup

**settings.gradle**

```groovy
include ':vntnumberpickerpreference'
project(':vntnumberpickerpreference').projectDir = new File(settingsDir, '/path/VNTNumberPickerPreference/library')
```

**build.gradle**

```groovy
dependencies {
    compile project(':vntnumberpickerpreference')
}
```

Go to your preference XML file and insert the above mentioned XML tag. Afterwards you are good to go and can run your project!

# Get font size

```java
final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
final int fonftSize = sharedPreferences.getInt("preference_font_size", this.getResources().getInteger(R.integer.font_size_default_value));
```

# Preview

![Image of VNTNumberPickerPreference](app/src/main/res/drawable/preview.png)

# License

Copyright (c) 2014-2015 Niklas Baudy

Licensed under the Apache License, Version 2.0
