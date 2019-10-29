package com.rcorchero.footballplayers.injector.modules

import android.app.Application
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import com.rcorchero.footballplayers.BuildConfig
import com.rcorchero.footballplayers.R
import com.rcorchero.footballplayers.data.TeamsRepositoryImpl
import com.rcorchero.footballplayers.data.source.local.DatabaseHelper
import com.rcorchero.footballplayers.data.source.local.LocalDataSource
import com.rcorchero.footballplayers.data.source.local.LocalDataSourceImpl
import com.rcorchero.footballplayers.data.source.remote.APIService
import com.rcorchero.footballplayers.data.source.remote.RemoteDataSource
import com.rcorchero.footballplayers.data.source.remote.RemoteDataSourceImpl
import com.rcorchero.footballplayers.domain.repository.TeamsRepository
import com.rcorchero.footballplayers.platform.widget.SpinnerLoading
import com.rcorchero.footballplayers.platform.widget.SpinnerLoadingImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    fun provideSpinnerLoading(): SpinnerLoading = SpinnerLoadingImpl()

    @Provides
    @Singleton
    internal fun provideSQLiteOpenHelper(context: Context): SQLiteOpenHelper = DatabaseHelper(context)

    @Provides
    @Singleton
    @Named("connectionTimeout")
    fun provideConnectionTimeout(context: Application): Int = context.resources.getInteger(R.integer.connectionTimeout)

    @Provides
    @Singleton
    @Named("socketTimeout")
    fun provideSocketTimeout(context: Application): Int = context.resources.getInteger(R.integer.socketTimeout)

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = BuildConfig.LEVEL_LOGS
        return interceptor
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor,
                                     @Named("socketTimeout") socketTimeout: Int,
                                     @Named("connectionTimeout") connectionTimeout: Int): OkHttpClient {
        val clientBuilder = OkHttpClient().newBuilder()
        clientBuilder.readTimeout(socketTimeout.toLong(), TimeUnit.SECONDS)
        clientBuilder.connectTimeout(connectionTimeout.toLong(), TimeUnit.SECONDS)
        clientBuilder.addInterceptor(loggingInterceptor)
        return clientBuilder.build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofitClient(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.HOST)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): APIService = retrofit.create(APIService::class.java)

    @Provides
    @Singleton
    internal fun provideLocalDataSource(sqLiteOpenHelper: SQLiteOpenHelper): LocalDataSource =
        LocalDataSourceImpl(sqLiteOpenHelper)

    @Provides
    @Singleton
    internal fun provideRemoteDataSource(apiService: APIService): RemoteDataSource =
        RemoteDataSourceImpl(apiService)

    @Provides
    @Singleton
    internal fun provideRepository(localDataSource: LocalDataSource,
                                   remoteDataSource: RemoteDataSource): TeamsRepository =
        TeamsRepositoryImpl(localDataSource, remoteDataSource)
}