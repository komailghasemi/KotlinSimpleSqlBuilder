package com.daya.clientapp.query

import java.lang.StringBuilder


class QueryBuilder private constructor(vararg fields: String) : IFromTableQueryBuilder,
    IConditionQueryBuilder
    , IOperatorQueryBuilder, IAndOrQueryBuilder,
    IJoinQueryBuilder, IOnJoinQueryBuilder ,IOrderByQueryBuilder {


    private val builder: StringBuilder by lazy {
        StringBuilder()
    }

    companion object {
        fun select(vararg fields: String): IFromTableQueryBuilder {
            return QueryBuilder(*fields)
        }
    }


    init {
        var s = "SELECT "
        if (fields.isNullOrEmpty())
            s += "* "
        else {
            fields.forEachIndexed { index, item ->

                s += item

                s += if (fields.size - 1 != index)
                    ", "
                else
                    " "
            }


        }
        builder.append(s)

    }

    override fun from(table: String): IConditionQueryBuilder {
        builder.append("FROM $table ")
        return this
    }

    override fun join(): IJoinQueryBuilder {

        return this
    }


    override fun innerJoin(table: String): IOnJoinQueryBuilder {
        builder.append("INNER JOIN $table ")
        return this
    }

    override fun on(parentColumnName: Any?, entityColumnName: Any?): IConditionQueryBuilder {

        builder.append("ON ${parentColumnName.toString()} = ${entityColumnName.toString()} ")
        return this
    }

    override fun where(): IOperatorQueryBuilder {
        builder.append("WHERE ")
        return this
    }

    override fun equal(field: Any?, value: Any?, castTo: CastTo?): IAndOrQueryBuilder {

        if (castTo == null) {
            builder.append("${field.toString()} = ${value.toString()} ")
        } else {
            builder.append("${"CAST(${field.toString()} AS ${castTo.name})"} = ${value.toString()} ")
        }

        return this
    }

    override fun biggerOrEqual(field: Any?, value: Any?, castTo: CastTo?): IAndOrQueryBuilder {

        if (castTo == null) {
            builder.append("${field.toString()} >= ${value.toString()} ")
        } else {
            builder.append("${"CAST(${field.toString()} AS ${castTo.name})"} >= ${value.toString()} ")
        }

        return this
    }

    override fun smallerOrEqual(field: Any?, value: Any?, castTo: CastTo?): IAndOrQueryBuilder {
        if (castTo == null) {
            builder.append("${field.toString()} <= ${value.toString()} ")
        } else {
            builder.append("${"CAST(${field.toString()} AS ${castTo.name})"} <= ${value.toString()} ")
        }

        return this
    }

    override fun startWith(field: Any?, value: Any?): IAndOrQueryBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun endWith(field: Any?, value: Any?): IAndOrQueryBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun contains(field: Any?, value: Any?): IAndOrQueryBuilder {
        builder.append("${field.toString()} like N'%${value.toString()}%' ")


        return this
    }

    override fun isNull(field: Any?): IAndOrQueryBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isNotNull(field: Any?): IAndOrQueryBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun or(): IOperatorQueryBuilder {
        builder.append("or ")
        return this
    }

    override fun and(): IOperatorQueryBuilder {

        builder.append("and ")
        return this
    }

    override fun orderBy(column: String): IOrderByQueryBuilder {
        builder.append("ORDER BY $column ")
        return this
    }


    override fun asc() :IQueryBuilder {
        builder.append("asc ")
        return this

    }

    override fun desc():IQueryBuilder  {
        builder.append("desc ")
        return this
    }


    override fun build(): String {
        return builder.toString()
    }


}