# This script defines a "custom_controller" prefix that can be used to source
# controller packages from GIT
from deephaven_enterprise import controller_import
controller_import.meta_import("custom_controller")

from custom_controller.package1.subpackage1.testmodule1 import test # switch package1 and package2 as needed.
test()