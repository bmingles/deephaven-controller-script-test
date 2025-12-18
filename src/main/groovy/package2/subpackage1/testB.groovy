package package2.subpackage1

import package2.subpackage1.testC

static void test() {
    println("Controller sourced package2.subpackage1.testB")
    testC.test()
}