# Stage 1: build
FROM node:lts-alpine

WORKDIR /root

ADD . .
RUN yarn install
RUN yarn build

# Stage 2: dist image
FROM nginx:alpine
LABEL maintainer="alvaro.brv@gmail.com"

RUN rm /etc/nginx/conf.d/default.conf
ADD docker/nginx.conf.template /etc/nginx/conf.d/nginx.conf.template
ADD docker/entrypoint.sh /entrypoint.sh
ENTRYPOINT ["/entrypoint.sh"]
CMD ["nginx", "-g", "daemon off;"]

COPY --from=0 /root/dist/ /usr/share/nginx/html
