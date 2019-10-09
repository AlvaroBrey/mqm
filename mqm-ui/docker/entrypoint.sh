#!/usr/bin/env sh
set -eu

export API_HOST=${API_HOST:-mqm-api}
export API_PORT=${API_PORT:-8080}

echo "API url: http://${API_HOST}:${API_PORT}"
envsubst '${API_HOST} ${API_PORT}' < /etc/nginx/conf.d/nginx.conf.template > /etc/nginx/conf.d/nginx.conf

exec "$@"