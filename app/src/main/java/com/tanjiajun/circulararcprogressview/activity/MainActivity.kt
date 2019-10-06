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
