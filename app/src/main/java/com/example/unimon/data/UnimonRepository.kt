package com.example.unimon.data

class UnimonRepository(private val unimonDao: UnimonDao) {
    fun getUnimon(): Unimon {
        return unimonDao.getUnimon()
    }

    fun updateUnimon(unimon: Unimon) {
    unimonDao.updateUnimon(unimon)
}
}
