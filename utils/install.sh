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
  branches="$(git branch --all | grep "remotes/origin/" | grep -v "HEAD" | sed 's/remotes\/origin\///')"
  for branch in $branches; do
    echo Creating local branch $branch
    git switch "$branch" >/dev/null 2>&1
  done
  git switch master
}

setup_manual_test
setup_git_repo
