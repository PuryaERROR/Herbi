package com.herbi.app.modules.ampalayaeng.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.herbi.app.modules.ampalayaeng.`data`.model.AmpalayaEngModel
import org.koin.core.KoinComponent

class AmpalayaEngVM : ViewModel(), KoinComponent {
  val ampalayaEngModel: MutableLiveData<AmpalayaEngModel> = MutableLiveData(AmpalayaEngModel())

  var navArguments: Bundle? = null
}
