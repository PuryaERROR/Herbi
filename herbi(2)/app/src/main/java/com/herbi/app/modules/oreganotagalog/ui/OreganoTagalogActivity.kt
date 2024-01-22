package com.herbi.app.modules.oreganotagalog.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.herbi.app.R
import com.herbi.app.appcomponents.base.BaseActivity
import com.herbi.app.databinding.ActivityOreganoTagalogBinding
import com.herbi.app.modules.homefeed.ui.HomeFeedActivity
import com.herbi.app.modules.oreganoenglish.ui.OreganoEnglishActivity
import com.herbi.app.modules.oreganotagalog.`data`.viewmodel.OreganoTagalogVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class OreganoTagalogActivity :
    BaseActivity<ActivityOreganoTagalogBinding>(R.layout.activity_oregano_tagalog) {
  private val viewModel: OreganoTagalogVM by viewModels<OreganoTagalogVM>()

  private val REQUEST_CODE_HOME_FEED_ACTIVITY: Int = 245

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.oreganoTagalogVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageRectangleNinetyOne.setOnClickListener {
      val destIntent = OreganoEnglishActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      val destIntent = HomeFeedActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_HOME_FEED_ACTIVITY)
    }
  }

  companion object {
    const val TAG: String = "OREGANO_TAGALOG_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, OreganoTagalogActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
