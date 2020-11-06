package com.example.testapplication.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log
import com.example.testapplication.bean.FavoriteMovie
import com.example.testapplication.bean.Movie
import com.example.testapplication.bean.MovieResults
import java.util.*

class SQLite(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    var dbhandler: SQLiteOpenHelper? = null
    var db: SQLiteDatabase? = null
    fun open() {
        Log.i(LOGTAG, "Database Opened")
        db = dbhandler!!.writableDatabase
    }

    override fun close() {
        Log.i(LOGTAG, "Database Closed")
        dbhandler!!.close()
    }

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        val SQL_CREATE_FAVORITE_TABLE =
            "CREATE TABLE " + FavoriteMovie.FavoriteEntry.TABLE_NAME.toString() + " (" +
                    BaseColumns._ID.toString() + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    FavoriteMovie.FavoriteEntry.COLUMN_MOVIEID.toString() + " INTEGER, " +
                    FavoriteMovie.FavoriteEntry.COLUMN_TITLE.toString() + " TEXT NOT NULL, " +
                    FavoriteMovie.FavoriteEntry.COLUMN_USERRATING.toString() + " REAL NOT NULL, " +
                    FavoriteMovie.FavoriteEntry.COLUMN_POSTER_PATH.toString() + " TEXT NOT NULL, " +
                    FavoriteMovie.FavoriteEntry.COLUMN_PLOT_SYNOPSIS.toString() + " TEXT NOT NULL" +
                    "); "
        val SQL_CREATE_MOVIE_TABLE =
            "CREATE TABLE " + FavoriteMovie.MovieEntry.TABLE_NAME.toString() + " (" +
                    BaseColumns._ID.toString() + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    FavoriteMovie.FavoriteEntry.COLUMN_MOVIEID.toString() + " INTEGER, " +
                    FavoriteMovie.FavoriteEntry.COLUMN_TITLE.toString() + " TEXT NOT NULL, " +
                    FavoriteMovie.FavoriteEntry.COLUMN_USERRATING.toString() + " REAL NOT NULL, " +
                    FavoriteMovie.FavoriteEntry.COLUMN_POSTER_PATH.toString() + " TEXT NOT NULL, " +
                    FavoriteMovie.FavoriteEntry.COLUMN_PLOT_SYNOPSIS.toString() + " TEXT NOT NULL" +
                    "); "
        sqLiteDatabase.execSQL(SQL_CREATE_FAVORITE_TABLE)
        sqLiteDatabase.execSQL(SQL_CREATE_MOVIE_TABLE)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FavoriteMovie.FavoriteEntry.TABLE_NAME)
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FavoriteMovie.MovieEntry.TABLE_NAME)
        onCreate(sqLiteDatabase)
    }

    fun addFavorite(movie: Movie) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(FavoriteMovie.FavoriteEntry.COLUMN_MOVIEID, movie.id)
        values.put(FavoriteMovie.FavoriteEntry.COLUMN_TITLE, movie.originalTitle)
        values.put(FavoriteMovie.FavoriteEntry.COLUMN_USERRATING, movie.voteAverage)
        values.put(FavoriteMovie.FavoriteEntry.COLUMN_POSTER_PATH, movie.posterPath)
        values.put(FavoriteMovie.FavoriteEntry.COLUMN_PLOT_SYNOPSIS, movie.overview)
        db.insert(FavoriteMovie.FavoriteEntry.TABLE_NAME, null, values)
        db.close()
    }

    fun addMovie(movie: Movie) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(FavoriteMovie.MovieEntry.COLUMN_MOVIEID, movie.id)
        values.put(FavoriteMovie.MovieEntry.COLUMN_TITLE, movie.originalTitle)
        values.put(FavoriteMovie.MovieEntry.COLUMN_USERRATING, movie.voteAverage)
        values.put(FavoriteMovie.MovieEntry.COLUMN_POSTER_PATH, movie.posterPath)
        values.put(FavoriteMovie.MovieEntry.COLUMN_PLOT_SYNOPSIS, movie.overview)
        db.insert(FavoriteMovie.MovieEntry.TABLE_NAME, null, values)
        db.close()
    }

    fun deleteFavorite(id: Int) {
        val db = this.writableDatabase
        db.delete(
            FavoriteMovie.FavoriteEntry.TABLE_NAME,
            FavoriteMovie.FavoriteEntry.COLUMN_MOVIEID.toString() + "=" + id,
            null
        )
    }

    val allFavorite: List<Any>
        get() {
            val columns = arrayOf<String>(
                BaseColumns._ID,
                FavoriteMovie.FavoriteEntry.COLUMN_MOVIEID,
                FavoriteMovie.FavoriteEntry.COLUMN_TITLE,
                FavoriteMovie.FavoriteEntry.COLUMN_USERRATING,
                FavoriteMovie.FavoriteEntry.COLUMN_POSTER_PATH,
                FavoriteMovie.FavoriteEntry.COLUMN_PLOT_SYNOPSIS
            )
            val sortOrder: String = BaseColumns._ID.toString() + " ASC"
            val favoriteList: MutableList<Movie> = ArrayList<Movie>()
            val db = this.readableDatabase
            val cursor = db.query(
                FavoriteMovie.FavoriteEntry.TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                sortOrder
            )
            if (cursor.moveToFirst()) {
                do {

                    val movieId : Int
                    val movieTitle : String
                    val movieVote : Double
                    val moviePoster : String


                    movieId = cursor.getString(cursor.getColumnIndex(FavoriteMovie.FavoriteEntry.COLUMN_MOVIEID)).toInt()
                    movieTitle = cursor.getString(cursor.getColumnIndex(FavoriteMovie.FavoriteEntry.COLUMN_TITLE))
                    movieVote = cursor.getString(cursor.getColumnIndex(FavoriteMovie.FavoriteEntry.COLUMN_USERRATING)).toDouble()
                    moviePoster = cursor.getString(cursor.getColumnIndex(FavoriteMovie.FavoriteEntry.COLUMN_POSTER_PATH))
                    val movie = Movie(movieId,movieTitle,movieVote,moviePoster)


                    favoriteList.add(movie)
                } while (cursor.moveToNext())
            }
            cursor.close()
            db.close()
            return favoriteList
        }
    val allMovie: List<Any>
        get() {
            val columns = arrayOf<String>(
                BaseColumns._ID,
                FavoriteMovie.MovieEntry.COLUMN_MOVIEID,
                FavoriteMovie.MovieEntry.COLUMN_TITLE,
                FavoriteMovie.MovieEntry.COLUMN_USERRATING,
                FavoriteMovie.MovieEntry.COLUMN_POSTER_PATH,
                FavoriteMovie.MovieEntry.COLUMN_PLOT_SYNOPSIS
            )
            val sortOrder: String = BaseColumns._ID.toString() + " ASC"
            val moviesList: MutableList<Movie> = ArrayList<Movie>()
            val db = this.readableDatabase
            val cursor = db.query(
                FavoriteMovie.MovieEntry.TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                sortOrder
            )
            if (cursor.moveToFirst()) {
                do {
                    val movieId : Int
                    val movieTitle : String
                    val movieVote : Double
                    val moviePoster : String


                    movieId = cursor.getString(cursor.getColumnIndex(FavoriteMovie.FavoriteEntry.COLUMN_MOVIEID)).toInt()
                    movieTitle = cursor.getString(cursor.getColumnIndex(FavoriteMovie.FavoriteEntry.COLUMN_TITLE))
                    movieVote = cursor.getString(cursor.getColumnIndex(FavoriteMovie.FavoriteEntry.COLUMN_USERRATING)).toDouble()
                    moviePoster = cursor.getString(cursor.getColumnIndex(FavoriteMovie.FavoriteEntry.COLUMN_POSTER_PATH))
                    val movie = Movie(movieId,movieTitle,movieVote,moviePoster)


                    moviesList.add(movie)
                } while (cursor.moveToNext())
            }
            cursor.close()
            db.close()
            return moviesList
        }

    companion object {
        private const val DATABASE_NAME = "database.db"
        private const val DATABASE_VERSION = 1
        const val LOGTAG = "DATABASE"
    }
}