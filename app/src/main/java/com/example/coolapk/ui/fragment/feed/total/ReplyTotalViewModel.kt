package com.example.coolapk.ui.fragment.feed.total

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.coolapk.logic.model.HomeFeedResponse
import com.example.coolapk.logic.network.Repository

class ReplyTotalViewModel : ViewModel() {

    var isEnd = false
    var isLoadMore = false

    var page = 1
    var id = ""

    val replyTotalList = ArrayList<HomeFeedResponse.Data>()

    private val getReplyTotalLiveData = MutableLiveData<String>()

    val replyTotalLiveData = getReplyTotalLiveData.switchMap {
        Repository.getReply2Reply(id, page)
    }

    fun getReplyTotal() {
        getReplyTotalLiveData.value = getReplyTotalLiveData.value
    }

}