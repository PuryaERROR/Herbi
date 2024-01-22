package com.herbi.app.modules.result.data.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.herbi.app.modules.result.data.model.ResultModel
import com.herbi.app.plantInfos.PlantInfoDictionary
import org.koin.core.KoinComponent

class ResultVM : ViewModel(), KoinComponent {
  val resultModel: MutableLiveData<ResultModel> = MutableLiveData(ResultModel())
  var navArguments: Bundle? = null

  fun loadPlantInfoFromDictionary() {
    val predictedClass = navArguments?.getString("predictedClass")
    updateResultModel(predictedClass)
  }

  private fun updateResultModel(predictedClass: String?) {
    val plantInfo = PlantInfoDictionary.plantInfoMap[predictedClass]
    val herbName = plantInfo?.herbName
    val scientificName = plantInfo?.scientificName
    val description = plantInfo?.description
    val medicinalUses = plantInfo?.medicinalUses

    val updatedModel = ResultModel(
      herbName = herbName,
      scientificName = scientificName,
      description = description,
      medicinalUses = medicinalUses
      // Add other properties as needed
    )
    resultModel.value = updatedModel
  }
}
