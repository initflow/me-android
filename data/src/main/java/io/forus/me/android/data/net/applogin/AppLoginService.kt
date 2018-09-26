package io.forus.me.android.data.net.applogin

import io.forus.me.android.data.entity.applogin.*
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AppLoginService{

    object Service {
        @JvmStatic  val SERVICE_ENDPOINT : String = "http://136.144.185.49/nl/"
    }

    @POST("organisation/create_login/")
    fun createLogin(@Body createLoginRequest: CreateLoginRequest) : Observable<CreateLoginResponse>

    @GET("organisation/login/info/")
    fun loginInfo(@Query("key") key: String) : Observable<LoginInfo>

    @POST("organisation/login/allow/")
    fun loginAllow(@Body allowRequest: AllowRequest) : Observable<LoginResponse>

    @POST("organisation/login/disallow/")
    fun loginDisallow(@Body disallowRequest: DisallowRequest) : Observable<LoginResponse>
}
