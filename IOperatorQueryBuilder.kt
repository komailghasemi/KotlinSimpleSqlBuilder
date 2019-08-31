package com.daya.clientapp.query

interface IOperatorQueryBuilder{

    fun equal(field:Any? , value:Any? , castTo:CastTo? = null):IAndOrQueryBuilder
    fun biggerOrEqual(field:Any? , value:Any? , castTo:CastTo? = null):IAndOrQueryBuilder
    fun smallerOrEqual(field:Any? , value:Any? , castTo:CastTo? = null):IAndOrQueryBuilder
    fun startWith(field:Any? , value:Any?):IAndOrQueryBuilder
    fun endWith(field:Any? , value:Any?):IAndOrQueryBuilder
    fun contains(field:Any? , value:Any?):IAndOrQueryBuilder
    fun isNull(field:Any?):IAndOrQueryBuilder
    fun isNotNull(field:Any?):IAndOrQueryBuilder

}