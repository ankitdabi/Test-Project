package com.example.testapplication.bean

import android.provider.BaseColumns

class FavoriteMovie {

    object FavoriteEntry : BaseColumns {
        const val TABLE_NAME = "favorite"
        const val COLUMN_MOVIEID = "movieid"
        const val COLUMN_TITLE = "title"
        const val COLUMN_USERRATING = "userrating"
        const val COLUMN_POSTER_PATH = "posterpath"
        const val COLUMN_PLOT_SYNOPSIS = "overview"
    }

    object MovieEntry : BaseColumns {
        const val TABLE_NAME = "movie"
        const val COLUMN_MOVIEID = "movieid"
        const val COLUMN_TITLE = "title"
        const val COLUMN_USERRATING = "userrating"
        const val COLUMN_POSTER_PATH = "posterpath"
        const val COLUMN_PLOT_SYNOPSIS = "overview"
    }
}