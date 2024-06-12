package com.sign.aurora.ui.ScreenHome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.sign.aurora.R
import com.sign.aurora.ui.Home.MainActivity

class ScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val screenActivity = installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen)

        screenActivity.setKeepOnScreenCondition{true}
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()



    }
}