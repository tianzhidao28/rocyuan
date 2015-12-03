cmd /k mvn install -DskipTest=true


mvn release:clean release:prepare release:perform -B -e | tee maven-central-deploy.log