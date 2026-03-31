import io.deephaven.engine.context.ExecutionContext
import io.deephaven.engine.util.TableTools
import test.notebook.MyNotebook

ExecutionContext.getContext().getQueryLibrary().importClass(MyNotebook.class)

MyNotebook.main()

localVar = "Top Level Var"

println new MyNotebook().run()
println new MyNotebook().notebookVar()
println new MyNotebook().notebookPassedVar(localVar)
println new MyNotebook().notebookMethod()
println MyNotebook.notebookStaticMethod()
println MyNotebook.notebookStaticMethodUsingClass()

testTable = TableTools.emptyTable(1).updateView(
        "RunResult = new MyNotebook().run()",
        "NotebookVar = new MyNotebook().notebookVar()",
        "NotebookPassedVar = new MyNotebook().notebookPassedVar(`$localVar`)",
        "NotebookMethod = new MyNotebook().notebookMethod()",
        "NotebookStaticMethod = MyNotebook.notebookStaticMethod()",
        "NotebookClassMethod = MyNotebook.notebookStaticMethodUsingClass()"
)
