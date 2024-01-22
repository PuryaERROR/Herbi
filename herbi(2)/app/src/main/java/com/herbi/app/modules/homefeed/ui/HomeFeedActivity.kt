package com.herbi.app.modules.homefeed.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.herbi.app.R
import com.herbi.app.appcomponents.base.BaseActivity
import com.herbi.app.appcomponents.views.ImagePickerFragmentDialog
import com.herbi.app.databinding.ActivityHomeFeedBinding
import com.herbi.app.modules.alugbatieng.ui.AlugbatiEngActivity
import com.herbi.app.modules.ampalayaeng.ui.AmpalayaEngActivity
import com.herbi.app.modules.bayabasenglishactivity.ui.BayabasEnglishActivityActivity
import com.herbi.app.modules.homefeed.data.viewmodel.HomeFeedVM
import com.herbi.app.modules.malunggayenglishactivity.ui.MalunggayEnglishActivityActivity
import com.herbi.app.modules.oreganoenglish.ui.OreganoEnglishActivity
import com.herbi.app.modules.result.ui.ResultActivity

class HomeFeedActivity : BaseActivity<ActivityHomeFeedBinding>(R.layout.activity_home_feed) {
  private val viewModel: HomeFeedVM by viewModels<HomeFeedVM>()

  private val REQUEST_CODE_MALUNGGAY_ENGLISH_ACTIVITY_ACTIVITY = 829
  private val REQUEST_CODE_OREGANO_ENGLISH_ACTIVITY = 176
  private val REQUEST_CODE_BAYABAS_ENGLISH_ACTIVITY_ACTIVITY = 113
  private val REQUEST_CODE_AMPALAYA_ENG_ACTIVITY = 251
  private val REQUEST_CODE_RESULT_ACTIVITY = 129

  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.homeFeedVM = viewModel
  }

  override fun setUpClicks() {
    binding.linearColumnmalunggay.setOnClickListener {
      val destIntent = MalunggayEnglishActivityActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_MALUNGGAY_ENGLISH_ACTIVITY_ACTIVITY)
    }
    binding.linearColumnoregano.setOnClickListener {
      val destIntent = OreganoEnglishActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_OREGANO_ENGLISH_ACTIVITY)
    }
    binding.imageBAYABASOne.setOnClickListener {
      val destIntent = BayabasEnglishActivityActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_BAYABAS_ENGLISH_ACTIVITY_ACTIVITY)
    }
    binding.frameAlugbati.setOnClickListener {
      val destIntent = AlugbatiEngActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageCameraicon.setOnClickListener {
      ImagePickerFragmentDialog().show(
        supportFragmentManager,
        "ImagePickerFragmentDialogTag"
      )
    }
    binding.frameCamera.setOnClickListener {
      ImagePickerFragmentDialog().show(
        supportFragmentManager,
        "ImagePickerFragmentDialogTag"
      )
    }
    binding.linearColumnampalaya.setOnClickListener {
      val destIntent = AmpalayaEngActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_AMPALAYA_ENG_ACTIVITY)
    }
    binding.txtSettings.setOnClickListener {
      val destIntent = ResultActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_RESULT_ACTIVITY)
    }
  }

  companion object {
    const val TAG: String = "HOME_FEED_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HomeFeedActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
