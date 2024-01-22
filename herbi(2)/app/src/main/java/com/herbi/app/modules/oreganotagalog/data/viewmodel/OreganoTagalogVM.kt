package com.herbi.app.modules.oreganotagalog.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.herbi.app.modules.oreganotagalog.`data`.model.OreganoTagalogModel
import org.koin.core.KoinComponent

class OreganoTagalogVM : ViewModel(), KoinComponent {
  val oreganoTagalogModel: MutableLiveData<OreganoTagalogModel> =
      MutableLiveData(OreganoTagalogModel())

  var navArguments: Bundle? = null
}
