FROM adoptopenjdk/openjdk16:jre

MAINTAINER pedja

ADD target/vacationsWeb.jar /vacationsWeb.jar

ENTRYPOINT ["java","-jar","/vacationsWeb.jar","VacationWebApplication"]