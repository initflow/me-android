package io.forus.me.android.domain.models.applogin

class LoginInfo(var key: String, var status: String, var authToken: String?, var data: String?, var organization: Organization?) {


    class Organization(var title: String, var owner: String, var publicKey: String) {

    }
}