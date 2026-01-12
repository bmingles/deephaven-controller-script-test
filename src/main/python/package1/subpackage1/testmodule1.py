from deephaven_enterprise import controller_import
controller_import.meta_import()
import controller.package2.subpackage1.testmodule1

def test():
  print("Local Sourced package1.subpackage1.testmodule1")
  controller.package2.subpackage1.testmodule1.test()
