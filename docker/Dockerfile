FROM alpine:edge
MAINTAINER lrdalpiaz@gmail.com
RUN apk add --no-cache openjdk8
COPY docker/UnlimitedJCEPolicyJDK8/* \
  /usr/lib/jvm/java-1.8-openjdk/jre/lib/security/
