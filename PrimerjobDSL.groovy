job('Prueba2-DSL') {
    description('Primera prueba de un job con DSL') //Añadir esta descripcioin a la tarea que se creará

    scm {
        git('https://github.com/luimungar3/Script_parametro.git', 'main') { node -> 
            node /gitConfigName('luimungar3')   
            node /gitConfigEmail('correojenkins09@gmail.com') 
        }
    }
  parameters {
  	stringParam('usuario' , defaultValue = 'Miguel') //Establecer un parametro de cadena, que de forma predeterminada es 'Miguel'
    choiceParam('mundo', ['terrestre', 'marciano']) // Establecer un parametro de opciones en el que existen 2 
    booleanParam('espia', false) //Parametro booleano, que por default esta en false
  }
  triggers {
  	cron('H/3 * * * *') 
  }
  steps {
  	shell("bash scriptjob.sh") 
  }
  publishers {
  	mailer('correojenkins09@gmail.com', true, true) //Se envia una notificacion si la ejecución de la tarea falla
  }
}
