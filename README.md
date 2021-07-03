# Héroes y Villanos

#### Principales Cambios del diseño Original:

Se agregó una interfaz llamada Operacion que es un wrapper de la interfaz BiFunction<Float, Float, Float>

La idea principal es que el cálculo del valor de los objetos tipo AtributoOperacion provenga de un objeto tipo Operacion.

En AtributoOperacion se agregó un constructor ``AtributoOperacion(String key1, String key2, Operacion o)``, el cual se comporta como el constructor especificado en la imagen y además agrega la operación.

Como el constructor que no recibe el objeto Operacion también es válido, se agregó una función ``public boolean setOperacion(Operacion o)`` para que se permita agregar Operacion luego de ser creado.

#### Decisiones de implementación

##### Desempates
Cuando hay empates absolutos (sin ningún criterio mas para desempatar), el ganador se decide de manera aleatoria

###### Liga dentro de si misma
Decidí que las ligas no pueden estar dentro de si misma para evitar posibles problemas de recursión.

###### AtributosCondicionales dentro de AtributosCondicionales
Algo parecido a lo de las ligas, esta decisión fue destinada a evitar loops indeseados entre AtributosCondicionales. Aunque la manera de hacerlo me parece menos satisfactoria y mas restrictiva que la implementada con Liga.

###### ComparatorCompuesto no puede agregarse a si mismo
Los mismo que en los ítems anteriores ComparadorCompuesto no puede agregarse a si mismo.

###### LinkedList como implementación de List
Elegí linkedList ya que la mayoría de operaciones son se agregar elementos y hay pocas operaciones de randomAccess.  



