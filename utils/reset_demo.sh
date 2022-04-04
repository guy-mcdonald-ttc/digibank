#!/bin/bash
git switch --force cr/133742_prevent_negative_deposits
git reset --hard before_fix
git tag -d before_fix
