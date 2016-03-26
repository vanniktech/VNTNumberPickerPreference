VNTNumberPickerPreference
=========================

[![Build Status](https://travis-ci.org/vanniktech/VNTNumberPickerPreference.svg?branch=master)](https://travis-ci.org/vanniktech/VNTNumberPickerPreference?branch=master)
[![Codecov](https://codecov.io/github/vanniktech/VNTNumberPickerPreference/coverage.svg?branch=master)](https://codecov.io/github/vanniktech/VNTNumberPickerPreference?branch=master)
[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)
<a href="http://www.methodscount.com/?lib=com.vanniktech%3Avntnumberpickerpreference%3A1.0.0"><img src="https://img.shields.io/badge/Methods count-37-e91e63.svg"></img></a>
<a href="http://www.methodscount.com/?lib=com.vanniktech%3Avntnumberpickerpreference%3A1.0.0"><img src="https://img.shields.io/badge/Size-5 KB-e91e63.svg"></img></a>
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-VNTNumberPickerPreference-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/799)
[![Jit Pack](https://img.shields.io/github/tag/vanniktech/VNTNumberPickerPreference.svg?label=JitPack%20Maven)](https://jitpack.io/#vanniktech/VNTNumberPickerPreference)
[![](https://img.shields.io/badge/AndroidWeekly-%23111-blue.svg)](http://androidweekly.net/issues/issue-111)

This is an easy to use custom preference, which opens a dialog with a number picker. The value gets automatically saved and you can set the default-, min- and maxValue conveniently in the XML.

```xml
<com.vanniktech.vntnumberpickerpreference.VNTNumberPickerPreference
    android:defaultValue="@integer/font_size_default_value"
    android:key="preference_font_size"
    android:title="@string/font_size"
    app:vnt_maxValue="@integer/font_size_max_value"
    app:vnt_minValue="@integer/font_size_min_value"
    app:vnt_setWrapSelectorWheel="true"/>
```

# Download Sample App

[![Get it on Google Play](https://developer.android.com/images/brand/en_generic_rgb_wo_45.png)](https://play.google.com/store/apps/details?id=com.vanniktech.vntnumberpickerpreference.sample)

or scan the code on your mobile

![Google Play QR link](http://api.qrserver.com/v1/create-qr-code/?color=000000&bgcolor=FFFFFF&data=https%3A%2F%2Fplay.google.com%2Fstore%2Fapps%2Fdetails%3Fid%3Dcom.vanniktech.vntnumberpickerpreference.sample&qzone=1&margin=0&size=150x150&ecc=L)

or download it [directly](sample.apk)

# Setup

**build.gradle**

```groovy
compile 'com.vanniktech:vntnumberpickerpreference:1.0.0'
compile 'com.vanniktech:vntnumberpickerpreference:1.0.1-SNAPSHOT'
```

Modules are located on [Maven Central](https://oss.sonatype.org/#nexus-search;quick~vntnumberpickerpreference).

Go to your preference XML file and insert the above mentioned XML tag. Afterwards you are good to go and can run your project!

# Get font size

```java
final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
final int fonftSize = sharedPreferences.getInt("preference_font_size", this.getResources().getInteger(R.integer.font_size_default_value));
```

# Proguard

No configuration needed.

# Preview

<img src="app/src/main/res/drawable-nodpi/preview.png" alt="Image of VNTNumberPickerPreference" width="320">

# License

Copyright (C) 2014-2016 Vanniktech - Niklas Baudy

Licensed under the Apache License, Version 2.0
