package xyz.xyz0z0.androidadvanced.c01

import java.util.Collections.emptyList

/**
 * Author: Cheng
 * Date: 2021/6/3 11:44
 * Description: xyz.xyz0z0.androidadvanced.c01
 */
class KotlinGenericTest {

    fun <T : Number> total(list: List<T>): Int {
        return 0
    }

    fun <T> testNull1(list: List<T>) {

    }

    fun <T : Any> testNull2(list: List<T>) {
    }

    fun <T : Any> test() {
        val list = emptyList<String>()
        testNull1<String?>(list)
        testNull2<String>(list)
        val list2 = emptyList<T>()
        testNull2<T>(list2)
    }

//    fun <T> isInt(value: Int): Boolean {
//        return value is T // Cannot check for instance of erased type: T
//    }

    inline fun <reified T> isString(value: String): Boolean {
        return value is T
    }

//    fun <S : Any> test2() {
//        isString<String>("")
//        isString<S>("") // Cannot use 'S' as reified type parameter. Use a class instead.
//    }


    fun test3(){
//        val list : MutableList<*>  = MutableList<*>()
    }

}