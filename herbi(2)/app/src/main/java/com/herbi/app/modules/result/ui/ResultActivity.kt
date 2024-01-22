package com.herbi.app.modules.result.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.herbi.app.R
import com.herbi.app.appcomponents.base.BaseActivity
import com.herbi.app.databinding.ActivityResultBinding
import com.herbi.app.modules.result.data.viewmodel.ResultVM

class ResultActivity : BaseActivity<ActivityResultBinding>(R.layout.activity_result) {
  private val viewModel: ResultVM by viewModels<ResultVM>()

  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.resultVM = viewModel
  }

  override fun setUpClicks() {
    binding.imageArrowleft.setOnClickListener {
      // TODO please, add your navigation code here
      finish()
    }
  }

  companion object {
    const val TAG: String = "RESULT_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ResultActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
