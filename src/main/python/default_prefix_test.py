# This script uses the default "controller" prefix that can be used to source
# controller packages from GIT
from deephaven_enterprise import controller_import
controller_import.meta_import() # no parameter defaults to "controller"

from controller.package1.subpackage1.testmodule1 import test # switch package1 and package2 as needed.
test()