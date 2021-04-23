FROM openjdk:8
MAINTAINER hoscen@qq.com
LABEL app="eureka-server" version="0.0.1" by="Hoscen"
COPY eureka-server-*.jar hscms-eureka-server-app.jar
EXPOSE 8501 8502 8503
CMD java -jar hscms-eureka-server-app.jar --spring.profiles.active=${spring_profiles_active}
ENV LANG C.UTF-8
