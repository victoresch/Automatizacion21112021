#Author: victoresch@hotmail.com
#language:es

Característica: Autenticacion en la tienda

  como un usuario de la tienda web
  quiero autenticarme
  para comprar prendas


  Esquema del escenario: autenticacion exitosa
    Dado El que el actor cuenta con los datos de autenticacion
    Cuando el usuario el realiza la autenticacion
      | correoUsuario   | claveUsuario   |
      | <correoUsuario> | <claveUsuario> |
    Entonces el debe ver el titulo MY ACCOUNT


    Ejemplos:
      | correoUsuario        | claveUsuario |
      | vhugoe8815@gmail.com | 1234567890   |

  Esquema del escenario: autenticacion fallida
    Dado El que el actor cuenta con los datos de autenticacion erroneos
    Cuando el usuario el realiza la autenticacion
      | correoUsuario   | claveUsuario   |
      | <correoUsuario> | <claveUsuario> |
    Entonces el debe ver el error Authentication failed.

    Ejemplos:
      | correoUsuario        | claveUsuario |
      | vhugoe8815@gmail.com | 1111111111   |
