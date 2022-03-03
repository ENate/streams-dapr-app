FROM gitpod/workspace-base:latest

RUN wget -q https://raw.githubusercontent.com/dapr/cli/master/install/install.sh -O - | /bin/bash

RUN dapr init

ENV export PATH=$PATH:/home/gitpod/.dapr/bin