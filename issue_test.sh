#!/usr/bin/env bash
UNCOMMITED_CHANGES="$(git status --porcelain)"

if [[ $UNCOMMITED_CHANGES ]]; then
  echo There are uncommited changes, please commit or stash them before you start your test.
  exit
fi

git switch cr/133742_prevent_negative_deposits
./utils/manual_test.sh
