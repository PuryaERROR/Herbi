package com.herbi.app.modules.alugbatieng.`data`.model

import com.herbi.app.R
import com.herbi.app.appcomponents.di.MyApp
import kotlin.String

data class AlugbatiEngModel(
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
  var txtAlugbati: String? = MyApp.getInstance().resources.getString(R.string.lbl_alugbati2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBasellaAlbaL: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_basella_alba_l)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroup567: String? = MyApp.getInstance().resources.getString(R.string.lbl_description)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescriptionOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_an_edible_peren)
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
      MyApp.getInstance().resources.getString(R.string.msg_the_roots_are_a)

)
