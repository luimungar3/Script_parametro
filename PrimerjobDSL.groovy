job('Prueba2-DSL') {
    description('Primera prueba de un job con DSL') //Añadir esta descripcioin a la tarea que se creará

    scm {
        git('https://github.com/luimungar3/Script_parametro.git', 'main') { node -> //Definimos el repositorio de github, 
            node /gitConfigName('luimungar3')    //Añadimos el nombre de la persona que ejecuta el job(también es el que aparecerá en la notificación de correo)
            node /gitConfigEmail('correojenkins09@gmail.com') //definimos el correo para las notificaciones
        }
    }
  parameters {
  	stringParam('usuario' , defaultValue = 'Miguel') //Establecer un parametro de cadena, que de forma predeterminada es 'Miguel'
    choiceParam('mundo', ['terrestre', 'marciano']) // Establecer un parametro de opciones en el que existen 2 
    booleanParam('espia', false) //Parametro booleano, que por default esta en false
  }
  triggers {
  	cron('H/3 * * * *') //Cron repite la tarea de forma periodica, cada 3 mins en este caso
  }
  steps {
  	shell("bash scriptjob.sh") //Una vez declarados todas las opciones y variables usadas ejecutamos el script que esta en este mismo repositorio
  }
  publishers {
  	mailer('correojenkins09@gmail.com', true, true) //Se envia una notificacion si la ejecución de la tarea falla
  }
}
