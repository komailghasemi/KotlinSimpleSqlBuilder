package com.daya.clientapp.query

interface IConditionQueryBuilder : IQueryBuilder{
    fun where() : IOperatorQueryBuilder
    fun join() : IJoinQueryBuilder
}