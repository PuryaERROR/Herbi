package com.herbi.app.modules.ampalayafil.`data`.model

import com.herbi.app.R
import com.herbi.app.appcomponents.di.MyApp
import kotlin.String

data class AmpalayaFilModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtUnlockingtheH: String? =
      MyApp.getInstance().resources.getString(R.string.msg_unlocking_the_h)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPangalanngHal: String? =
      MyApp.getInstance().resources.getString(R.string.msg_pangalan_ng_hal)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_aghan_na_pangal)
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
  var txtAmpalaya: String? = MyApp.getInstance().resources.getString(R.string.lbl_ampalaya2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroup607: String? = MyApp.getInstance().resources.getString(R.string.lbl_deskripsyon)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? = MyApp.getInstance().resources.getString(R.string.msg_ang_ampalaya_o)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_paggamit_sa_pag)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescriptionOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_ang_ampalaya_ay)

)
