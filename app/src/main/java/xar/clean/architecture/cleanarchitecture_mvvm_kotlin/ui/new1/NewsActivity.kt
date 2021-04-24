package xar.clean.architecture.cleanarchitecture_mvvm_kotlin.ui.new1

import android.os.Bundle
import androidx.activity.viewModels
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.R
import xar.mvvm.xarlib.XarActivity
import xar.clean.architecture.cleanarchitecture_mvvm_kotlin.databinding.NewsActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import xar.mvvm.xarlib.extensions.listen


@AndroidEntryPoint
class NewsActivity : XarActivity<NewsActivityBinding, NewsViewModel>(R.layout.news_activity) {
    override val mViewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.mViewModel = this.mViewModel


        mViewModel.newsCommands.listen(this) {
            when (it) {

            }
        }
    }
}
