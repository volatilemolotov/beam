package executors

import (
	"beam.apache.org/playground/backend/internal/environment"
	"beam.apache.org/playground/backend/internal/validators"
)

type handler func(executor *Executor)

//ExecutorBuilder struct
type ExecutorBuilder struct {
	actions []handler
}

//CompileBuilder facet of ExecutorBuilder
type CompileBuilder struct {
	ExecutorBuilder
}

//RunBuilder facet of ExecutorBuilder
type RunBuilder struct {
	ExecutorBuilder
}

//ValidatorBuilder facet of ExecutorBuilder
type ValidatorBuilder struct {
	ExecutorBuilder
}

//NewExecutorBuilder constructor for Executor
func NewExecutorBuilder() *ExecutorBuilder {
	return &ExecutorBuilder{}
}

// Compiler - Lives chains to type *ExecutorBuilder and returns a *CompileBuilder
func (b *ExecutorBuilder) Compiler() *CompileBuilder {
	return &CompileBuilder{*b}
}

// Runner - Lives chains to type *ExecutorBuilder and returns a *CompileBuilder
func (b *ExecutorBuilder) Runner() *RunBuilder {
	return &RunBuilder{*b}
}

// Validator - Lives chains to type *ExecutorBuilder and returns a *CompileBuilder
func (b *ExecutorBuilder) Validator() *ValidatorBuilder {
	return &ValidatorBuilder{*b}
}

//withCommand adds compile command to executor
func (b *CompileBuilder) withCommand(compileCmd string) *CompileBuilder {
	b.actions = append(b.actions, func(e *Executor) {
		e.compileArgs.commandName = compileCmd
	})
	return b
}

//withArgs adds compile args to executor
func (b *CompileBuilder) withArgs(compileArgs []string) *CompileBuilder {
	b.actions = append(b.actions, func(e *Executor) {
		e.compileArgs.commandArgs = compileArgs
	})
	return b
}

//withFileName adds file name to executor
func (b *CompileBuilder) withFileName(fileName string) *CompileBuilder {
	b.actions = append(b.actions, func(e *Executor) {
		e.compileArgs.fileName = fileName
	})
	return b
}

//withWorkingDir adds dir path to executor
func (b *CompileBuilder) withWorkingDir(dir string) *CompileBuilder {
	b.actions = append(b.actions, func(e *Executor) {
		e.compileArgs.dirPath = dir
	})
	return b
}

//withCommand adds run command to executor
func (b *RunBuilder) withCommand(runCmd string) *RunBuilder {
	b.actions = append(b.actions, func(e *Executor) {
		e.runArgs.commandName = runCmd
	})
	return b
}

//withArgs adds run args to executor
func (b *RunBuilder) withArgs(runArgs []string) *RunBuilder {
	b.actions = append(b.actions, func(e *Executor) {
		e.runArgs.commandArgs = runArgs
	})
	return b
}

//withClassName adds file name to executor
func (b *RunBuilder) withClassName(name string) *RunBuilder {
	b.actions = append(b.actions, func(e *Executor) {
		e.runArgs.fileName = name
	})
	return b
}

//withClassName adds file name to executor
func (b *RunBuilder) withGraphOutput() *RunBuilder {
	b.actions = append(b.actions, func(e *Executor) {
		//smth
	})
	return b
}

//withWorkingDir adds dir path to executor
func (b *RunBuilder) withWorkingDir(dir string) *RunBuilder {
	b.actions = append(b.actions, func(e *Executor) {
		e.runArgs.dirPath = dir
	})
	return b
}

//withClassName adds file name to executor
func (b *ValidatorBuilder) withSdkValidators(validators *[]validators.Validator) *ValidatorBuilder {
	b.actions = append(b.actions, func(e *Executor) {
		e.validators = *validators
	})
	return b
}

//Build builds the executor object
func (b *ExecutorBuilder) Build() Executor {
	executor := Executor{}
	for _, a := range b.actions {
		a(&executor)
	}
	return executor
}

//Return the executor builder
func (b *ExecutorBuilder) Return() *ExecutorBuilder {
	return b
}

// BaseExecutorBuilder fills up an executor with base parameters
func BaseExecutorBuilder(envs environment.BeamEnvs, workingDir string, filePath string, validatorsFuncs *[]validators.Validator) *ExecutorBuilder {
	if validatorsFuncs == nil {
		v := make([]validators.Validator, 0)
		validatorsFuncs = &v
	}
	builder := NewExecutorBuilder().
		Compiler().
		withCommand(envs.CmdConfig.CompileCmd).
		withArgs(envs.CmdConfig.CompileArgs).
		withFileName(filePath).
		withWorkingDir(workingDir).
		Runner().
		withCommand(envs.CmdConfig.RunCmd).
		withArgs(envs.CmdConfig.RunArgs).
		withClassName("HelloWorld").
		withWorkingDir(workingDir).
		Validator().
		withSdkValidators(validatorsFuncs).
		Return()
	return builder
}
