package chapter1

/**
 *
 * @author JoanneGeng
 * @date 2019/11/12
 **/
class Ex1 {
    companion object {
        fun run() {
            println((0 + 15) / 2)
            println(2.0e-6 * 100000000.1)
            println(true && false || true && true)
        }
    }

}


class Ex2 {
    companion object {
        fun run() {
            println((1 + 2.236) / 2)
            println(1.0 + 2.0 + 3.0 + 4.0)
            println(4.1 > +4) // 编译期true
            println((1 + 2).toString() + "3") // kotlin: <code>1 + 2 + "3"</code> is error
        }
    }

}

fun main() {

    println("Ex1")
    Ex1.run()

    println("Ex2")
    Ex2.run()
}


