package com.herbi.app.modules.bayabastagalogactivity.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.herbi.app.modules.bayabastagalogactivity.`data`.model.BayabasTagalogModelModel
import org.koin.core.KoinComponent

class BayabasTagalogVMVM : ViewModel(), KoinComponent {
  val bayabasTagalogModelModel: MutableLiveData<BayabasTagalogModelModel> =
      MutableLiveData(BayabasTagalogModelModel())

  var navArguments: Bundle? = null
}
