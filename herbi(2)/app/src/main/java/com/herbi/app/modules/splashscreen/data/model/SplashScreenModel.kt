package com.herbi.app.modules.splashscreen.`data`.model

import com.herbi.app.R
import com.herbi.app.appcomponents.di.MyApp
import kotlin.String

data class SplashScreenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtUnlockingtheH: String? =
      MyApp.getInstance().resources.getString(R.string.msg_unlocking_the_h)

)
