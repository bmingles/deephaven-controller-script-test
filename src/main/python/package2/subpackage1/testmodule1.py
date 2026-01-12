from deephaven_enterprise import controller_import
controller_import.meta_import()
import controller.package2.subpackage1.testmodule2

def test():
  print("Local Sourced package2.subpackage1.testmodule1")
  controller.package2.subpackage1.testmodule2.test()
