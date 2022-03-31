#!/usr/bin/env sh
function setup_manual_test() {
  if [ -d apache-tomcat ]; then
    rm -rf apache-tomcat
  fi

  if [ -d teamscale-jacoco-agent ]; then
    rm -rf teamscale-jacoco-agent
  fi

  unzip manual_test.zip
}

setup_manual_test
