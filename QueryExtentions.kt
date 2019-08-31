package com.daya.clientapp.query


infix fun String.aliasTableAs(alias : String) :String{
    return "$this as $alias"
}

infix fun String.aliasQueryAs(alias : String) :String{
    return "($this) as $alias"
}

infix fun String.of(alias: String):String{
    return "$alias.$this"
}