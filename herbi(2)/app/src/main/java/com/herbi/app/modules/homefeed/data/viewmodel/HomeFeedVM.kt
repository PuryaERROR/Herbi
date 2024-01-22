package com.herbi.app.modules.homefeed.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.herbi.app.modules.homefeed.`data`.model.HomeFeedModel
import org.koin.core.KoinComponent

class HomeFeedVM : ViewModel(), KoinComponent {
  val homeFeedModel: MutableLiveData<HomeFeedModel> = MutableLiveData(HomeFeedModel())

  var navArguments: Bundle? = null
}
