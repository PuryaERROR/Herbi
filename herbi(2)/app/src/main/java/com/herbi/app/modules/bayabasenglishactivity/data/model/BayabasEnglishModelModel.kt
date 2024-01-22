package com.herbi.app.modules.bayabasenglishactivity.`data`.model

import com.herbi.app.R
import com.herbi.app.appcomponents.di.MyApp
import kotlin.String

data class BayabasEnglishModelModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtUnlockingtheH: String? =
      MyApp.getInstance().resources.getString(R.string.msg_unlocking_the_h)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFilipino: String? = MyApp.getInstance().resources.getString(R.string.lbl_filipino)
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
  var txtGuava: String? = MyApp.getInstance().resources.getString(R.string.lbl_guava)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPsidiumGuajava: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_psidium_guajava)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroup546: String? = MyApp.getInstance().resources.getString(R.string.lbl_description)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescriptionOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_guava_leaves_ar)
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
      MyApp.getInstance().resources.getString(R.string.msg_guava_leaves_ha)

)
