package com.daya.clientapp.query

interface IJoinQueryBuilder {
    fun innerJoin(table : String) :IOnJoinQueryBuilder
}