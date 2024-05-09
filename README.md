# 1 Ejteechi.
Proyecto de Diseño de Software - Equipo 1

# 2 Instrucciones para solucionar errores.

#   2.1 Solución por complilación.
Recomendamos compilar todos los proyectos del programa en caso de que ocurran errores de dependencia.
El orden de compilación es el siguiente:
    1. Persistencia
    2. DTOs
    3. ObtenerImagenesMapa
    4. ObjetosNegocio
    5. Todos los subsistemas (MostrarMapa, IniciarSesion, CrearCuentaCliente, AdministrarQuejas, AdministrarTickets, etc)
    6. Presentación.

#   2.2 Solución por remoción de dependencias.
Si tras haber seguido los pasos de compilación siguen apareciendo errores de artefactos, identifique el proyecto donde se generan los errores (por lo general es en Presentacion) y vea qué artefacto no se puede resolver. Vaya a las dependencias del proyecto y remueva las dependencias conflictivas, luego vuelva a agregar dichas dependencias y recomendamos seguir los pasos de compilación del punto 2.1.