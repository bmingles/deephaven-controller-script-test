package package3.subpackage1

/**
 * Test file containing multiple class patterns to verify cache eviction
 * catches ALL classes defined in a single .groovy file.
 * 
 * Class patterns included:
 * 1. Primary class (MultiClassTest) - matches filename
 * 2. Static inner class (MultiClassTest$StaticHelper)
 * 3. Non-static inner class (MultiClassTest$InstanceHelper)
 * 4. Top-level helper class (AnotherHelper) - doesn't match filename
 * 5. Anonymous inner class (MultiClassTest$1, etc.)
 * 6. Local class (defined inside method)
 * 7. Closure-generated class
 */
class MultiClassTest {
    
    // Static inner class - generates MultiClassTest$StaticHelper
    static class StaticHelper {
        static void help() {
            println("Controller sourced MultiClassTest\$StaticHelper")
        }
    }
    
    // Non-static inner class - generates MultiClassTest$InstanceHelper  
    class InstanceHelper {
        void help() {
            println("Controller sourced MultiClassTest\$InstanceHelper")
        }
    }
    
    static void test() {
        println("Controller sourced package3.subpackage1.MultiClassTest")
        
        // Call static inner class
        StaticHelper.help()
        
        // Call non-static inner class (need instance)
        def instance = new MultiClassTest()
        def instanceHelper = instance.new InstanceHelper()
        instanceHelper.help()
        
        // Call top-level helper class (defined below)
        AnotherHelper.help()
        
        // Anonymous inner class - generates MultiClassTest$1
        Runnable anonymous = new Runnable() {
            void run() {
                println("Controller sourced MultiClassTest\$1 (anonymous)")
            }
        }
        anonymous.run()
        
        // Local class - defined inside method, generates MultiClassTest$1LocalClass or similar
        class LocalClass {
            void doWork() {
                println("Controller sourced MultiClassTest\$LocalClass (local)")
            }
        }
        new LocalClass().doWork()
        
        // Closure - generates synthetic class like MultiClassTest$_test_closure1
        def closure = { 
            println("Controller sourced MultiClassTest closure")
        }
        closure()
    }
}

/**
 * Additional top-level class in same file.
 * This is the trickiest case - the class name doesn't match the filename,
 * so cache eviction must handle this mapping.
 */
class AnotherHelper {
    static void help() {
        println("Controller sourced AnotherHelper (top-level in MultiClassTest.groovy)")
    }
}

/**
 * Yet another top-level class to ensure we catch multiple.
 */
class YetAnotherHelper {
    static void help() {
        println("Controller sourced YetAnotherHelper (top-level in MultiClassTest.groovy)")
    }
}
