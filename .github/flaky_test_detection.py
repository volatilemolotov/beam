import os
import inspect
import re
import random
from github import Github
from github import Auth
from grafana_client import GrafanaApi


GIT_ORG = "volatilemolotov"
GIT_REPO = "beam"
ALERT_NAME = "test2"
READ_ONLY = os.environ.get("READ_ONLY", "false")
GRAFANA_URL = "https://tempgrafana.volatilemolotov.com/"


class Alert:
    def __init__(self, workflow_id, workflow_url):
        self.workflow_id = workflow_id
        self.workflow_url = workflow_url


def get_issues(r):
    open_issues = r.get_issues(state="open", labels=["flaky_test"])
    return open_issues


def create_issue(r, alert):

    title_string = f"Flaky Test {alert.workflow_id}"
    body_string = f"for more info see https://someurl/workflow/{alert.workflow_id}"
    labels_list = ["flaky_test", f"workflow id: {alert.workflow_id}"]
    print(f"Title: {title_string}")
    print(f"Body: {body_string}")
    print(f"Labels: {labels_list}")
    if READ_ONLY == "true":
        print("READ_ONLY is true, not creating issue")
    else:
        r.create_issue(title=title_string, labels=labels_list, body=body_string)


def get_grafana_alerts():
    grafana = GrafanaApi.from_url(
        url=GRAFANA_URL,
    )
    # Regex for key, value - Had to exclude comma (,) and bracket (})
    pattern = r"(\w+)=(\S[^,}]+)"
    annotations = grafana.annotations.get_annotation(ann_type="alert")
    firing_alerts = []
    for annotation in annotations:
        kv_pairs = re.findall(pattern, annotation["text"])
        if kv_pairs:
            data = dict(kv_pairs)
            if data["alertname"] == ALERT_NAME:
                alert = Alert(data["workflow_id"], data["workflow_url"])
                firing_alerts.append(alert)
    # return only a single record for testing
    return firing_alerts[:1]


def main():
    if "GITHUB_TOKEN" not in os.environ:
        print("Please set the GITHUB_TOKEN environment variable.")
        return
    token = os.environ["GITHUB_TOKEN"]
    auth = Auth.Token(token)
    g = Github(auth=auth)
    repo = g.get_repo(f"{GIT_ORG}/{GIT_REPO}")

    alerts = get_grafana_alerts()
    issues = get_issues(repo)
    alert_ids = [alert.workflow_id for alert in alerts]

    for alert in alerts:
        for issue in issues:
            print(issue.title)
            for label in issue.get_labels():
                label_id = re.search(r"\d+", str(label.name))
                if label_id is not None:
                    label_id = label_id.group()
                    if label_id in alert_ids:
                        print("issue already exists, skipping")

    exit()
    # if label_id is not NoneType:
    #     print(label_id)
    #     if label_id in alert_ids:
    #         print("issue already exists, skipping")
    # for alert in alerts:
    #     create_issue(repo, alert)

    g.close()


if __name__ == "__main__":
    main()
