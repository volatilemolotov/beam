package dataset_parsers

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"path/filepath"
)

type Strings struct {
	Strings []Entry `json:"strings"`
}

type Entry struct {
	Key   int    `json:"key"`
	Value string `json:"value"`
}

type JsonParser struct {
}

func NewJsonParser() *JsonParser {
	return &JsonParser{}
}

func (jp *JsonParser) GetStrings() *Strings {
	stringsJsonPath := filepath.Join("/Users/akvelon/IdeaProjects/beam/playground/backend/internal/emulators/", "datasets", "strings.json")
	file, err := ioutil.ReadFile(stringsJsonPath)
	if err != nil {
		fmt.Println(err)
	}
	strings := Strings{}
	err = json.Unmarshal(file, &strings)
	return &strings

}
