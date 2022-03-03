FROM gitpod/workspace-base:full

RUN wget -q https://raw.githubusercontent.com/dapr/cli/master/install/install.sh -O - | /bin/bash 
ENV dapr init 
ENV export PATH=$PATH:/home/gitpod/.dapr/bin
