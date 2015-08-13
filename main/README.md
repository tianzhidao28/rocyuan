mvn  clean deploy -P release -Dgpg.passphrase=1045138965 -X

mvn release:clean release:prepare release:perform
###
http://developer.51cto.com/art/201405/440958.htm