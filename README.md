VNTNumberPickerPreference
=========================

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
SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
int fonftSize = sharedPreferences.getInt("preference_font_size", getResources().getInteger(R.integer.font_size_default_value));
```

# Proguard

No configuration needed.

# Preview

<img src="app/src/main/res/drawable-nodpi/preview.png" alt="Image of VNTNumberPickerPreference" width="320">

# License

Copyright (C) 2014-2016 Vanniktech - Niklas Baudy

Licensed under the Apache License, Version 2.0
