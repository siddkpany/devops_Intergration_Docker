pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven_3_9_6"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
               // git 'https://github.com/siddkpany/devops_Intergration_Docker'
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/siddkpany/devops_Intergration_Docker']])

                // Run Maven on a Unix agent.
                bat "mvn clean install"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        stage('build docker image')
        {
            steps{
                script{
                   // bat 'docker build -t ft/encrypt-decypt-rsa .'
                    bat 'docker build --build-arg JAR_FILE=target/*.jar -t ft/rsa .'
                }
            }
        }
    }
}
