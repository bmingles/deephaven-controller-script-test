package test.notebook

return "Notebook"

String notebookVar() {
  println("Remote: Notebook Level Var")
  return "Remote: Notebook Level Var"
}

String notebookPassedVar(String passedVar) {
  println("Remote: " + passedVar)
  return "Remote: " + passedVar
}

String notebookMethod() {
  println("Remote: notebookMethod")
  return "Remote: notebookMethod"
}

static String notebookStaticMethod() {
    return "Remote: Called static method"
}

class NotebookClass {
    final String value = "Remote: NotebookClass method"
    println("Remote: NotebookClass constructor")
    String getValue() {
        return value
    }
}

static String notebookStaticMethodUsingClass() {
    println("Remote: notebookStaticMethodUsingClass")
  new NotebookClass().getValue()
}
