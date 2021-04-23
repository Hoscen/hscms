FROM openjdk:8
MAINTAINER hoscen@qq.com
LABEL app="eureka-client" version="0.0.1" by="Hoscen"
COPY eureka-client-*.jar hscms-eureka-client-app.jar
EXPOSE 8601 8602 8603
CMD java -jar hscms-eureka-client-app.jar --spring.profiles.active=${spring_profiles_active}
ENV LANG C.UTF-8
