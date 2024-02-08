import os
import re
from github import Github
from github import Auth
from grafana_client import GrafanaApi


GIT_ORG = "volatilemolotov"
GIT_REPO = "beam"
ALERT_NAME = "flaky_test"
READ_ONLY = os.environ.get("READ_ONLY", "false")
GRAFANA_URL = "https://tempgrafana.volatilemolotov.com/"


class Alert:
    def __init__(self, workflow_id, workflow_url, workflow_name, workflow_file_name):
        self.workflow_id = workflow_id
        self.workflow_url = workflow_url
        self.workflow_name = workflow_name
        self.workflow_file_name = workflow_file_name


def get_existing_issues(r):
    open_issues = r.get_issues(state="open", labels=["flaky_test"])
    existing_label_ids = []
    for issue in open_issues:
        for label in issue.get_labels():
            label_id = re.search(r"\d+", str(label.name))
            if label_id is not None:
                label_id = label_id.group()
                existing_label_ids.append(label_id)

    return existing_label_ids


def create_issue(r, alert):
    GIT_ORG = "apache"
    failing_runs_url = f"https://github.com/{GIT_ORG}/{GIT_REPO}/actions/workflows/{alert.workflow_file_name}?query=is%3Afailure+branch%3Amaster"
    title_string = f"{alert.workflow_name} is failing"
    body_string = f"""It seems that the {alert.workflow_name }is failing
    Please visit {failing_runs_url} to see the logs"""
    labels_list = ["flaky_test", f"workflow id: {alert.workflow_id}"]
    print("-" * 10)
    print(f"Title: {title_string}")
    print(f"Body: {body_string}")
    print(f"Labels: {labels_list}")
    print("-" * 10)

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
    annotations = grafana.annotations.get_annotation(ann_type="alert", limit=500)
    firing_alerts = []
    for annotation in annotations:
        if annotation["newState"] != "Alerting":
            continue
        kv_pairs = re.findall(pattern, annotation["text"])
        if kv_pairs:
            data = dict(kv_pairs)
            if data["alertname"] == ALERT_NAME:
                alert = Alert(
                    data["workflow_id"],
                    data["workflow_url"],
                    data["job_name"],
                    data["job_yml_filename"],
                )
                firing_alerts.append(alert)
    return firing_alerts


def main():
    if "GITHUB_TOKEN" not in os.environ:
        print("Please set the GITHUB_TOKEN environment variable.")
        return
    token = os.environ["GITHUB_TOKEN"]
    auth = Auth.Token(token)
    g = Github(auth=auth)
    repo = g.get_repo(f"{GIT_ORG}/{GIT_REPO}")

    alerts = get_grafana_alerts()

    existing_label_ids = get_existing_issues(repo)
    alert_ids = [alert.workflow_id for alert in alerts]

    for alert in alerts:
        if alert.workflow_id in existing_label_ids:
            print("issue already exists, skipping")
            continue
        create_issue(repo, alert)

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
