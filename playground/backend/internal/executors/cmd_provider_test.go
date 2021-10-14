package executors

import (
	pb "beam.apache.org/playground/backend/internal/api"
	"beam.apache.org/playground/backend/internal/environment"
	"beam.apache.org/playground/backend/internal/fs_tool"
	"beam.apache.org/playground/backend/internal/validators"
	"github.com/google/uuid"
	"io/fs"
	"os"
	"os/exec"
	"reflect"
	"testing"
)

var (
	pipelineId = uuid.New()
	env        *environment.Environment
	lc         *fs_tool.LifeCycle
	filePath   string
)

const (
	javaCode   = "class HelloWorld {\n    public static void main(String[] args) {\n        System.out.println(\"Hello World!\");\n    }\n}"
	javaConfig = "{\n  \"compile_cmd\": \"javac\",\n  \"run_cmd\": \"java\",\n  \"compile_args\": [\"-d\", \"bin\", \"-classpath\"],\n  \"run_args\": [\"-cp\", \"bin:\"]\n}"
)

func TestMain(m *testing.M) {
	lc = setup()
	defer teardown(lc)
	m.Run()
}

func setup() *fs_tool.LifeCycle {
	lc, _ := fs_tool.NewLifeCycle(pb.Sdk_SDK_JAVA, pipelineId)
	_ = lc.CreateFolders()
	filePath, _ = lc.CreateExecutableFile(javaCode)
	p, _ := os.Getwd()
	os.MkdirAll("configs", fs.ModePerm)
	os.WriteFile("configs/SDK_JAVA.json", []byte(javaConfig), 0600)
	os.Setenv("CONFIG_FOLDER", p+"/configs/")
	env = environment.NewEnvironment()
	return lc
}

func teardown(lc *fs_tool.LifeCycle) {
	err := lc.DeleteFolders()
	if err != nil {
		return
	}
	err = os.RemoveAll("configs")
	if err != nil {
		return
	}
}

func TestNewProvider(t *testing.T) {
	validatorsFuncs := validators.GetJavaValidators(lc.GetAbsoluteExecutableFilePath())
	type args struct {
		envs            environment.BeamEnvs
		workingDir      string
		filePath        string
		validatorsFuncs *[]validators.Validator
	}
	tests := []struct {
		name string
		args args
		want *CmdProvider
	}{
		{
			name: "NewCmdProvider",
			args: args{
				envs:            env.BeamSdkEnvs,
				workingDir:      "./",
				filePath:        filePath,
				validatorsFuncs: validatorsFuncs,
			},
			want: &CmdProvider{
				dirPath:        "./",
				validators:     *validatorsFuncs,
				compileCommand: "javac",
				compileArgs:    []string{"-d", "bin", "-classpath", "/opt/apache/beam/jars/beam-sdks-java-harness.jar", filePath},
				runCommand:     "java",
				runArgs:        []string{"-cp", "bin:/opt/apache/beam/jars/beam-sdks-java-harness.jar:/opt/apache/beam/jars/beam-runners-direct.jar:/opt/apache/beam/jars/slf4j-jdk14.jar"},
			},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := NewCmdProvider(tt.args.envs, tt.args.workingDir, filePath, tt.args.validatorsFuncs); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("NewCmdProvider() = %v, want %v", got, tt.want)
			}
		})
	}
}

func TestCmdProvider_Compile(t *testing.T) {
	type fields struct {
		dirPath        string
		validators     []validators.Validator
		compileCommand string
		compileArgs    []string
		runCommand     string
		runArgs        []string
	}
	tests := []struct {
		name   string
		fields fields
		want   *exec.Cmd
	}{
		{
			name: "TestCompile",
			fields: fields{
				dirPath:        "./",
				validators:     nil,
				compileCommand: "javac",
				compileArgs:    []string{"-d", "bin", "-classpath", "/opt/apache/beam/jars/beam-sdks-java-harness.jar", filePath},
				runCommand:     "",
				runArgs:        []string{},
			},
			want: &exec.Cmd{
				Path:         "/usr/bin/javac",
				Args:         []string{"javac", "-d", "bin", "-classpath", "/opt/apache/beam/jars/beam-sdks-java-harness.jar", filePath},
				Env:          nil,
				Dir:          "",
				Stdin:        nil,
				Stdout:       nil,
				Stderr:       nil,
				ExtraFiles:   nil,
				SysProcAttr:  nil,
				Process:      nil,
				ProcessState: nil,
			},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			ex := &CmdProvider{
				dirPath:        tt.fields.dirPath,
				validators:     tt.fields.validators,
				compileCommand: tt.fields.compileCommand,
				compileArgs:    tt.fields.compileArgs,
				runCommand:     tt.fields.runCommand,
				runArgs:        tt.fields.runArgs,
			}
			if got := ex.Compile(); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("Compile() = %v, want %v", got, tt.want)
			}
		})
	}
}

//func TestCmdProvider_Run(t *testing.T) {
//	type fields struct {
//		relativeFilePath string
//		absoulteFilePath string
//		dirPath          string
//		executableDir    string
//		validators       []validators.Validator
//		compileCommand   string
//		compileArgs      []string
//		runCommand       string
//		runArgs          []string
//	}
//	type args struct {
//		name string
//	}
//	tests := []struct {
//		name   string
//		fields fields
//		args   args
//		want   *exec.Cmd
//	}{
//		// TODO: Add test cases.
//	}
//	for _, tt := range tests {
//		t.Run(tt.name, func(t *testing.T) {
//			ex := &CmdProvider{
//				relativeFilePath: tt.fields.relativeFilePath,
//				absoulteFilePath: tt.fields.absoulteFilePath,
//				dirPath:          tt.fields.dirPath,
//				executableDir:    tt.fields.executableDir,
//				validators:       tt.fields.validators,
//				compileCommand:   tt.fields.compileCommand,
//				compileArgs:      tt.fields.compileArgs,
//				runCommand:       tt.fields.runCommand,
//				runArgs:          tt.fields.runArgs,
//			}
//			if got := ex.Run(tt.args.name); !reflect.DeepEqual(got, tt.want) {
//				t.Errorf("Run() = %v, want %v", got, tt.want)
//			}
//		})
//	}
//}
//
//func TestCmdProvider_Validators(t *testing.T) {
//	type fields struct {
//		relativeFilePath string
//		absoulteFilePath string
//		dirPath          string
//		executableDir    string
//		validators       []validators.Validator
//		compileCommand   string
//		compileArgs      []string
//		runCommand       string
//		runArgs          []string
//	}
//	tests := []struct {
//		name   string
//		fields fields
//		want   func() error
//	}{
//		// TODO: Add test cases.
//	}
//	for _, tt := range tests {
//		t.Run(tt.name, func(t *testing.T) {
//			ex := &CmdProvider{
//				relativeFilePath: tt.fields.relativeFilePath,
//				absoulteFilePath: tt.fields.absoulteFilePath,
//				dirPath:          tt.fields.dirPath,
//				executableDir:    tt.fields.executableDir,
//				validators:       tt.fields.validators,
//				compileCommand:   tt.fields.compileCommand,
//				compileArgs:      tt.fields.compileArgs,
//				runCommand:       tt.fields.runCommand,
//				runArgs:          tt.fields.runArgs,
//			}
//			if got := ex.Validators(); !reflect.DeepEqual(got, tt.want) {
//				t.Errorf("Validators() = %v, want %v", got, tt.want)
//			}
//		})
//	}
//}
