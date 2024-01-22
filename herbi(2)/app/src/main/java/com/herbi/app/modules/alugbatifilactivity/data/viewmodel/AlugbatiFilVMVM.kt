package com.herbi.app.modules.alugbatifilactivity.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.herbi.app.modules.alugbatifilactivity.`data`.model.AlugbatiFilModelModel
import org.koin.core.KoinComponent

class AlugbatiFilVMVM : ViewModel(), KoinComponent {
  val alugbatiFilModelModel: MutableLiveData<AlugbatiFilModelModel> =
      MutableLiveData(AlugbatiFilModelModel())

  var navArguments: Bundle? = null
}
