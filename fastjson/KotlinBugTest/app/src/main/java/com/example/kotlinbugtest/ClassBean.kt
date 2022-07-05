package com.example.kotlinbugtest

/**
 * Author : wangbo
 * Date : 2022/7/5
 * Function : TODO 请在这里输入文件用途
 * Desc : TODO 请在这里输入文件描述
 */
data class ClassBean(
    var c_name: String?,
    var count: Int?,
    var is_collect: Boolean?,
    var is_like: Int?,
    var teacher: String?
){
    override fun toString(): String {
        return "ClassBean(c_name='$c_name', count='$count', is_collect=$is_collect, is_like='$is_like', teacher='$teacher')"
    }
}