package com.marcinmoskala.kotlinacademy.respositories

import com.marcinmoskala.kotlinacademy.common.HttpError
import com.marcinmoskala.kotlinacademy.data.News
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import retrofit2.Call
import retrofit2.HttpException
import retrofit2.http.GET
import ru.gildor.coroutines.retrofit.await

class NewsRepositoryImpl : NewsRepository {

    private val api = retrofit.create(Api::class.java)!!

    override suspend fun getNews(): List<News> {
        try {
            return api.getNews().await()
        } catch (t: HttpException) {
            throw HttpError(t.code(), t.message())
        }
    }

    interface Api {

        @GET("news")
        fun getNews(): Call<List<News>>
    }
}