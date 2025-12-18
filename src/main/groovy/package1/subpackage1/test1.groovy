package package1.subpackage1

import package2.subpackage1.test1

static void test() {
    println("Controller sourced package1.subpackage1.test1")
    test1.test()
}