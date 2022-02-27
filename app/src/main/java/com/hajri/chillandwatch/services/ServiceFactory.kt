package com.hajri.chillandwatch.services

import com.hajri.chillandwatch.ChillAndWatchConstant.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ServiceFactory {
    companion object {

       /**
        * Creates a retrofit service instance.
        * @param serviceClass type of the service to create
        *
        * @return the generated service ([T]) instance
        * */
       fun <T> generate(
           serviceClass: Class<T>
       ): T {

           val mOkHttpClient = OkHttpClient
               .Builder()
               .addInterceptor(RequestInterceptor())
               .build()


           return Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
               .client(mOkHttpClient)
               .build()
               .create(serviceClass)
       }
    }

}