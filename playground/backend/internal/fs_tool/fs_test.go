package fs_tool

import (
	pb "beam.apache.org/playground/backend/internal/api"
	"fmt"
	"github.com/google/uuid"
	"io/fs"
	"os"
	"reflect"
	"testing"
)

func TestLifeCycle_CreateExecutableFile(t *testing.T) {
	pipelineId := uuid.New()
	type fields struct {
		folderGlobs []string
		folder      Folder
		extension   Extension
		pipelineId  uuid.UUID
	}
	type args struct {
		code string
	}
	tests := []struct {
		name          string
		createFolders []string
		fields        fields
		args          args
		want          string
		wantErr       bool
	}{
		{
			name: "executable folder doesn't exist",
			fields: fields{
				folder: Folder{
					executableFolder: javaSrcFileFolder,
					compiledFolder:   javaBinFileFolder,
				},
			},
			args:    args{},
			want:    "",
			wantErr: true,
		},
		{
			name:          "executable folder exists",
			createFolders: []string{javaSrcFileFolder},
			fields: fields{
				folder:     Folder{executableFolder: javaSrcFileFolder},
				extension:  Extension{executableExtension: javaExecutableFileExtension},
				pipelineId: pipelineId,
			},
			args:    args{code: "TEST_CODE"},
			want:    fmt.Sprintf("%s.%s", pipelineId, javaExecutableFileExtension),
			wantErr: false,
		},
	}
	for _, tt := range tests {
		for _, folder := range tt.createFolders {
			os.MkdirAll(folder, fs.ModePerm)
		}
		t.Run(tt.name, func(t *testing.T) {
			l := &LifeCycle{
				folderGlobs: tt.fields.folderGlobs,
				folder:      tt.fields.folder,
				extension:   tt.fields.extension,
				pipelineId:  tt.fields.pipelineId,
			}
			got, err := l.CreateExecutableFile(tt.args.code)
			if (err != nil) != tt.wantErr {
				t.Errorf("CreateExecutableFile() error = %v, wantErr %v", err, tt.wantErr)
				return
			}
			if got != tt.want {
				t.Errorf("CreateExecutableFile() got = %v, want %v", got, tt.want)
			}
		})
		os.RemoveAll(parentBaseFileFolder)
	}
}

func TestLifeCycle_CreateFolders(t *testing.T) {
	type fields struct {
		folderGlobs []string
		folder      Folder
		extension   Extension
		pipelineId  uuid.UUID
	}
	tests := []struct {
		name    string
		fields  fields
		wantErr bool
	}{
		{
			name:    "CreateFolders",
			fields:  fields{folderGlobs: []string{javaBaseFileFolder}},
			wantErr: false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			l := &LifeCycle{
				folderGlobs: tt.fields.folderGlobs,
				folder:      tt.fields.folder,
				extension:   tt.fields.extension,
				pipelineId:  tt.fields.pipelineId,
			}
			if err := l.CreateFolders(); (err != nil) != tt.wantErr {
				t.Errorf("CreateFolders() error = %v, wantErr %v", err, tt.wantErr)
			}
			for _, folder := range tt.fields.folderGlobs {
				if _, err := os.Stat(folder); os.IsNotExist(err) {
					t.Errorf("CreateFolders() should create folder %s, but it dosn't", folder)
				}
			}
		})
		os.RemoveAll(parentBaseFileFolder)
	}
}

func TestLifeCycle_DeleteCompiledFile(t *testing.T) {
	type fields struct {
		folderGlobs []string
		folder      Folder
		extension   Extension
		pipelineId  uuid.UUID
	}
	tests := []struct {
		name    string
		fields  fields
		wantErr bool
	}{
		{
			name: "DeleteCompiledFile",
			fields: fields{
				folder:     Folder{},
				extension:  Extension{},
				pipelineId: uuid.New(),
			},
			wantErr: false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			l := &LifeCycle{
				folderGlobs: tt.fields.folderGlobs,
				folder:      tt.fields.folder,
				extension:   tt.fields.extension,
				pipelineId:  tt.fields.pipelineId,
			}
			if err := l.DeleteCompiledFile(); (err != nil) != tt.wantErr {
				t.Errorf("DeleteCompiledFile() error = %v, wantErr %v", err, tt.wantErr)
			}
		})
	}
}

func TestLifeCycle_DeleteExecutableFile(t *testing.T) {
	type fields struct {
		folderGlobs []string
		folder      Folder
		extension   Extension
		pipelineId  uuid.UUID
	}
	tests := []struct {
		name    string
		fields  fields
		wantErr bool
	}{
		{
			name: "DeleteExecutableFile",
			fields: fields{
				folder:     Folder{},
				extension:  Extension{},
				pipelineId: uuid.New(),
			},
			wantErr: false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			l := &LifeCycle{
				folderGlobs: tt.fields.folderGlobs,
				folder:      tt.fields.folder,
				extension:   tt.fields.extension,
				pipelineId:  tt.fields.pipelineId,
			}
			if err := l.DeleteExecutableFile(); (err != nil) != tt.wantErr {
				t.Errorf("DeleteExecutableFile() error = %v, wantErr %v", err, tt.wantErr)
			}
		})
	}
}

func TestLifeCycle_DeleteFolders(t *testing.T) {
	type fields struct {
		folderGlobs []string
		folder      Folder
		extension   Extension
		pipelineId  uuid.UUID
	}
	tests := []struct {
		name    string
		fields  fields
		wantErr bool
	}{
		{
			name:    "DeleteFolders",
			fields:  fields{folderGlobs: []string{javaBaseFileFolder}},
			wantErr: false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			l := &LifeCycle{
				folderGlobs: tt.fields.folderGlobs,
				folder:      tt.fields.folder,
				extension:   tt.fields.extension,
				pipelineId:  tt.fields.pipelineId,
			}
			if err := l.DeleteFolders(); (err != nil) != tt.wantErr {
				t.Errorf("DeleteFolders() error = %v, wantErr %v", err, tt.wantErr)
			}
		})
	}
}

func TestNewLifeCycle(t *testing.T) {
	pipelineId := uuid.New()
	type args struct {
		sdk        pb.Sdk
		pipelineId uuid.UUID
	}
	tests := []struct {
		name    string
		args    args
		want    *LifeCycle
		wantErr bool
	}{
		{
			name: "Available SDK",
			args: args{
				sdk:        pb.Sdk_SDK_JAVA,
				pipelineId: pipelineId,
			},
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
			wantErr: false,
		},
		{
			name: "Unavailable SDK",
			args: args{
				sdk:        pb.Sdk_SDK_UNSPECIFIED,
				pipelineId: pipelineId,
			},
			want:    nil,
			wantErr: true,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got, err := NewLifeCycle(tt.args.sdk, tt.args.pipelineId)
			if (err != nil) != tt.wantErr {
				t.Errorf("NewLifeCycle() error = %v, wantErr %v", err, tt.wantErr)
				return
			}
			if !reflect.DeepEqual(got, tt.want) {
				t.Errorf("NewLifeCycle() got = %v, want %v", got, tt.want)
			}
		})
	}
}

func Test_getFileName(t *testing.T) {
	pipelineId := uuid.New()
	type args struct {
		pipelineId uuid.UUID
		fileType   string
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{
			name: "getFileName",
			args: args{
				pipelineId: pipelineId,
				fileType:   javaExecutableFileExtension,
			},
			want: fmt.Sprintf("%s.%s", pipelineId, javaExecutableFileExtension),
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := getFileName(tt.args.pipelineId, tt.args.fileType); got != tt.want {
				t.Errorf("getFileName() = %v, want %v", got, tt.want)
			}
		})
	}
}
