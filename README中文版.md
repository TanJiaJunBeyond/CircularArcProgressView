# CircularArcProgressView

**带弧形的进度条**

[英文本README](https://github.com/TanJiaJunBeyond/CircularArcProgressView/blob/master/README.md)

## 效果图

![CircularArcProgressViewDemo.gif](https://github.com/TanJiaJunBeyond/CircularArcProgressView/blob/master/CircularArcProgressViewDemo.gif)

## 属性

|name|format|description|
|:---:|:---:|:---:|
| capv_background_color | color | 背景颜色
| capv_progress_color | color | 进度条颜色
| capv_progress_text_color | color | 进度文本颜色
| capv_percent | float | 百分比
| capv_is_show_progress_text | boolean | 是否显示进度文本

## 使用

**导入你的项目中**

```groovy
dependencies {
    implementation 'com.tanjiajun.widget:CircularArcProgressView:1.0.1'
}
```

**布局文件**

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <com.tanjiajun.widget.CircularArcProgressView
        android:id="@+id/capv_first"
        android:layout_width="0dp"
        android:layout_height="30dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        app:capv_background_color="@color/circular_arc_progress_view_first_background_color"
        app:capv_is_show_progress_text="true"
        app:capv_percent="0.8"
        app:capv_progress_color="@color/circular_arc_progress_view_first_progress_color"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <com.tanjiajun.widget.CircularArcProgressView
        android:id="@+id/capv_second"
        android:layout_width="0dp"
        android:layout_height="30dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        app:capv_background_color="@color/circular_arc_progress_view_second_background_color"
        app:capv_is_show_progress_text="true"
        app:capv_percent="0.5"
        app:capv_progress_color="@color/circular_arc_progress_view_second_progress_color"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/capv_first" />

    <com.tanjiajun.widget.CircularArcProgressView
        android:id="@+id/capv_third"
        android:layout_width="0dp"
        android:layout_height="30dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        app:capv_background_color="@color/circular_arc_progress_view_third_background_color"
        app:capv_is_show_progress_text="true"
        app:capv_progress_color="@color/circular_arc_progress_view_third_progress_color"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/capv_second" />

    <com.tanjiajun.widget.CircularArcProgressView
        android:id="@+id/capv_fourth"
        android:layout_width="0dp"
        android:layout_height="30dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        app:capv_background_color="@color/circular_arc_progress_view_fourth_background_color"
        app:capv_is_show_progress_text="true"
        app:capv_progress_color="@color/circular_arc_progress_view_fourth_progress_color"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/capv_third" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

**Kotlin**

```kotlin
package com.tanjiajun.circulararcprogressview.activity

import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.BounceInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.tanjiajun.circulararcprogressview.R
import com.tanjiajun.widget.CircularArcProgressView

/**
 * Created by TanJiaJun on 2019-10-05.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<CircularArcProgressView>(R.id.capv_first).startAnimator(duration = 2000)
        findViewById<CircularArcProgressView>(R.id.capv_second).startAnimator(
            timeInterpolator = AccelerateDecelerateInterpolator(),
            duration = 3000
        )
        with(findViewById<CircularArcProgressView>(R.id.capv_third)) {
            percent = 0.3f
            startAnimator(timeInterpolator = BounceInterpolator(), duration = 2000)
        }
        with(findViewById<CircularArcProgressView>(R.id.capv_fourth)) {
            percent = 0.05f
            startAnimator(duration = 2000)
        }
    }

}
```

**Java**

```java
package com.tanjiajun.circulararcprogressview.activity;

import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tanjiajun.circulararcprogressview.R;
import com.tanjiajun.widget.CircularArcProgressView;

/**
 * Created by TanJiaJun on 2019-10-07.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((CircularArcProgressView) findViewById(R.id.capv_first)).startAnimator(2000);
        ((CircularArcProgressView) findViewById(R.id.capv_second)).startAnimator(
                new AccelerateDecelerateInterpolator(),
                3000
        );

        CircularArcProgressView capvThird = findViewById(R.id.capv_third);
        capvThird.setPercent(0.3f);
        capvThird.startAnimator(new BounceInterpolator(), 2000);

        CircularArcProgressView capvFourth = findViewById(R.id.capv_fourth);
        capvFourth.setPercent(0.05f);
        capvFourth.startAnimator(2000);
    }
    
}
```

#License

```
Copyright 2019 TanJiaJun, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```