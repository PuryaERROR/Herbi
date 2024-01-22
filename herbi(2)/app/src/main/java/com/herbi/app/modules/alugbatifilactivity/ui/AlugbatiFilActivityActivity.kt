package com.herbi.app.modules.alugbatifilactivity.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.herbi.app.R
import com.herbi.app.appcomponents.base.BaseActivity
import com.herbi.app.databinding.ActivityAlugbatiFilActivityBinding
import com.herbi.app.modules.alugbatieng.ui.AlugbatiEngActivity
import com.herbi.app.modules.alugbatifilactivity.`data`.viewmodel.AlugbatiFilVMVM
import kotlin.String
import kotlin.Unit

class AlugbatiFilActivityActivity :
    BaseActivity<ActivityAlugbatiFilActivityBinding>(R.layout.activity_alugbati_fil_activity) {
  private val viewModel: AlugbatiFilVMVM by viewModels<AlugbatiFilVMVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.alugbatiFilVMVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      // TODO please, add your navigation code here
      finish()
    }
    binding.imageRectangleNinetyOne.setOnClickListener {
      val destIntent = AlugbatiEngActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "ALUGBATI_FIL_ACTIVITY_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AlugbatiFilActivityActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
