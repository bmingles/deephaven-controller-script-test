package package3.subpackage1

/**
 * Test file containing ALL class patterns to verify cache eviction
 * catches EVERY class defined in a single .groovy file.
 * 
 * Class patterns included:
 * 1. Primary class (MultiClassTest) - matches filename
 * 2. Static inner class (MultiClassTest$StaticHelper)
 * 3. Non-static inner class (MultiClassTest$InstanceHelper)
 * 4. Deeply nested class (MultiClassTest$StaticHelper$DeeperNested)
 * 5. Top-level helper classes (AnotherHelper, YetAnotherHelper)
 * 6. Anonymous inner classes (MultiClassTest$1, $2, $3)
 * 7. Closure-generated classes (MultiClassTest$_test_closure1, etc.)
 * 8. Trait (TestTrait, TestTrait$Trait$Helper)
 * 9. Enum (TestEnum, TestEnum$1, TestEnum$2 for per-constant bodies)
 * 10. Interface (TestInterface)
 */
class MultiClassTest {
    
    // Static inner class - generates MultiClassTest$StaticHelper
    static class StaticHelper {
        static void help() {
            println("Local sourced MultiClassTest\$StaticHelper")
        }
        
        // Deeply nested class - generates MultiClassTest$StaticHelper$DeeperNested
        static class DeeperNested {
            static void help() {
                println("Local sourced MultiClassTest\$StaticHelper\$DeeperNested")
            }
        }
    }
    
    // Non-static inner class - generates MultiClassTest$InstanceHelper  
    class InstanceHelper {
        void help() {
            println("Local sourced MultiClassTest\$InstanceHelper")
        }
    }
    
    static void test() {
        println("Local sourced package3.subpackage1.MultiClassTest")
        
        // Call static inner class
        StaticHelper.help()
        
        // Call deeply nested class
        StaticHelper.DeeperNested.help()
        
        // Call non-static inner class (need instance of outer class)
        def instance = new MultiClassTest()
        def instanceHelper = new MultiClassTest.InstanceHelper(instance)
        instanceHelper.help()
        
        // Call top-level helper classes (defined below in same file)
        // These can't be imported directly - only accessible within same compilation unit
        AnotherHelper.help()
        YetAnotherHelper.help()
        
        // Multiple anonymous inner classes - generates MultiClassTest$1, $2, $3
        Runnable anonymous1 = new Runnable() {
            void run() {
                println("Local sourced MultiClassTest\$1 (anonymous)")
            }
        }
        anonymous1.run()
        
        Runnable anonymous2 = new Runnable() {
            void run() {
                println("Local sourced MultiClassTest\$2 (anonymous)")
            }
        }
        anonymous2.run()
        
        Runnable anonymous3 = new Runnable() {
            void run() {
                println("Local sourced MultiClassTest\$3 (anonymous)")
            }
        }
        anonymous3.run()
        
        // Multiple closures - generates MultiClassTest$_test_closure1, $2, etc.
        def closure1 = { 
            println("Local sourced MultiClassTest closure1")
        }
        closure1()
        
        def closure2 = {
            println("Local sourced MultiClassTest closure2")
        }
        closure2()
        
        // Test trait
        def traitImpl = new TraitImplementor()
        traitImpl.traitMethod()
        
        // Test enum
        TestEnum.VALUE_A.describe()
        TestEnum.VALUE_B.describe()
        
        // Test interface (just verify it's accessible)
        println("Local sourced TestInterface exists: " + (TestInterface != null))
    }
}

/**
 * Trait - Groovy-specific. Generates:
 * - TestTrait
 * - TestTrait$Trait$Helper (internal helper class)
 */
trait TestTrait {
    void traitMethod() {
        println("Local sourced TestTrait.traitMethod()")
    }
}

/**
 * Class implementing the trait - needed to exercise trait code
 */
class TraitImplementor implements TestTrait {
    // Uses default trait implementation
}

/**
 * Enum with per-constant method bodies - Generates:
 * - TestEnum
 * - TestEnum$1 (for VALUE_A's body)
 * - TestEnum$2 (for VALUE_B's body)
 */
enum TestEnum {
    VALUE_A {
        void describe() {
            println("Local sourced TestEnum.VALUE_A")
        }
    },
    VALUE_B {
        void describe() {
            println("Local sourced TestEnum.VALUE_B")
        }
    }
    
    abstract void describe()
}

/**
 * Interface - Generates TestInterface
 */
interface TestInterface {
    void doSomething()
}

/**
 * Additional top-level class in same file.
 * This is the trickiest case - the class name doesn't match the filename,
 * so cache eviction must handle this mapping.
 */
class AnotherHelper {
    static void help() {
        println("Local sourced AnotherHelper (top-level in MultiClassTest.groovy)")
    }
}

/**
 * Yet another top-level class to ensure we catch multiple.
 */
class YetAnotherHelper {
    static void help() {
        println("Local sourced YetAnotherHelper (top-level in MultiClassTest.groovy)")
    }
}
