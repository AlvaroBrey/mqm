# Stage 1: build
FROM gradle:5.5.1
LABEL maintainer="alvaro.brv@gmail.com"

WORKDIR /root

ADD . .
RUN gradle build --no-daemon --console=verbose

# Stage 2: dist image
FROM openjdk:8-jre-alpine
LABEL maintainer="alvaro.brv@gmail.com"

WORKDIR /root

COPY --from=0 /root/build/distributions/mqm-api-0.0.1.zip .
RUN unzip mqm-api-0.0.1.zip && rm -v mqm-api-0.0.1.zip

CMD mqm-api-0.0.1/bin/mqm-api