package com.herbi.app.modules.homefeed.`data`.model

import com.herbi.app.R
import com.herbi.app.appcomponents.di.MyApp
import kotlin.String

data class HomeFeedModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtExplorePhilipp: String? =
      MyApp.getInstance().resources.getString(R.string.msg_explore_the_phi)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAlugbati: String? = MyApp.getInstance().resources.getString(R.string.lbl_alugbati)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBAYABAS: String? = MyApp.getInstance().resources.getString(R.string.lbl_bayabas)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAMPALAYA: String? = MyApp.getInstance().resources.getString(R.string.lbl_ampalaya)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMALUNGGAY: String? = MyApp.getInstance().resources.getString(R.string.lbl_malunggay)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOREGANO: String? = MyApp.getInstance().resources.getString(R.string.lbl_oregano)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFeed: String? = MyApp.getInstance().resources.getString(R.string.lbl_feed)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSettings: String? = MyApp.getInstance().resources.getString(R.string.lbl_settings)

)
