package com.daya.clientapp.query

interface IAndOrQueryBuilder :IQueryBuilder{
    fun or():IOperatorQueryBuilder
    fun and():IOperatorQueryBuilder
}