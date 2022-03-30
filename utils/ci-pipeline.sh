# build and test app
./mvnw clean verify
# upload test coverage to Teamscale
./utils/teamscale-upload -s http://localhost:8080 -u build -a anqqeNLeiHgeyQ43DGq1ks9OZZFMYho9 -p digibank -t 'Automated Tests' -f jacoco '**/jacoco.xml'
