#!/bin/bash
if git tag | grep -q before_fix
then
    echo "Fix is already applied"
    exit 1
fi

echo "Committing changes..."
git tag -f before_fix
git merge fix --ff

curl "http://localhost:8080/post-commit-hook?user=build&access-token=anqqeNLeiHgeyQ43DGq1ks9OZZFMYho9&repository=file"

