package com.daya.clientapp.query

interface IOnJoinQueryBuilder{
    fun on(parentColumnName:Any? , entityColumnName:Any?) :IConditionQueryBuilder
}