#!/bin/bash
echo "Saludos, explorador/a del mundo $mundo"
if [ "$espia" = "true" ]
then
    echo "La operación secreta está en marcha, agente Z. Proceda con precaución."
else
    echo "Bienvenido al territorio desconocido, viajero/a $usuario. Mantente alerta."
fi
echo "..."
sleep 10
echo "¡Suerte!"
