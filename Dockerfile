FROM openjdk:8-jre-alpine
LABEL maintainer="alvaro.brv@gmail.com"

WORKDIR /root

ADD build/distributions/mqm-api-0.0.1.zip .
RUN unzip mqm-api-0.0.1.zip && rm -v mqm-api-0.0.1.zip

CMD mqm-api-0.0.1/bin/mqm-api
