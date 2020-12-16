package com.vaintti.reddithot.ui.main

import kotlinx.serialization.Serializable

@Serializable
data class RedditThread(val title: String, val selftext: String)