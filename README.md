# Controller Script - Remote File Source

Testing repo for sourcing controller scripts from VS Code extension.

- `main` - branch is setup with packages that can be sourced from controller. Log messages include "Controller" to identify them.
- `local` - branch can be used locally to verify that controller sources get overridden. Log messages include "Local" to identify them.

## Setup DH Server

https://deephaven.io/enterprise/docs/query-management/git/

## VS Code

- Install a version of the Deephaven extension that supports Groovy remote file source plugin.

[vscode-deephaven-1.0.10-remote.0.vsix](https://github.com/deephaven/vscode-deephaven/raw/4d810c2a184039236292eb5cabee6b366ed14a3c/releases/vscode-deephaven-1.0.10-remote.0.vsix)

## Running Test Scripts

- Clone this repo and checkout the `local` branch.
- Open the folder in VS Code and add `src/main/groovy/package1` and `src/main/groovy/package2` as remote file sources
- Run 1 of the test scripts:
  - `src/main/groovy/simpletest.groovy`
  - `src/main/groovy/multitest.groovy`
