// Test cache eviction with multiple classes in a single .groovy file.
// Add `src/main/groovy/package3` as a remote file source.
//
// Expected output when sourced from LOCAL branch:
//   Local sourced package3.subpackage1.MultiClassTest
//   Local sourced MultiClassTest$StaticHelper
//   Local sourced MultiClassTest$InstanceHelper
//   Local sourced AnotherHelper (top-level in MultiClassTest.groovy)
//   Local sourced MultiClassTest$1 (anonymous)
//   Local sourced MultiClassTest$LocalClass (local)
//   Local sourced MultiClassTest closure
//
// Expected output when sourced from MAIN branch:
//   Controller sourced package3.subpackage1.MultiClassTest
//   ... (all "Controller" instead of "Local")
//
// If cache eviction fails, you may see a MIX of Local/Controller outputs,
// indicating some classes were evicted but others remained cached.

import package3.subpackage1.MultiClassTest
import package3.subpackage1.AnotherHelper
import package3.subpackage1.YetAnotherHelper

println("=== Testing MultiClassTest cache eviction ===")
MultiClassTest.test()

println("\n=== Direct calls to top-level helpers ===")
AnotherHelper.help()
YetAnotherHelper.help()
