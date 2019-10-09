# Stage 1: build
FROM node:lts-alpine

WORKDIR /root

ADD . .
RUN yarn install
RUN yarn build

# Stage 2: dist image
FROM nginx:alpine
LABEL maintainer="alvaro.brv@gmail.com"

WORKDIR /root

RUN rm /etc/nginx/conf.d/default.conf
ADD docker/nginx.conf /etc/nginx/conf.d/nginx.conf
COPY --from=0 /root/dist/ /usr/share/nginx/html
