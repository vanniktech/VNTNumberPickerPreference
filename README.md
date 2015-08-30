VNTNumberPickerPreference
=========================

[![Build Status](https://travis-ci.org/vanniktech/VNTNumberPickerPreference.svg)](https://travis-ci.org/vanniktech/VNTNumberPickerPreference)
[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-VNTNumberPickerPreference-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/799)
[![Jit Pack](https://img.shields.io/github/tag/vanniktech/VNTNumberPickerPreference.svg?label=JitPack%20Maven)](https://jitpack.io/#vanniktech/VNTNumberPickerPreference)
[![](https://img.shields.io/badge/AndroidWeekly-%23111-blue.svg)](http://androidweekly.net/issues/issue-111)

This is an easy to use custom preference, which opens a dialog with a number picker. The value gets automatically saved and you can set the default-, min- and maxValue conveniently in the XML.

```xml
<com.vanniktech.vntnumberpickerpreference.VNTNumberPickerPreference
    xmlns:vntnumberpickerpreference="http://schemas.android.com/apk/res-auto"
    android:defaultValue="@integer/font_size_default_value"
    android:key="preference_font_size"
    android:title="@string/font_size"
    vntnumberpickerpreference:vnt_maxValue="@integer/font_size_max_value"
    vntnumberpickerpreference:vnt_minValue="@integer/font_size_min_value"
    vntnumberpickerpreference:vnt_setWrapSelectorWheel="true"/>
```

# Download

[![Get it on Google Play](https://developer.android.com/images/brand/en_generic_rgb_wo_45.png)](https://play.google.com/store/apps/details?id=com.vanniktech.vntnumberpickerpreference.sample)

or scan the code on your mobile

![Google Play QR link](http://api.qrserver.com/v1/create-qr-code/?color=000000&bgcolor=FFFFFF&data=https%3A%2F%2Fplay.google.com%2Fstore%2Fapps%2Fdetails%3Fid%3Dcom.vanniktech.vntnumberpickerpreference.sample&qzone=1&margin=0&size=150x150&ecc=L)

or download it [directly](sample.apk)

# Setup

**build.gradle**

```groovy
repositories {
    maven { url "https://oss.sonatype.org/content/repositories/snapshots/" }
}

dependencies {
    compile 'com.vanniktech:vntnumberpickerpreference:0.1.5-SNAPSHOT'
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

Copyright (C) 2014-2015 Vanniktech - Niklas Baudy

Licensed under the Apache License, Version 2.0