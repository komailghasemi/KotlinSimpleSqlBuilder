package com.daya.clientapp.query

interface IFromTableQueryBuilder :IQueryBuilder{
    fun from(table : String) : IConditionQueryBuilder
}