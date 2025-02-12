job('Prueba2-DSL') {
    description('Primera prueba de un job con DSL')

    scm {
        git('https://github.com/luimungar3/Script_parametro.git', 'main') { node ->
            node /gitConfigName('luimungar3')
            node /gitConfigEmail('correojenkins09@gmail.com')
        }
    }
  parameters {
  	stringParam('usuario' , defaultValue = 'Miguel')
    choiceParam('mundo', ['terrestre', 'marciano'])
    booleanParam('espia', false)
  }
  triggers {
  	cron('H/3 * * * *')
  }
  steps {
  	shell("bash scriptjob.sh")
  }
  publishers {
  	mailer('correojenkins09@gmail.com', true, true)
  }
}
