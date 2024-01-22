package com.herbi.app.modules.alugbatieng.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.herbi.app.modules.alugbatieng.`data`.model.AlugbatiEngModel
import org.koin.core.KoinComponent

class AlugbatiEngVM : ViewModel(), KoinComponent {
  val alugbatiEngModel: MutableLiveData<AlugbatiEngModel> = MutableLiveData(AlugbatiEngModel())

  var navArguments: Bundle? = null
}
