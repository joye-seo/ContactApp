package com.example.contactapp

import java.io.Serializable

object Contact {
    val userList = mutableListOf(
        Data(R.drawable.profile_1, "루피1", "010-1111-1111"),
        Data(R.drawable.profile_2, "루피2", "010-2222-2222"),
        Data(R.drawable.profile_3, "루피3", "010-3333-3333"),
        AdData(R.drawable.ad_1),
        Data(R.drawable.profile_4, "루피4", "010-4444-4444"),
        Data(R.drawable.profile_5, "루피5", "010-5555-5555"),
        Data(R.drawable.profile_6, "루피6", "010-6666-6666"),
        Data(R.drawable.profile_7, "루피7", "010-7777-7777"),
        AdData(R.drawable.ad_2),
        Data(R.drawable.profile_8, "루피8", "010-8888-8888"),
        Data(R.drawable.profile_9, "루피9", "010-9999-9999"),
        Data(R.drawable.profile_10, "루피10", "010-1010-1010"),
        Data(R.drawable.profile_11, "루피11", "010-0011-0011"),
        Data(R.drawable.profile_12, "루피12", "010-1212-1212"),
        AdData(R.drawable.ad_3),
    )
}

interface Item

data class Data(
    val picture: Int,
    val name: String,
    val number: String,
):Item

data class AdData(
    val ad: Int,
):Item