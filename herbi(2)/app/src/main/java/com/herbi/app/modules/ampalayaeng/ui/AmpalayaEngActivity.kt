package com.herbi.app.modules.ampalayaeng.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.herbi.app.R
import com.herbi.app.appcomponents.base.BaseActivity
import com.herbi.app.databinding.ActivityAmpalayaEngBinding
import com.herbi.app.modules.ampalayaeng.`data`.viewmodel.AmpalayaEngVM
import com.herbi.app.modules.ampalayafil.ui.AmpalayaFilActivity
import com.herbi.app.modules.homefeed.ui.HomeFeedActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class AmpalayaEngActivity : BaseActivity<ActivityAmpalayaEngBinding>(R.layout.activity_ampalaya_eng)
    {
  private val viewModel: AmpalayaEngVM by viewModels<AmpalayaEngVM>()

  private val REQUEST_CODE_HOME_FEED_ACTIVITY: Int = 676


  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.ampalayaEngVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageRectangleNinetyOne.setOnClickListener {
      val destIntent = AmpalayaFilActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      val destIntent = HomeFeedActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_HOME_FEED_ACTIVITY)
    }
  }

  companion object {
    const val TAG: String = "AMPALAYA_ENG_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AmpalayaEngActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
