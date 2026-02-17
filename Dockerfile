#FROM airhacks/glassfish
#COPY ./target/hello-todo.war ${DEPLOYMENT_DIR}
FROM quay.io/wildfly/wildfly
ADD ./target/hello-todo.war $JBOSS_HOME/standalone/deployments/
