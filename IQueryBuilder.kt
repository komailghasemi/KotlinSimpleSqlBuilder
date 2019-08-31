package com.daya.clientapp.query

interface IQueryBuilder {
    fun orderBy(column:String) : IOrderByQueryBuilder
    fun build(): String
}