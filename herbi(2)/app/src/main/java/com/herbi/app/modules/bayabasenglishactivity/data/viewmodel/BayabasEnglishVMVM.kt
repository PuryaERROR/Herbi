package com.herbi.app.modules.bayabasenglishactivity.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.herbi.app.modules.bayabasenglishactivity.`data`.model.BayabasEnglishModelModel
import org.koin.core.KoinComponent

class BayabasEnglishVMVM : ViewModel(), KoinComponent {
  val bayabasEnglishModelModel: MutableLiveData<BayabasEnglishModelModel> =
      MutableLiveData(BayabasEnglishModelModel())

  var navArguments: Bundle? = null
}
