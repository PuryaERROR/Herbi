package com.herbi.app.modules.oreganoenglish.`data`.model

import com.herbi.app.R
import com.herbi.app.appcomponents.di.MyApp
import kotlin.String

data class OreganoEnglishModel(
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
  var txtBushyPerennial: String? =
      MyApp.getInstance().resources.getString(R.string.msg_bushy_perennial)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOriganumAmboin: String? =
      MyApp.getInstance().resources.getString(R.string.msg_origanum_amboin)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroup589: String? = MyApp.getInstance().resources.getString(R.string.lbl_description)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescriptionOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_oregano_typical)
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
      MyApp.getInstance().resources.getString(R.string.msg_oregano_contain)

)
