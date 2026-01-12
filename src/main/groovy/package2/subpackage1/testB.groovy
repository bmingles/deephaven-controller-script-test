package package2.subpackage1

import package2.subpackage1.testC

static void test() {
    println("Local sourced package2.subpackage1.testB")
    testC.test()
}