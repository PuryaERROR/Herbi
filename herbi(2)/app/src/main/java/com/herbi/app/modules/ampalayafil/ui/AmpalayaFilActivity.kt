package com.herbi.app.modules.ampalayafil.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.herbi.app.R
import com.herbi.app.appcomponents.base.BaseActivity
import com.herbi.app.databinding.ActivityAmpalayaFilBinding
import com.herbi.app.modules.ampalayaeng.ui.AmpalayaEngActivity
import com.herbi.app.modules.ampalayafil.`data`.viewmodel.AmpalayaFilVM
import kotlin.String
import kotlin.Unit

class AmpalayaFilActivity : BaseActivity<ActivityAmpalayaFilBinding>(R.layout.activity_ampalaya_fil)
    {
  private val viewModel: AmpalayaFilVM by viewModels<AmpalayaFilVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.ampalayaFilVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      // TODO please, add your navigation code here
      finish()
    }
    binding.imageRectangleNinetyOne.setOnClickListener {
      val destIntent = AmpalayaEngActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "AMPALAYA_FIL_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AmpalayaFilActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
