package test.notebook

return "Notebook"

String notebookVar() {
  println("Server: Notebook Level Var")
  return "Server: Notebook Level Var"
}

String notebookPassedVar(String passedVar) {
  println("Server: " + passedVar)
  return "Server: " + passedVar
}

String notebookMethod() {
  println("Server: notebookMethod")
  return "Server: notebookMethod"
}

static String notebookStaticMethod() {
    return "Server: Called static method"
}

class NotebookClass {
    {
        println("Server: NotebookClass constructor")
    }
    
    final String value = "Server: NotebookClass method"
    
    String getValue() {
        return value
    }
}

static String notebookStaticMethodUsingClass() {
    println("Server: notebookStaticMethodUsingClass")
  new NotebookClass().getValue()
}
