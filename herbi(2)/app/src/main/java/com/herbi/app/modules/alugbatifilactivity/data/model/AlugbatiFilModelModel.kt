package com.herbi.app.modules.alugbatifilactivity.`data`.model

import com.herbi.app.R
import com.herbi.app.appcomponents.di.MyApp
import kotlin.String

data class AlugbatiFilModelModel(
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
  var txtBasellaAlbaL: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_basella_alba_l)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAlugbati: String? = MyApp.getInstance().resources.getString(R.string.lbl_alugbati2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroup543: String? = MyApp.getInstance().resources.getString(R.string.lbl_deskripsyon)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? = MyApp.getInstance().resources.getString(R.string.msg_isang_perennia)
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
      MyApp.getInstance().resources.getString(R.string.msg_ang_mga_ugat_ay)

)
