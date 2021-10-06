package fs_tool

import (
	"github.com/google/uuid"
	"reflect"
	"testing"
)

func Test_newJavaLifeCycle(t *testing.T) {
	pipelineId := uuid.New()
	type args struct {
		pipelineId uuid.UUID
	}
	tests := []struct {
		name string
		args args
		want *LifeCycle
	}{
		{
			name: "newJavaLifeCycle",
			args: args{pipelineId: pipelineId},
			want: &LifeCycle{
				folderGlobs: javaGlobs,
				folder: Folder{
					executableFolder: javaSrcFileFolder,
					compiledFolder:   javaBinFileFolder,
				},
				extension: Extension{
					executableExtension: javaExecutableFileExtension,
					compiledExtension:   javaCompiledFileExtension,
				},
				pipelineId: pipelineId,
			},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := newJavaLifeCycle(tt.args.pipelineId); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("newJavaLifeCycle() = %v, want %v", got, tt.want)
			}
		})
	}
}
