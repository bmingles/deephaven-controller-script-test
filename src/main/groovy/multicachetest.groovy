// Test cache eviction with ALL class patterns in a single .groovy file.
// Add `src/main/groovy/package3` as a remote file source.
//
// Expected output when sourced from LOCAL branch:
//   Local sourced package3.subpackage1.MultiClassTest
//   Local sourced MultiClassTest$StaticHelper
//   Local sourced MultiClassTest$StaticHelper$DeeperNested
//   Local sourced MultiClassTest$InstanceHelper
//   Local sourced AnotherHelper (top-level in MultiClassTest.groovy)
//   Local sourced YetAnotherHelper (top-level in MultiClassTest.groovy)
//   Local sourced MultiClassTest$1 (anonymous)
//   Local sourced MultiClassTest$2 (anonymous)
//   Local sourced MultiClassTest$3 (anonymous)
//   Local sourced MultiClassTest closure1
//   Local sourced MultiClassTest closure2
//   Local sourced TestTrait.traitMethod()
//   Local sourced TestEnum.VALUE_A
//   Local sourced TestEnum.VALUE_B
//   Local sourced TestInterface exists: true
//
// Expected output when sourced from MAIN branch:
//   Controller sourced package3.subpackage1.MultiClassTest
//   ... (all "Controller" instead of "Local")
//
// If cache eviction fails, you may see a MIX of Local/Controller outputs,
// indicating some classes were evicted but others remained cached.
//
// Classes that must be evicted from cache:
// - MultiClassTest (primary)
// - MultiClassTest$StaticHelper (static inner)
// - MultiClassTest$StaticHelper$DeeperNested (deeply nested)
// - MultiClassTest$InstanceHelper (non-static inner)
// - MultiClassTest$1, $2, $3 (anonymous classes)
// - MultiClassTest$_test_closure1, $2 (closures)
// - AnotherHelper, YetAnotherHelper (top-level non-matching)
// - TestTrait, TestTrait$Trait$Helper (trait)
// - TestEnum, TestEnum$1, TestEnum$2 (enum with per-constant bodies)
// - TestInterface (interface)
// - TraitImplementor (trait implementor)

import package3.subpackage1.MultiClassTest

println("=== Testing MultiClassTest cache eviction ===")
MultiClassTest.test()
