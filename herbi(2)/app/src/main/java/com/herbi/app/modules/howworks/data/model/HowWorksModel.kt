package com.herbi.app.modules.howworks.`data`.model

import com.herbi.app.R
import com.herbi.app.appcomponents.di.MyApp
import kotlin.String

data class HowWorksModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtSkip: String? = MyApp.getInstance().resources.getString(R.string.lbl_skip)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHowHERBIWorks: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_how_herbi_works)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtITSJUSTSIMPL: String? =
      MyApp.getInstance().resources.getString(R.string.msg_it_s_just_simpl)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCAPTURE: String? = MyApp.getInstance().resources.getString(R.string.lbl_capture)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? =
      MyApp.getInstance().resources.getString(R.string.msg_capture_an_imag)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtANALYZING: String? = MyApp.getInstance().resources.getString(R.string.lbl_analyzing)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtWaitforafew: String? = MyApp.getInstance().resources.getString(R.string.msg_wait_for_a_few)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHereyougoTh: String? = MyApp.getInstance().resources.getString(R.string.msg_here_you_go_th)

)
