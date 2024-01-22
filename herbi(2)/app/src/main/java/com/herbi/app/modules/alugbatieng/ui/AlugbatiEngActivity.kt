package com.herbi.app.modules.alugbatieng.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.herbi.app.R
import com.herbi.app.appcomponents.base.BaseActivity
import com.herbi.app.databinding.ActivityAlugbatiEngBinding
import com.herbi.app.modules.alugbatieng.`data`.viewmodel.AlugbatiEngVM
import com.herbi.app.modules.alugbatifilactivity.ui.AlugbatiFilActivityActivity
import com.herbi.app.modules.homefeed.ui.HomeFeedActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class AlugbatiEngActivity : BaseActivity<ActivityAlugbatiEngBinding>(R.layout.activity_alugbati_eng)
    {
  private val viewModel: AlugbatiEngVM by viewModels<AlugbatiEngVM>()

  private val REQUEST_CODE_HOME_FEED_ACTIVITY: Int = 175


  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.alugbatiEngVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      val destIntent = HomeFeedActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_HOME_FEED_ACTIVITY)
    }
    binding.imageRectangleNinetyTwo.setOnClickListener {
      val destIntent = AlugbatiFilActivityActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "ALUGBATI_ENG_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AlugbatiEngActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
