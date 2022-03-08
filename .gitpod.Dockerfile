FROM gitpod/workspace-full

RUN wget -q https://raw.githubusercontent.com/dapr/cli/master/install/install.sh -O - | /bin/bash 

# Install sdkman and java 17
RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh && sdk install java 17.0.2-zulu"

FROM quadeare/gitpod-kubectl:latest
