package io.forus.me.android.domain.repository.records

import io.forus.me.android.domain.models.account.NewAccountRequest
import io.forus.me.android.domain.models.account.RequestDelegatesQrModel
import io.forus.me.android.domain.models.account.RestoreAccountByEmailRequest
import io.forus.me.android.domain.models.assets.Asset
import io.forus.me.android.domain.models.common.Page
import io.forus.me.android.domain.models.records.Record
import io.forus.me.android.domain.models.records.RecordCategory
import io.forus.me.android.domain.models.vouchers.Transaction
import io.forus.me.android.domain.models.vouchers.Voucher
import io.forus.me.android.domain.models.wallets.Wallet
import io.reactivex.Observable

interface RecordsRepository {

    fun getRecords(): Observable<List<Record>>


    fun getCategories(): Observable<List<RecordCategory>>

}
