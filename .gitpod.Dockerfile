FROM gitpod/workspace-full
FROM quadeare/gitpod-kubectl:latest

RUN wget -q https://raw.githubusercontent.com/dapr/cli/master/install/install.sh -O - | /bin/bash 

RUN export PATH="$PATH:/home/gitpod/.dapr/bin"

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh              && sdk install java 17.0.2-zulu"

