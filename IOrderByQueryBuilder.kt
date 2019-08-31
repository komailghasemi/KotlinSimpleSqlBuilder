package com.daya.clientapp.query

interface IOrderByQueryBuilder {
    fun asc() : IQueryBuilder
    fun desc(): IQueryBuilder
}