package com.herbi.app.modules.bayabastagalogactivity.`data`.model

import com.herbi.app.R
import com.herbi.app.appcomponents.di.MyApp
import kotlin.String

data class BayabasTagalogModelModel(
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
  var txtPsidiumGuajava: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_psidium_guajava)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBayabas: String? = MyApp.getInstance().resources.getString(R.string.lbl_bayabas2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroup586: String? = MyApp.getInstance().resources.getString(R.string.lbl_deskripsyon)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? =
      MyApp.getInstance().resources.getString(R.string.msg_ang_mga_dahon_n)
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
      MyApp.getInstance().resources.getString(R.string.msg_ang_mga_dahon_n2)

)
