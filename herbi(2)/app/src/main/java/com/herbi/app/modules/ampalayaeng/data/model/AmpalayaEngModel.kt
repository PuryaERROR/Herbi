package com.herbi.app.modules.ampalayaeng.`data`.model

import com.herbi.app.R
import com.herbi.app.appcomponents.di.MyApp
import kotlin.String

data class AmpalayaEngModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtUnlockingtheH: String? =
      MyApp.getInstance().resources.getString(R.string.msg_unlocking_the_h)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_herb_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_scientific_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBitterGuord: String? = MyApp.getInstance().resources.getString(R.string.lbl_bitter_guord)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMommordicaChar: String? =
      MyApp.getInstance().resources.getString(R.string.msg_mommordica_char)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroup600: String? = MyApp.getInstance().resources.getString(R.string.lbl_description)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescriptionOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_ampalaya_also)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_medicinal_uses)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescriptionTwo: String? =
      MyApp.getInstance().resources.getString(R.string.msg_bitter_gourd_o)

)
