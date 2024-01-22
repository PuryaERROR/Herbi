package com.herbi.app.modules.malunggayenglishactivity.`data`.model

import com.herbi.app.R
import com.herbi.app.appcomponents.di.MyApp
import kotlin.String

data class MalunggayEnglishModelModel(
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
  var txtMoringaoleifer: String? =
      MyApp.getInstance().resources.getString(R.string.msg_moringa_oleifer)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHorseradish: String? = MyApp.getInstance().resources.getString(R.string.lbl_horseradish)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroup559: String? = MyApp.getInstance().resources.getString(R.string.lbl_description)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescriptionOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_leaves_are_alte)
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
      MyApp.getInstance().resources.getString(R.string.msg_decoction_of_le)

)
