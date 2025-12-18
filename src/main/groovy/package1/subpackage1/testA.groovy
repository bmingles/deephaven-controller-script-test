package package1.subpackage1

import package2.subpackage1.testB

static void test() {
    println("Controller sourced package1.subpackage1.testA")
    testB.test()
}