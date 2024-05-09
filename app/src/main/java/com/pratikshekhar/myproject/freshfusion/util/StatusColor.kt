package com.pratikshekhar.myproject.freshfusion.util

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowInsetsControllerCompat




@Composable
fun SetStatusBarColor( color: Int){
    val view = LocalView.current
    val window = (view.context as Activity).window
    window.statusBarColor = color
}
@Composable
fun SetStatusBarColor( color: Color){
    val view = LocalView.current
    val window = (view.context as Activity).window
    window.statusBarColor =color.toArgb()
}
@Composable
fun SetThemeBar(value:Boolean){
    val view = LocalView.current
    val window = (view.context as Activity).window
    val decorView = window.decorView
    val wic = WindowInsetsControllerCompat(window, decorView)
    wic.isAppearanceLightStatusBars = value
}
