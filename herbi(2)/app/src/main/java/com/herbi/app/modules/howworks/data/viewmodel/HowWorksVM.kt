package com.herbi.app.modules.howworks.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.herbi.app.modules.howworks.`data`.model.HowWorksModel
import org.koin.core.KoinComponent

class HowWorksVM : ViewModel(), KoinComponent {
  val howWorksModel: MutableLiveData<HowWorksModel> = MutableLiveData(HowWorksModel())

  var navArguments: Bundle? = null
}
