package test.notebook

return "Notebook"

String notebookVar() {
  println("Local: Notebook Level Var")
  return "Local: Notebook Level Var"
}

String notebookPassedVar(String passedVar) {
  println("Local: " + passedVar)
  return "Local: " + passedVar
}

String notebookMethod() {
  println("Local: notebookMethod")
  return "Local: notebookMethod"
}

static String notebookStaticMethod() {
    return "Local: Called static method"
}

class NotebookClass {
    final String value = "Local: NotebookClass method"
    println("Local: NotebookClass constructor")
    String getValue() {
        return value
    }
}

static String notebookStaticMethodUsingClass() {
    println("Local: notebookStaticMethodUsingClass")
  new NotebookClass().getValue()
}
