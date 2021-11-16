class CIHelper:
    def __init__(self):
        print("Start validation examples")

    def find_examples(self):
        examples_sources = []
        # find all examples and returns file path to each of them
        examples = find_examples(root_dir)
        for example in examples:
            # get sdk based on filepath of example
            sdk = self._get_sdk(example)
            # read code from example's file
            with open(example) as parsed_file:
                examples_sources.append(parsed_file.read())
        return examples_sources

    def run_examples(self):
        pass

    def get_statuses(self):
        pass

    def validate(self):
        pass

    def get_run_outputs(self):
        pass

    def _get_sdk(self, example):
        pass