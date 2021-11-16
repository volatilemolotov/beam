from ci_helper import CIHelper


class CDHelper:
    def __init__(self):
        self.ci_helper = CIHelper()

    def get_run_output(self):
        self.ci_helper.find_examples()
        self.ci_helper.run_code()

    def store_precompiled_objects(self):
        pass