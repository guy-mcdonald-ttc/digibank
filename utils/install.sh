#!/usr/bin/env bash
function setup_manual_test() {
  if [ -d apache-tomcat ]; then
    rm -rf apache-tomcat
  fi

  if [ -d teamscale-jacoco-agent ]; then
    rm -rf teamscale-jacoco-agent
  fi

  unzip ./utils/manual_test.zip
}

function setup_git_repo() {
  # Clone all remote branches so that they are available locally
  branches="$(git branch --all | grep "remotes/origin/" | grep -v "HEAD" | sed 's/remotes\/origin\///')"
  for branch in $branches; do
    echo Creating local branch $branch
    git switch "$branch" >/dev/null 2>&1
  done
  git switch master

  # On Ubuntu this folder is created when Teamscale starts.
  # We need to exclude it from git for the release and issue test scripts to be able to switch branches
  # This was the easiest way to do that without another major rebase
  if [[ ! "$(tail -1 .git/info/exclude)" == "\"teamscale/teamscale/?\"" ]]; then
    echo "\"teamscale/teamscale/?\"" >>.git/info/exclude
  fi
}

setup_manual_test
setup_git_repo
