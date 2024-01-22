package com.herbi.app.modules.oreganotagalog.`data`.model

import com.herbi.app.R
import com.herbi.app.appcomponents.di.MyApp
import kotlin.String

data class OreganoTagalogModel(
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
  var txtOriganumAmboin: String? =
      MyApp.getInstance().resources.getString(R.string.msg_origanum_amboin)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOregano: String? = MyApp.getInstance().resources.getString(R.string.lbl_oregano2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroup596: String? = MyApp.getInstance().resources.getString(R.string.lbl_deskripsyon)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? = MyApp.getInstance().resources.getString(R.string.msg_ang_oregano_ay)
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
      MyApp.getInstance().resources.getString(R.string.msg_ang_oregano_ay2)

)
